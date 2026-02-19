package com.sipriano.biblioteca.mapper;

import com.sipriano.biblioteca.dto.LivroRequestDTO;
import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.domain.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public LivroResponseDTO toDTO(Livro entity) {
        return new LivroResponseDTO(
                entity.getId(), entity.getTitulo(), entity.getIsbn(), entity.getAutor(), entity.getDataPublicacao()
        );
    }

    public Livro toEntity(LivroRequestDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setAutor(dto.autor());
        livro.setDataPublicacao(dto.dataPublicacao());
        return livro;
    }

}
