package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record CDDTO (

    @NotBlank(message = "O nome do CD deve ser informado.")
    String nome,

    @NotBlank(message = "O álbum do CD deve ser informado.")
    Long id_album,

    @NotBlank(message = "O artista do CD deve ser informado.")
    Long id_artista,

    @NotBlank(message = "A gravadora do CD deve ser informada.")
    Long id_gravadora,

    @NotBlank(message = "A descrição do CD deve ser informada.")
    String descricao,

    @NotBlank(message = "O preço do CD deve ser informado.")
    Double preco,

    @NotBlank(message = "O estoque do CD deve ser informado.")
    Integer estoque
) {
    
}
