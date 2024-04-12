package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.EdicaoEspecialDTO;
import br.unitins.topicos1.dto.EdicaoEspecialResponseDTO;
import br.unitins.topicos1.model.EdicaoEspecial;
import br.unitins.topicos1.repository.EdicaoEspecialRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EdicaoEspecialServiceImpl implements EdicaoEspecialService{

    @Inject
    private EdicaoEspecialRepository repository;

    @Override
    public EdicaoEspecialResponseDTO insert(EdicaoEspecialDTO dto) {
        EdicaoEspecial novaEdicaoEspecial = new EdicaoEspecial();
        novaEdicaoEspecial.setDescricao(dto.descricao());
        novaEdicaoEspecial.setConteudoAdicional(dto.conteudoAdicional());
        novaEdicaoEspecial.setPrecoExtra(dto.precoExtra());

        repository.persist(novaEdicaoEspecial);

        return EdicaoEspecialResponseDTO.valueOf(novaEdicaoEspecial);
    }

    @Override
    public EdicaoEspecialResponseDTO update(Long id, EdicaoEspecialDTO dto) {
        EdicaoEspecial edicaoEspecial = repository.findById(id);
        if (edicaoEspecial != null){
            edicaoEspecial.setDescricao(dto.descricao());
            edicaoEspecial.setConteudoAdicional(dto.conteudoAdicional());
            edicaoEspecial.setPrecoExtra(dto.precoExtra());
        } else
            throw new NotFoundException();

        return EdicaoEspecialResponseDTO.valueOf(edicaoEspecial);
    }

    @Override
    public void delete(Long id) {
        EdicaoEspecial edicaoEspecial = repository.findById(id);
        if (edicaoEspecial == null)
            throw new NotFoundException();

        repository.delete(edicaoEspecial);
    }

    @Override
    public EdicaoEspecialResponseDTO findById(Long id) {
        EdicaoEspecial edicaoEspecial = repository.findById(id);
        if (edicaoEspecial == null)
            throw new NotFoundException();

        return EdicaoEspecialResponseDTO.valueOf(edicaoEspecial);
    }

    @Override
    public List<EdicaoEspecialResponseDTO> findByDescricao(String descricao) {
        return repository.findByDescricao(descricao).stream()
            .map(a -> EdicaoEspecialResponseDTO.valueOf(a)).toList();
    }
    
    @Override
    public List<EdicaoEspecialResponseDTO> findByConteudoAdicional(String conteudoAdicional) {
        return repository.findByConteudoAdicional(conteudoAdicional).stream()
            .map(a -> EdicaoEspecialResponseDTO.valueOf(a)).toList();
    }
    
    @Override
    public List<EdicaoEspecialResponseDTO> findByPrecoExtra(Float precoExtra) {
        return repository.findByPrecoExtra(precoExtra).stream()
            .map(a -> EdicaoEspecialResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<EdicaoEspecialResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(EdicaoEspecialResponseDTO::valueOf).collect(Collectors.toList());
    }

}
