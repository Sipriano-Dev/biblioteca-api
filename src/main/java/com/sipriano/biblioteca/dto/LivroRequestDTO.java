package com.sipriano.biblioteca.dto;

import com.sipriano.biblioteca.domain.enums.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroRequestDTO(

        @NotBlank(message = "Campo obrigatório")
        String titulo,

        @NotBlank(message = "Campo obrigatório")
        @ISBN
        String isbn,

        @NotNull(message = "Campo obrigatório")
        @Past(message = "Não pode ser uma data futura")
        LocalDate dataPublicacao,

        GeneroLivro genero,

        BigDecimal preco,

        @NotNull(message = "Campo obrigatório")
        Long autorId
) {
}
