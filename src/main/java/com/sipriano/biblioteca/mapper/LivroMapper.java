package com.sipriano.biblioteca.mapper;

import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.domain.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public LivroResponseDTO toDTO(Livro entity) {
        LivroResponseDTO dto = new LivroResponseDTO(
                entity.getId(), entity.getTitulo(), entity.getIsbn(), entity.getDataPublicacao()
        );

        return dto;
    }

}
