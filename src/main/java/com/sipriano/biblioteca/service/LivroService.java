package com.sipriano.biblioteca.service;

import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.mapper.LivroMapper;
import com.sipriano.biblioteca.repository.LivroRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class LivroService {

    final LivroRepository livroRepository;
    final LivroMapper livroMapper;

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<LivroResponseDTO> listar() {
        return livroRepository.findAll().stream().map(livroMapper::toDTO).toList();
    }

    public LivroResponseDTO buscarPorId(Long id) {
        return livroRepository.findById(id).map(livroMapper::toDTO).orElse(null);
    }

    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }

}
