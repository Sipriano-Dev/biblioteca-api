package com.sipriano.biblioteca.service;

import com.sipriano.biblioteca.domain.Autor;
import com.sipriano.biblioteca.dto.AutorRequestDTO;
import com.sipriano.biblioteca.dto.AutorResponseDTO;
import com.sipriano.biblioteca.exceptions.OperacaoNaoPermitidaException;
import com.sipriano.biblioteca.mapper.AutorMapper;
import com.sipriano.biblioteca.repository.AutorRepository;
import com.sipriano.biblioteca.validator.AutorValidator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class AutorService {

    final AutorRepository autorRepository;
    final AutorMapper autorMapper;
    final AutorValidator  autorValidator;

    public AutorResponseDTO salvar(AutorRequestDTO dto) {
        Autor autor = autorMapper.toEntity(dto);
        autorValidator.validarAutor(autor);
        return autorMapper.toDTO(autorRepository.save(autor));
    }

    //Vai ser deixado dessa forma pra fins de aprendizado
    public List<AutorResponseDTO> listar(String nome, String nacionalidade) {
        if (nome == null && nacionalidade == null) {
            return autorRepository.findAll().stream().map(autorMapper::toDTO).toList();
        } else if (nacionalidade == null) {
            return autorRepository.findByNomeContainingIgnoreCase(nome).stream().map(autorMapper::toDTO).toList();
        } else if (nome == null) {
            return autorRepository.findByNacionalidadeContainingIgnoreCase(nacionalidade).stream().map(autorMapper::toDTO).toList();
        } else {
            return autorRepository.findByNomeContainingIgnoreCaseAndNacionalidadeContainingIgnoreCase(nome, nacionalidade).stream().map(autorMapper::toDTO).toList();
        }
    }

    public AutorResponseDTO buscarPorId(Long id) {
        return autorRepository.findById(id).map(autorMapper::toDTO).orElse(null);
    }

    //Aqui n usa autorMapper, pois atualiza o autor pego com dados do dto, antes era um update cego, sem confirma se ou autor existia
    public AutorResponseDTO atualizar(Long id, AutorRequestDTO dto) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        autor.setNome(dto.nome());
        autor.setDataNascimento(dto.dataNascimento());
        autor.setNacionalidade(dto.nacionalidade());
        autorValidator.validarAutor(autor);
        return autorMapper.toDTO(autorRepository.save(autor));
    }

    public void deletar(Long id) {
        int count = autorRepository.findById(id)
                .map(autor -> autor.getLivros().size())
                .orElse(0);
        if (count > 0) {
            throw new OperacaoNaoPermitidaException("Não é permitido excluir! Autor possui livro(s) cadastrado(s)");
        }
        autorRepository.deleteById(id);
    }

}

