package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.FaixaDTO;
import br.unitins.topicos1.dto.FaixaResponseDTO;
import br.unitins.topicos1.model.ClassificacaoEtaria;
import br.unitins.topicos1.model.Compositor;
import br.unitins.topicos1.model.Faixa;
import br.unitins.topicos1.repository.ArtistaRepository;
import br.unitins.topicos1.repository.ClassificacaoEtariaRepository;
import br.unitins.topicos1.repository.CompositorRepository;
import br.unitins.topicos1.repository.FaixaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FaixaServiceImpl implements FaixaService{
    
    @Inject
    FaixaRepository repository;

    @Inject
    Validator validator;

    @Inject
    ArtistaRepository artistaRepository;

    @Inject
    CompositorRepository compositorRepository;

    @Inject
    ClassificacaoEtariaRepository classificacaoEtariaRepository;

    private void validar(FaixaDTO faixaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<FaixaDTO>> violations = validator.validate(faixaDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    @Transactional
    public FaixaResponseDTO insert(@Valid FaixaDTO faixaDto) {
        validar(faixaDto);
        Faixa novoFaixa = new Faixa();
        novoFaixa.setTitulo(faixaDto.titulo());
        novoFaixa.setArtista(artistaRepository.findById(faixaDto.id_artista()));
        novoFaixa.setCompositor(compositorRepository.findById(faixaDto.id_compositor()));
        novoFaixa.setClassificacaoEtaria(classificacaoEtariaRepository.findById(faixaDto.id_classificacao_etaria()));
        novoFaixa.setDuracao(faixaDto.duracao());
        novoFaixa.setNumero(faixaDto.numero());


        repository.persist(novoFaixa);

        return FaixaResponseDTO.valueOf(novoFaixa);
    }

    @Override
    @Transactional
    public FaixaResponseDTO update(FaixaDTO faixaDto, Long id) {

        Faixa novoFaixa = repository.findById(id);
        if (novoFaixa != null){
            novoFaixa.setTitulo(faixaDto.titulo());
            novoFaixa.setArtista(artistaRepository.findById(faixaDto.id_artista()));
            novoFaixa.setCompositor(compositorRepository.findById(faixaDto.id_compositor()));
            novoFaixa.setClassificacaoEtaria(classificacaoEtariaRepository.findById(faixaDto.id_classificacao_etaria()));
            novoFaixa.setDuracao(faixaDto.duracao());
            novoFaixa.setNumero(faixaDto.numero());
        } else
            throw new NotFoundException();

        return FaixaResponseDTO.valueOf(novoFaixa);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        Faixa faixa = repository.findById(id);
        if (faixa != null)
            repository.delete(faixa);
        else
            throw new NotFoundException();
        }

    @Override
    public FaixaResponseDTO findById(Long id) {
        Faixa faixa = repository.findById(id);
        return faixa != null ? FaixaResponseDTO.valueOf(faixa) : null;
    }

    @Override
    public List<FaixaResponseDTO> findByName(String nome) {
        return repository.findByName(nome).stream()
            .map(a -> FaixaResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<FaixaResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(a -> FaixaResponseDTO.valueOf(a)).toList();
    }
}
