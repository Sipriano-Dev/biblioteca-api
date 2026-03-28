package com.sipriano.biblioteca.dto;

import com.sipriano.biblioteca.domain.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroRequestDTO(

        String titulo,
        String isbn,
        LocalDate dataPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        Long autorId
) {
}
