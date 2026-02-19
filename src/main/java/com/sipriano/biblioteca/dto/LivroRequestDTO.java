package com.sipriano.biblioteca.dto;

import java.time.LocalDate;

public record LivroRequestDTO(

        String titulo,
        String isbn,
        String autor,
        LocalDate dataPublicacao
) {
}
