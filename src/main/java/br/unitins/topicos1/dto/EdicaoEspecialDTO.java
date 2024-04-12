package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record EdicaoEspecialDTO (

    @NotBlank(message = "A descrição deve ser informado")
    String descricao,

    @NotBlank(message = "O conteúdo adicional ser informado")
    String conteudoAdicional,

    @NotBlank(message = "O preço extra ser informado")
    Float precoExtra
) {

    
}
