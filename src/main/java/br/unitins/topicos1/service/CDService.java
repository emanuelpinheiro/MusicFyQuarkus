package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CDDTO;
import br.unitins.topicos1.dto.CDResponseDTO;
import jakarta.validation.Valid;

public interface CDService {
      
     public CDResponseDTO insert(@Valid CDDTO dto);
    
     public CDResponseDTO update(Long id, @Valid CDDTO dto);
    
     public void delete(Long id);
    
     public CDResponseDTO findById(Long id);
    
     public List<CDResponseDTO> findByNome(String nome);
    
     public List<CDResponseDTO> findByAll();
}