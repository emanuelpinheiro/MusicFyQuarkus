package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.TipoCartao;

public record CartaoCreditoDTO(
    TipoCartao tipoCartao,
    String numeroCartao,
    String nomeImpressoCartao,
    String cpfTitular,
    LocalDate dataValidade,
    String codigoSeguranca
) {
    
}
