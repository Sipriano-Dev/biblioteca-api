package com.sipriano.biblioteca.controller;

import com.sipriano.biblioteca.domain.enums.GeneroLivro;
import com.sipriano.biblioteca.dto.LivroRequestDTO;
import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController implements GenericController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> salvar(@RequestBody @Valid LivroRequestDTO requestDTO) {
        LivroResponseDTO responseDTO = livroService.salvar(requestDTO);
        return ResponseEntity.created(generateUri(responseDTO.id())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<LivroResponseDTO>> listar(
            @RequestParam(required = false, value = "titulo") String titulo,
            @RequestParam(required = false, value = "isbn") String isbn,
            @RequestParam(required = false, value = "anoPublicacao") Integer anoPublicacao,
            @RequestParam(required = false, value = "genero") GeneroLivro genero,
            @RequestParam(required = false, value = "nomeAutor") String nomeAutor,
            @RequestParam(required = false, value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(required = false, value = "tamanhoPagina", defaultValue = "10") Integer tamanhoPagina
    ) {
        return ResponseEntity.ok(livroService.listar(titulo, isbn, anoPublicacao, genero, nomeAutor, pagina, tamanhoPagina));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid LivroRequestDTO requestDTO) {
        return ResponseEntity.ok(livroService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
