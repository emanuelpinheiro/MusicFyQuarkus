package br.unitins.topicos1.model;

import jakarta.validation.constraints.NotBlank;

public class Faixa extends DefaultEntity {

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
