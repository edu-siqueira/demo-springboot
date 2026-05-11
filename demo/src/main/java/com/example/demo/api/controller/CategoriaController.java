package com.example.demo.api.controller;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaEntity> listarTodos() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaEntity buscarPorId(@PathVariable Long id) {
        return categoriaService.categoriaFindById(id);
    }

    @PostMapping
    public CategoriaEntity incluir(@RequestBody CategoriaDTO dto) {
        return categoriaService.incluir(dto);
    }

    @PutMapping("/{id}")
    public CategoriaEntity alterar(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        return categoriaService.alterar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return categoriaService.deletar(id);
    }
}