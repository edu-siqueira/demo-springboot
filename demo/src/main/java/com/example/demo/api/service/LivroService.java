package com.example.demo.api.service;

import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroEntity> listarTodos(){
        return livroRepository.findAll();
    }
    public LivroEntity incluir(LivroDTO dto) {
        LivroEntity entity = LivroEntity.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .autor(dto.getAutor())
                .categoria(dto.getCategoria())
                .build();
        return livroRepository.save(entity);
    }

    public LivroEntity alterar(Long id, LivroDTO dto) {
        LivroEntity objeto = livroFindById(id);
        objeto.setTitulo(dto.getTitulo());
        objeto.setIsbn(dto.getIsbn());
        objeto.setAutor(dto.getAutor());
        objeto.setCategoria(dto.getCategoria());
        return livroRepository.save(objeto);
    }

    public ResponseEntity deletar(Long id) {
        livroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    public LivroEntity livroFindById(Long id) {
        return livroRepository.findById(id).get();
    }

}
