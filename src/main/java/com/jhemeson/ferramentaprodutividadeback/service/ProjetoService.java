package com.jhemeson.ferramentaprodutividadeback.service;

import com.jhemeson.ferramentaprodutividadeback.dto.MessageResponseDTO;
import com.jhemeson.ferramentaprodutividadeback.dto.ProjetoDTO;
import com.jhemeson.ferramentaprodutividadeback.entity.Projeto;
import com.jhemeson.ferramentaprodutividadeback.mapper.ProjetoMapper;
import com.jhemeson.ferramentaprodutividadeback.repository.ProjetoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    private ProjetoRepository projetoRepository;
    private final ProjetoMapper projetoMapper = ProjetoMapper.INSTANCE;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public MessageResponseDTO create(ProjetoDTO projetoDTO) {
        Projeto projetoToCreate = projetoMapper.toModel(projetoDTO);
        Projeto projetoCreated = projetoRepository.save(projetoToCreate);

        return MessageResponseDTO.builder().
                message(projetoCreated.getNome() + " foi adicionado à base de dados com o ID:" + projetoCreated.getId())
                .build();
    }

    public List<Projeto> findAll() {
        List<Projeto> projetos = projetoRepository.findAll();
        return projetos;
    }

    public ProjetoDTO findById(Long id) throws NotFoundException {
        Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
        return projetoMapper.toDTO(projeto);
    }

    public void deleteById(Long id) {
        projetoRepository.deleteById(id);
    }

    public void deleteAll() {
        projetoRepository.deleteAll();
    }
}
