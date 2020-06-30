package com.jhemeson.ferramentaprodutividadeback.controller;

import com.jhemeson.ferramentaprodutividadeback.dto.MessageResponseDTO;
import com.jhemeson.ferramentaprodutividadeback.dto.ProjetoDTO;
import com.jhemeson.ferramentaprodutividadeback.entity.Projeto;
import com.jhemeson.ferramentaprodutividadeback.service.ProjetoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projetos")
public class ProjetoController {

    private ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    // listar
    @GetMapping
    public List<Projeto> findAll() {
        return projetoService.findAll();
    }

    // encontrar por id
    @GetMapping("/{id}")
    public ProjetoDTO findById(@PathVariable Long id) throws NotFoundException {
        return projetoService.findById(id);
    }

    // deletar por id
    @DeleteMapping("/{id}")
    public MessageResponseDTO deleteById(@PathVariable Long id) throws NotFoundException {
        if(projetoService.findById(id) != null){
            return projetoService.deleteById(id);
        } else {
            return MessageResponseDTO.builder().
                    message("Projeto não encontrado.")
                    .build();
        }
    }

    // limpar base (deletar todos)
    @DeleteMapping("/deleteAll")
    public MessageResponseDTO deleteAll() {
        return projetoService.deleteAll();
    }

    // adicionar
    @PostMapping
    public MessageResponseDTO create(@RequestBody ProjetoDTO projetoDTO) {
        return projetoService.create(projetoDTO);
    }

    // atualizar
}
