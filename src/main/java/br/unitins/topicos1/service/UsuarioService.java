package br.unitins.topicos1.service;

import java.util.List;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.AtualizarEmailDTO;
import br.unitins.topicos1.dto.AtualizarNomeDTO;
import br.unitins.topicos1.dto.AtualizarSenhaDTO;
import br.unitins.topicos1.dto.AtualizarTelefoneDTO;
import br.unitins.topicos1.dto.CadastroUsuarioDTO;
import br.unitins.topicos1.dto.CadastroUsuarioResponseDTO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

public interface UsuarioService {

    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) throws ConstraintViolationException;

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll(); 

    public UsuarioResponseDTO updateSenha(@Valid AtualizarSenhaDTO dto, String login);

    public UsuarioResponseDTO updateNome(@Valid AtualizarNomeDTO dto, String login);

    public UsuarioResponseDTO updateEmail(@Valid AtualizarEmailDTO dto, String login);

    public UsuarioResponseDTO updateTelefone(@Valid AtualizarTelefoneDTO dto, String login);

    public CadastroUsuarioResponseDTO cadastrarUsuario (@Valid CadastroUsuarioDTO dto);

    public CadastroUsuarioResponseDTO findByLoginAndSenhaPerfil(String login, String senha);

    long count();
    
}
