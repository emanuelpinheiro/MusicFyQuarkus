package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.EdicaoEspecial;

public record EdicaoEspecialResponseDTO(
    Long id,
    String descricao,
    String conteudoAdicional,
    Float precoExtra
) {
    public static EdicaoEspecialResponseDTO valueOf(EdicaoEspecial edicaoEspecial){
        return new EdicaoEspecialResponseDTO (edicaoEspecial.getId(), edicaoEspecial.getDescricao(), edicaoEspecial.getConteudoAdicional(), edicaoEspecial.getPrecoExtra());
    }
}