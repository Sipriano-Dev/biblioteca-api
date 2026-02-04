package com.sipriano.biblioteca.dto;

import java.time.LocalDate;

public record LivroResponseDTO(
        Long id,
        String titulo,
        String isbn,
        LocalDate dataPublicacao
) {}