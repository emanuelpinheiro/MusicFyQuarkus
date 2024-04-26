package br.unitins.topicos1.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
    Long id,

    @NotBlank(message = "O campo logradouro não pode estar vazio")
    String logradouro,

    @NotBlank(message = "O campo bairro não pode estar vazio")
    String bairro,

    @NotBlank(message = "O campo número não pode estar vazio")
    String numero,

    String complemento,

    @NotBlank(message = "O campo cep não pode estar vazio")
    String cep,

    @NotNull(message = "O campo precisa ser preenchido.")
    
    Long idMunicipio

    
) {

  
}
