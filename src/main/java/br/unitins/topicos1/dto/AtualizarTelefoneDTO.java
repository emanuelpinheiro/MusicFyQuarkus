package br.unitins.topicos1.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;


public record AtualizarTelefoneDTO(
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String senhaAtual,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    List<TelefoneDTO> listaTelefones

) {

}
