package com.sipriano.biblioteca.controller;

import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.dto.LivroRequestDTO;
import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.service.LivroService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> salvar(@RequestBody LivroRequestDTO requestDTO) {
        LivroResponseDTO responseDTO = livroService.salvar(requestDTO);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(responseDTO.id())
                        .toUri()
        ).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listar() {
        return ResponseEntity.ok(livroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> atualizar(@PathVariable Long id, @RequestBody LivroRequestDTO requestDTO) {
        return ResponseEntity.ok(livroService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
