package com.sipriano.biblioteca.service;

import com.sipriano.biblioteca.dto.LivroRequestDTO;
import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.mapper.LivroMapper;
import com.sipriano.biblioteca.repository.LivroRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class LivroService {

    final LivroRepository livroRepository;
    final LivroMapper livroMapper;

    public LivroResponseDTO salvar(LivroRequestDTO dto) {
        Livro livro = livroMapper.toEntity(dto);
        return livroMapper.toDTO(livroRepository.save(livro));
    }

    public List<LivroResponseDTO> listar() {
        return livroRepository.findAll().stream().map(livroMapper::toDTO).toList();
    }

    public LivroResponseDTO buscarPorId(Long id) {
        return livroRepository.findById(id).map(livroMapper::toDTO).orElse(null);
    }

    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
        Livro livro = livroMapper.toEntity(dto);
        livro.setId(id);
        return livroMapper.toDTO(livroRepository.save(livro));
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }

}
