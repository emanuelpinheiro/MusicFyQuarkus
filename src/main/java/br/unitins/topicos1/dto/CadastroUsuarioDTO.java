package br.unitins.topicos1.dto;

import java.util.List;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastroUsuarioDTO (
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    @NotBlank(message = "O campo login não pode ser nulo.")
    String login,
    @Email
    String email,
    @NotBlank(message = "O campo senha não pode ser nulo.")
    String senha,

    @NotNull
    Integer idPerfil,


    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido ---- Ex. 999.999.999-99")
    String cpf,
    @Valid
    List<TelefoneDTO> listaTelefone 
) {

}
