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
@Table(name = "TB_AUTORES")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "autorSequence")
    @SequenceGenerator(name = "autorSequence", sequenceName = "SEQ_AUTOR", allocationSize = 1)
    @Column(name = "COD_AUTOR")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 60)
    private String nome;

    @Column(name = "NACIONALIDADE", nullable = false, length = 30)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    private List<LivroEntity> livros;
}
