package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EdicaoEspecialDTO;
import br.unitins.topicos1.dto.EdicaoEspecialResponseDTO;
import jakarta.validation.Valid;

public interface EdicaoEspecialService {
        
        public EdicaoEspecialResponseDTO insert(@Valid EdicaoEspecialDTO dto);
    
        public EdicaoEspecialResponseDTO update(Long id, @Valid EdicaoEspecialDTO dto);
    
        public void delete(Long id);
    
        public EdicaoEspecialResponseDTO findById(Long id);
    
        public List<EdicaoEspecialResponseDTO> findByDescricao(String descricao);

        public List<EdicaoEspecialResponseDTO> findByConteudoAdicional(String conteudoAdicional);

        public List<EdicaoEspecialResponseDTO> findByPrecoExtra(Float precoExtra);
    
        public List<EdicaoEspecialResponseDTO> findByAll();
    
}
