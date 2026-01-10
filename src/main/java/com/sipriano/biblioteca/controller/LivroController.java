package com.sipriano.biblioteca.controller;

import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.service.LivroService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return livroService.listar();
    }

}
