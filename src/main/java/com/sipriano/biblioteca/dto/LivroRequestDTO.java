package com.sipriano.biblioteca.dto;

import java.time.LocalDate;

public record LivroRequestDTO(

        String titulo,
        String isbn,
        Long autorId,
        LocalDate dataPublicacao
) {
}
