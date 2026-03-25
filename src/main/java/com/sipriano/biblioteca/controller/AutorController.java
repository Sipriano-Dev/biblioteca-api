package com.sipriano.biblioteca.controller;

import com.sipriano.biblioteca.dto.AutorRequestDTO;
import com.sipriano.biblioteca.dto.AutorResponseDTO;
import com.sipriano.biblioteca.service.AutorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> salvar(@RequestBody AutorRequestDTO requestDTO) {
        AutorResponseDTO responseDTO = autorService.salvar(requestDTO);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(responseDTO.id())
                        .toUri()
        ).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listar() {
        return ResponseEntity.ok(autorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> atualizar(@PathVariable Long id, @RequestBody AutorRequestDTO requestDTO) {
        return ResponseEntity.ok(autorService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}