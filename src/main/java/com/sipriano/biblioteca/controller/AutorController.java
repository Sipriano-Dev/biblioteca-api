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
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid AutorRequestDTO requestDTO) {
        try {
            AutorResponseDTO responseDTO = autorService.salvar(requestDTO);
            return ResponseEntity.created(
                    ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(responseDTO.id())
                            .toUri()
            ).body(responseDTO);
        } catch (RegistroDuplicadoException e) {
            var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listar(
            @RequestParam(required = false, value = "nome") String nome,
            @RequestParam(required = false, value = "nacionalidade") String nacionalidade
    ) {
        return ResponseEntity.ok(autorService.listar(nome, nacionalidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(autorService.buscarPorId(id));
        } catch (RegistroNaoEncontradoException e) {
            var erroDto = ErroResposta.respostaPadrao(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody AutorRequestDTO requestDTO) {
        try {
            return ResponseEntity.ok(autorService.atualizar(id, requestDTO));
        } catch (RegistroDuplicadoException e) {
            var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        try {
            autorService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (OperacaoNaoPermitidaException e) {
            var erroDto = ErroResposta.respostaPadrao(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }


}