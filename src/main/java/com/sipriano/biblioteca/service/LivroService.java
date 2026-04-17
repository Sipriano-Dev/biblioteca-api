package com.sipriano.biblioteca.service;

import com.sipriano.biblioteca.domain.Autor;
import com.sipriano.biblioteca.dto.LivroRequestDTO;
import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.exceptions.RegistroNaoEncontradoException;
import com.sipriano.biblioteca.mapper.LivroMapper;
import com.sipriano.biblioteca.repository.AutorRepository;
import com.sipriano.biblioteca.repository.LivroRepository;
import com.sipriano.biblioteca.validator.LivroValidator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class LivroService {

    final LivroRepository livroRepository;
    final AutorRepository autorRepository;
    final LivroValidator livroValidator;
    final LivroMapper livroMapper;

    public LivroResponseDTO salvar(LivroRequestDTO dto) {
        Livro livro = livroMapper.toEntity(dto);
        livroValidator.validar(livro);
        return livroMapper.toDTO(livroRepository.save(livro));
    }

    public List<LivroResponseDTO> listar() {
        return livroRepository.findAll().stream().map(livroMapper::toDTO).toList();
    }

    public LivroResponseDTO buscarPorId(Long id) {
        return livroRepository.findById(id).map(livroMapper::toDTO)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado"));
    }

    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setDataPublicacao(dto.dataPublicacao());
        livro.setGenero(dto.genero());
        livro.setPreco(dto.preco());
        Autor autor = autorRepository.findById(dto.autorId()).orElseThrow(() -> new RuntimeException("Autor não  encontrado!"));
        livro.setAutor(autor);
        livroValidator.validar(livro);
        return livroMapper.toDTO(livroRepository.save(livro));
    }

    public void deletar(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RegistroNaoEncontradoException("Livro não encontrado");
        }
        livroRepository.deleteById(id);
    }

}
