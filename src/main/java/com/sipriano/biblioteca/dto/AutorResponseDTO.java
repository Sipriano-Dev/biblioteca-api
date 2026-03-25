package com.sipriano.biblioteca.dto;

import java.time.LocalDate;

public record AutorResponseDTO(
        Long id,
        String nome,
        LocalDate dataNascimento,
        String nacionalidade
) {
}
