package br.unitins.topicos1.dto;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Municipio;
import br.unitins.topicos1.model.Usuario;


public record EnderecoResponseDTO(
        Long id,
        String logradouro,
        String bairro,
        String numero,
        String complemento,
        String cep,
        Municipio municipio
        
) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getCep(),
                endereco.getMunicipio()

        );
    }

}
