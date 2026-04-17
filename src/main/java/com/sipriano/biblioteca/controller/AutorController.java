package com.sipriano.biblioteca.controller;

import com.sipriano.biblioteca.dto.AutorRequestDTO;
import com.sipriano.biblioteca.dto.AutorResponseDTO;
import com.sipriano.biblioteca.dto.ErroResposta;
import com.sipriano.biblioteca.exceptions.OperacaoNaoPermitidaException;
import com.sipriano.biblioteca.exceptions.RegistroDuplicadoException;
import com.sipriano.biblioteca.exceptions.RegistroNaoEncontradoException;
import com.sipriano.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/autores")
public class AutorController implements GenericController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> salvar(@RequestBody @Valid AutorRequestDTO requestDTO) {
        AutorResponseDTO responseDTO = autorService.salvar(requestDTO);
        return ResponseEntity.created(generateUri(responseDTO.id())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listar(
            @RequestParam(required = false, value = "nome") String nome,
            @RequestParam(required = false, value = "nacionalidade") String nacionalidade
    ) {
        return ResponseEntity.ok(autorService.listar(nome, nacionalidade));
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