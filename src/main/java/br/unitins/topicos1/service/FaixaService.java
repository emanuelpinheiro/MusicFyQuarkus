package br.unitins.topicos1.service;

import java.util.List;
import br.unitins.topicos1.model.Faixa;

import br.unitins.topicos1.dto.FaixaDTO;
import br.unitins.topicos1.dto.FaixaResponseDTO;
import jakarta.validation.Valid;

public interface FaixaService {

    public FaixaResponseDTO insert(@Valid FaixaDTO dto);

    public FaixaResponseDTO update(FaixaDTO dto, Long id);

    public void delete(Long id);

    public FaixaResponseDTO findById(Long id);    

    public List<FaixaResponseDTO> findByName(String nome);    

    public List<FaixaResponseDTO> findByAll();


    
}
