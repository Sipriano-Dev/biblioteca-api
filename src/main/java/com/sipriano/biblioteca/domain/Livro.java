package com.sipriano.biblioteca.domain;

import com.sipriano.biblioteca.domain.base.Auditoria;
import com.sipriano.biblioteca.domain.enums.GeneroLivro;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Livro extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 20)
    private String isbn;

    @Column(nullable = false, name = "data_publicacao")//só por exemplo, pois não precisaria
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private GeneroLivro genero;

    @Column(length = 20, precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(nullable = false, name = "autor_id")
    private Autor autor;

}
