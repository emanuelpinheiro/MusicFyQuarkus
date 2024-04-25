package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;

import br.unitins.topicos1.dto.CDDTO;
import br.unitins.topicos1.dto.CDResponseDTO;
import br.unitins.topicos1.model.CD;
import br.unitins.topicos1.repository.AlbumRepository;
import br.unitins.topicos1.repository.ArtistaRepository;
import br.unitins.topicos1.repository.CDRepository;
import br.unitins.topicos1.repository.GravadoraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CDServiceImpl implements CDService {
    
    @Inject
    CDRepository repository;

    @Inject
    Validator validator;

    @Inject
    ArtistaRepository artistaRepository;

    @Inject
    AlbumRepository albumRepository;

    @Inject
    GravadoraRepository gravadoraRepository;
    
    private void validar(CDDTO cdDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<CDDTO>> violations = validator.validate(cdDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    public CDResponseDTO insert(@Valid CDDTO cdDto) {
        validar(cdDto);
        CD novoCD = new CD();
        novoCD.setNome(cdDto.nome());
        novoCD.setAlbum(albumRepository.findById(cdDto.id_album()));
        novoCD.setArtista(artistaRepository.findById(cdDto.id_artista()));
        novoCD.setGravadora(gravadoraRepository.findById(cdDto.id_gravadora()));
        novoCD.setDescricao(cdDto.descricao());
        novoCD.setPreco(cdDto.preco());
        novoCD.setEstoque(cdDto.estoque());

        repository.persist(novoCD);

        return CDResponseDTO.valueOf(novoCD);
    }

    @Override
    public CDResponseDTO update(Long id, CDDTO cdDto) {
        CD cd = repository.findById(id);
        if (cd != null){
            cd.setNome(cdDto.nome());
            cd.setAlbum(albumRepository.findById(cdDto.id_album()));
            cd.setArtista(artistaRepository.findById(cdDto.id_artista()));
            cd.setGravadora(gravadoraRepository.findById(cdDto.id_gravadora()));
            cd.setDescricao(cdDto.descricao());
            cd.setPreco(cdDto.preco());
            cd.setEstoque(cdDto.estoque());
        } else
            throw new NotFoundException();

        return CDResponseDTO.valueOf(cd);
    }

    @Override
    public void delete(Long id) {
        CD cd = repository.findById(id);
        if (cd != null)
            repository.delete(cd);
        else
            throw new NotFoundException();
    }

    @Override
    public CDResponseDTO findById(Long id) {
        CD cd = repository.findById(id);
        if (cd != null)
            return CDResponseDTO.valueOf(cd);
        return null;
    }

    @Override
    public List<CDResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(a -> CDResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<CDResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(a -> CDResponseDTO.valueOf(a)).toList();
    }
}
