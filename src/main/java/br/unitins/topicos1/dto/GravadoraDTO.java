package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record GravadoraDTO(

    @NotBlank(message = "O nome deve ser informado")
    String nome
) {
    
}
