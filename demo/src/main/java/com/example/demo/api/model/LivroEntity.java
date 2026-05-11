package com.example.demo.api.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LIVROS")
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "livroSequence")
    @SequenceGenerator(name = "livroSequence", sequenceName = "SEQ_LIVRO", allocationSize = 1)
    @Column(name = "COD_LIVRO")
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 60)
    private String titulo;

    @Column(name = "ISBN", nullable = false, length = 13)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", foreignKey = @ForeignKey(name = "FK_LIVRO_AUTOR"))
    private AutorEntity autor;

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID", foreignKey = @ForeignKey(name = "FK_LIVRO_CATEGORIA"))
    private CategoriaEntity categoria;
}
