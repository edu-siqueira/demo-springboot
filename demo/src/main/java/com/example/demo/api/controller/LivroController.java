package com.example.demo.api.controller;


import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<LivroEntity>> listarTodos() {
        List<LivroEntity> lista = livroService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<List<LivroDTO>> incluir(@RequestBody LivroDTO request) {
        LivroEntity clienteEntity = livroService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<LivroEntity> alterar(@PathVariable Long id, @RequestBody LivroDTO request) {
        LivroEntity lista = livroService.alterar(id, request);
        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ResponseEntity> deletar(@PathVariable Long id) {
        ResponseEntity lista = livroService.deletar(id);
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<LivroEntity> clienteFindById(@PathVariable("id") Long id){
        LivroEntity entity = livroService.livroFindById(id);
        return ResponseEntity.ok(entity);
    }
}
