package com.example.demo.api.dto;

import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.CategoriaEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private AutorEntity autor;
    private CategoriaEntity categoria;
}
