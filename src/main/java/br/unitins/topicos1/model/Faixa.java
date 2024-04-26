package br.unitins.topicos1.model;

import jakarta.validation.constraints.NotBlank;

public class Faixa extends DefaultEntity {

    @NotBlank(message = "O número deve ser informado")
    private int numero;

    @NotBlank(message = "O título deve ser informado")
    private String titulo;

    @NotBlank(message = "A duração deve ser informada")
    private String duracao;

    @NotBlank(message = "O compositor deve ser informado")
    private Compositor compositor;

    @NotBlank(message = "O artista deve ser informado")
    private Artista artista;

    @NotBlank(message = "A classificação etária deve ser informada")
    private ClassificacaoEtaria classificacaoEtaria;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Compositor getCompositor() {
        return compositor;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public ClassificacaoEtaria getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(ClassificacaoEtaria classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

}
