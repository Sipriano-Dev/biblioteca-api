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

    private final AutorRepository autorRepository;

    public LivroResponseDTO toDTO(Livro entity) {
        return new LivroResponseDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getIsbn(),
                entity.getDataPublicacao(),
                entity.getGenero(),
                entity.getPreco(),
                entity.getAutor().getId()
                );
    }

    public Livro toEntity(LivroRequestDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setDataPublicacao(dto.dataPublicacao());
        livro.setGenero(dto.genero());
        livro.setPreco(dto.preco());

        Autor autor = autorRepository.findById(dto.autorId()).orElse(null);
        livro.setAutor(autor);

        return livro;
    }

}
