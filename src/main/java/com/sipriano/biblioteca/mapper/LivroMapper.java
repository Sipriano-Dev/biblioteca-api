package com.sipriano.biblioteca.mapper;

import com.sipriano.biblioteca.domain.Autor;
import com.sipriano.biblioteca.dto.LivroRequestDTO;
import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LivroMapper {

    private AutorMapper autorMapper = new AutorMapper();
    private AutorRepository autorRepository;

    public LivroResponseDTO toDTO(Livro entity) {
        return new LivroResponseDTO(
                entity.getId(), entity.getTitulo(), entity.getIsbn(), entity.getAutor().getId(), entity.getDataPublicacao()
        );
    }

    public Livro toEntity(LivroRequestDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setDataPublicacao(dto.dataPublicacao());

        Autor autor = autorRepository.findById(dto.autorId()).orElse(null);
        livro.setAutor(autor);

        return livro;
    }

}
