package com.example.demo.api.model;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CATEGORIAS")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "categoriaSequence")
    @SequenceGenerator(name = "categoriaSequence", sequenceName = "SEQ_CATEGORIA", allocationSize = 1)
    @Column(name = "COD_CATEGORIA")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 60)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<LivroEntity> livros;
}
