package br.unitins.topicos1.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record UsuarioDTO (

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    @NotBlank(message = "O campo login não pode ser nulo.")
    String login,

    @Email
    String email,

    @NotBlank(message = "O campo senha não pode ser nulo.")
    @Size(min = 3, max = 15)
    String senha,


    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido ---- Ex. 999.999.999-99")
    String cpf,
    @Valid
    List<TelefoneDTO> listaTelefone 
) {

}
