package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorEntity> listarTodos() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public AutorEntity buscarPorId(@PathVariable Long id) {
        return autorService.autorFindById(id);
    }

    @PostMapping
    public AutorEntity incluir(@RequestBody AutorDTO dto) {
        return autorService.incluir(dto);
    }

    @PutMapping("/{id}")
    public AutorEntity alterar(@PathVariable Long id, @RequestBody AutorDTO dto) {
        return autorService.alterar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return autorService.deletar(id);
    }
}