package com.sipriano.biblioteca.service;

import com.sipriano.biblioteca.domain.Autor;
import com.sipriano.biblioteca.dto.AutorRequestDTO;
import com.sipriano.biblioteca.dto.AutorResponseDTO;
import com.sipriano.biblioteca.mapper.AutorMapper;
import com.sipriano.biblioteca.repository.AutorRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class AutorService {

    final AutorRepository autorRepository;
    final AutorMapper autorMapper;

    public AutorResponseDTO salvar(AutorRequestDTO dto) {
        Autor autor = autorMapper.toEntity(dto);
        return autorMapper.toDTO(autorRepository.save(autor));
    }

    public List<AutorResponseDTO> listar(String nome, String nacionalidade) {
        if (nome == null && nacionalidade == null) {
            return autorRepository.findAll().stream().map(autorMapper::toDTO).toList();
        } else if (nacionalidade == null) {
            return autorRepository.findByNomeContainingIgnoreCase(nome).stream().map(autorMapper::toDTO).toList();
        } else if (nome == null) {
            return autorRepository.findByNacionalidadeContainingIgnoreCase(nacionalidade).stream().map(autorMapper::toDTO).toList();
        } else {
            return autorRepository.findByNomeContainingIgnoreCaseAndNacionalidadeContainingIgnoreCase(nome, nacionalidade).stream().map(autorMapper::toDTO).toList();
        }
    }

    public AutorResponseDTO buscarPorId(Long id) {
        return autorRepository.findById(id).map(autorMapper::toDTO).orElse(null);
    }

    public AutorResponseDTO atualizar(Long id, AutorRequestDTO dto) {
        Autor autor = autorMapper.toEntity(dto);
        autor.setId(id);
        return autorMapper.toDTO(autorRepository.save(autor));
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }

}

