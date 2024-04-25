package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.CD;

public record CDResponseDTO (
    Long id,
    AlbumResponseDTO album,
    ArtistaResponseDTO artista,
    GravadoraResponseDTO gravadora,
    String descricao,
    Double preco,
    Integer estoque

) {
    public static CDResponseDTO valueOf(CD cd){
        return new CDResponseDTO(
            cd.getId(), 
            AlbumResponseDTO.valueOf(cd.getAlbum()), 
            ArtistaResponseDTO.valueOf(cd.getArtista()),
            GravadoraResponseDTO.valueOf(cd.getGravadora()),
            cd.getDescricao(),
            cd.getPreco(),
            cd.getEstoque()
        );
    }
    
}
