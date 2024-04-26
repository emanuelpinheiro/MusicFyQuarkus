package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Faixa;

public record FaixaResponseDTO(
    Long id,
    int numero,
    String titulo,
    String duracao,
    String compositor,
    String artista,
    String classificacaoEtaria

) {
        public static FaixaResponseDTO valueOf(Faixa faixa){
            return new FaixaResponseDTO(
                faixa.getId(),
                faixa.getNumero(),
                faixa.getTitulo(),
                faixa.getDuracao(),
                faixa.getCompositor().getNome(),
                faixa.getArtista().getNome(),
                faixa.getClassificacaoEtaria().getFaixaEtaria()
            );
    }
}
