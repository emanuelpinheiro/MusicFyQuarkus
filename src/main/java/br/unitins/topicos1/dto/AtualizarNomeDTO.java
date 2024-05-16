package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotEmpty;

public record AtualizarNomeDTO(   
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String senhaAtual,    
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String nome) {
}
