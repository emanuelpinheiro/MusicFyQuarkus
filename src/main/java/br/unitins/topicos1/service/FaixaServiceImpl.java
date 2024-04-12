package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.FaixaDTO;
import br.unitins.topicos1.dto.FaixaResponseDTO;
import br.unitins.topicos1.model.Faixa;
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

    private void validar(FaixaDTO faixaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<FaixaDTO>> violations = validator.validate(faixaDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    @Transactional
    public FaixaResponseDTO insert(@Valid FaixaDTO dto) {
        validar(dto);
        Faixa novoFaixa = new Faixa();
        novoFaixa.setNome(dto.nome());


        repository.persist(novoFaixa);

        return FaixaResponseDTO.valueOf(novoFaixa);
    }

    @Override
    @Transactional
    public FaixaResponseDTO update(FaixaDTO dto, Long id) {

        Faixa faixa = repository.findById(id);
        if (faixa != null){
            faixa.setNome(dto.nome());
        } else
            throw new NotFoundException();

        return FaixaResponseDTO.valueOf(faixa);
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
