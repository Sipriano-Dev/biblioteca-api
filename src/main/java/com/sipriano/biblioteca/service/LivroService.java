package com.sipriano.biblioteca.service;

import com.sipriano.biblioteca.domain.Livro;
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

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

}
