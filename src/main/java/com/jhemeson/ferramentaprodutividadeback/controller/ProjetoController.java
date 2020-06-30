package com.jhemeson.ferramentaprodutividadeback.controller;

import com.jhemeson.ferramentaprodutividadeback.dto.MessageResponseDTO;
import com.jhemeson.ferramentaprodutividadeback.dto.ProjetoDTO;
import com.jhemeson.ferramentaprodutividadeback.service.ProjetoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projetos")
public class ProjetoController {

    private ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    // listar

    // encontrar por id
    @GetMapping("/{id}")
    public ProjetoDTO findById(@PathVariable Long id) throws NotFoundException {
        return projetoService.findById(id);
    }

    // deletar

    // adicionar
    @PostMapping
    public MessageResponseDTO create(@RequestBody ProjetoDTO projetoDTO) {
        return projetoService.create(projetoDTO);
    }

    // atualizar
}
