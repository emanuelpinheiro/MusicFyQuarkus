package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.CartaoCredito;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.TipoCartao;

public record CartaoCreditoResponseDTO( 

    Pedido idPedido,
    Double valor,
    TipoCartao tipoCartao,
    String numeroCartao,
    String nomeImpressoCartao,
    String cpfTitular,
    LocalDate dataValidade,
    String codigoSeguranca
){    public static CartaoCreditoResponseDTO valueOf(CartaoCredito cartao){
        return new CartaoCreditoResponseDTO(
            cartao.getPedido(),
            cartao.getValor(),
            cartao.getTipoCartao(),
            cartao.getNumeroDoCartao(),
            cartao.getNomeImpressoCartao(),
            cartao.getCpfDoTitular(),
            cartao.getDataValidade(),
            cartao.getCodigoSeguranca()
        );
    }
}
