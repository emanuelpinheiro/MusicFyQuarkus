package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Faixa;

public record FaixaResponseDTO(
    Long id,
    String nome

) {
        public static FaixaResponseDTO valueOf(Faixa faixa){
        return new FaixaResponseDTO(faixa.getId(), faixa.getNome());
    }
}
