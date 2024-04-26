package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record FaixaDTO(
    
    @NotBlank(message = "O número deve ser informado")
    int numero,

    @NotBlank(message = "O título deve ser informado")
    String titulo,

    @NotBlank(message = "A duração deve ser informada")
    String duracao,

    @NotBlank(message = "O compositor deve ser informado")
    Long id_compositor,

    @NotBlank(message = "O artista deve ser informado")
    Long id_artista,

    @NotBlank(message = "A classificação etária deve ser informada")
    Long id_classificacao_etaria

){

}
    

