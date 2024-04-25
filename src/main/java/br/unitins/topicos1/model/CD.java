package br.unitins.topicos1.model;

import jakarta.validation.constraints.NotBlank;

public class CD extends DefaultEntity {
    
    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O campo álbum é obrigatório.")
    private Album album;

    @NotBlank(message = "O campo artista é obrigatório.")
    private Artista artista;

    @NotBlank(message = "O campo gravadora é obrigatório.")
    private Gravadora gravadora;

    @NotBlank(message = "O campo descrição é obrigatório.")
    private String descricao;

    @NotBlank(message = "O campo preço é obrigatório.")
    private Double preco;

    @NotBlank(message = "O campo estoque é obrigatório.")
    private Integer estoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    
}
