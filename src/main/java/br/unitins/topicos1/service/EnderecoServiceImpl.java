package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;
import br.unitins.topicos1.model.Municipio;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.MunicipioRepository;
import br.unitins.topicos1.repository.EnderecoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    UsuarioRepository repositoryUser;

    @Inject
    EnderecoRepository repositoryEnd;

    @Inject
    MunicipioRepository repositoryMunicipio;

    @Inject
    UsuarioService usuarioService;


    @Override
    @Transactional
    public EnderecoResponseDTO insert( @Valid EnderecoDTO dto, Long idUsuario) {
        Usuario usuario = repositoryUser.findById(idUsuario); 
        Municipio municipio = repositoryMunicipio.findById(dto.idMunicipio());
        

        Endereco endereco = new Endereco();
        endereco.setBairro(dto.bairro());
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setMunicipio(municipio);

        usuario.getListaEndereco().add(endereco);

        repositoryEnd.persist(endereco);

        return EnderecoResponseDTO.valueOf(endereco);

    }

    @Override
    @Transactional
    public EnderecoResponseDTO update(Long idUsuario, Long idEndereco, EnderecoDTO enderecoDTO) {
        Usuario usuario = repositoryUser.findById(idUsuario);
        Endereco endereco = new Endereco();


        Municipio municipio = repositoryMunicipio.findById(enderecoDTO.idMunicipio());
        
                for (Endereco end : usuario.getListaEndereco()) {

                    if (end.getId().equals(idEndereco)) {
                        end.setBairro(enderecoDTO.bairro());
                        end.setCep(enderecoDTO.cep());
                        end.setLogradouro(enderecoDTO.logradouro());
                        end.setNumero(enderecoDTO.numero());
                        end.setComplemento(enderecoDTO.complemento());
                        endereco.setMunicipio(municipio);
                       

                        endereco = end;
                        repositoryEnd.persist(end);

                    
                }
        }

        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repositoryEnd.deleteById(id);
    }

    
    @Override
    public EnderecoResponseDTO findById(Long id) {
        return EnderecoResponseDTO.valueOf(repositoryEnd.findById(id));
    }

    @Override
    public List<EnderecoResponseDTO> findByCep(String cep) {
        return repositoryEnd.findByCep(cep).stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<EnderecoResponseDTO> findByAll() {
       return repositoryEnd.listAll().stream()
       .map(e -> EnderecoResponseDTO.valueOf(e)).toList();
    }

    }
