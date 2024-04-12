package br.unitins.topicos1.dto;
import br.unitins.topicos1.model.Faixa;

import jakarta.validation.constraints.NotBlank;

public record FaixaDTO(
    
    @NotBlank(message = "O nome deve ser informado")
    String nome


){

}
    

