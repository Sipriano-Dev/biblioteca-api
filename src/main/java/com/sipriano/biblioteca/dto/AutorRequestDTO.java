package com.sipriano.biblioteca.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AutorRequestDTO (
        @NotBlank(message = "Precisa de um nome válido!")
        String nome,

        @NotNull(message = "Data de nascimento não pode ser null!")
        @Past(message = "Data de nascimento precisa ser anterior a data atual!")
        LocalDate dataNascimento,

        @NotBlank(message = "Precisa de uma Nacionalidade válida!")
        String nacionalidade
) {
}
