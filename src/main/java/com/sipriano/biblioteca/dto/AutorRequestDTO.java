package com.sipriano.biblioteca.dto;

import java.time.LocalDate;

public record AutorRequestDTO (
        String nome,
        LocalDate dataNascimento,
        String nacionalidade
) {
}
