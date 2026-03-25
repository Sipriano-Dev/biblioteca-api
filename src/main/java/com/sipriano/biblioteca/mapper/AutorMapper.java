package com.sipriano.biblioteca.mapper;

import com.sipriano.biblioteca.domain.Autor;
import com.sipriano.biblioteca.dto.AutorRequestDTO;
import com.sipriano.biblioteca.dto.AutorResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorResponseDTO toDTO(Autor entity) {
        return new AutorResponseDTO(
                entity.getId(), entity.getNome(), entity.getDataNascimento(), entity.getNacionalidade()
        );
    }

    public Autor toEntity(AutorRequestDTO dto) {
        Autor autor = new Autor();
        autor.setNome(dto.nome());
        autor.setDataNascimento(dto.dataNascimento());
        autor.setNacionalidade(dto.nacionalidade());
        return autor;
    }

}
