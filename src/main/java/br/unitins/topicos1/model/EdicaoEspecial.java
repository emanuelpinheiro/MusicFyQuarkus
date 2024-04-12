package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class EdicaoEspecial extends DefaultEntity{

    @NotBlank(message = "A descrição deve ser informada")
    @Column(length = 200)
    private String descricao;

    @NotBlank(message = "O conteúdo adicional deve ser informado")
    @Column(length = 200)
    private String conteudoAdicional;

    @NotBlank(message = "O preço extra deve ser informado")
    @Column(length = 200)
    private Float precoExtra;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConteudoAdicional() {
        return conteudoAdicional;
    }

    public void setConteudoAdicional(String conteudoAdicional) {
        this.conteudoAdicional = conteudoAdicional;
    }

    public Float getPrecoExtra() {
        return precoExtra;
    }

    public void setPrecoExtra(Float precoExtra) {
        this.precoExtra = precoExtra;
    }
}
