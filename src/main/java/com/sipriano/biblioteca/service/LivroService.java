package com.sipriano.biblioteca.service;

import com.sipriano.biblioteca.domain.Autor;
import com.sipriano.biblioteca.domain.enums.GeneroLivro;
import com.sipriano.biblioteca.dto.LivroRequestDTO;
import com.sipriano.biblioteca.dto.LivroResponseDTO;
import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.exceptions.RegistroNaoEncontradoException;
import com.sipriano.biblioteca.mapper.LivroMapper;
import com.sipriano.biblioteca.repository.AutorRepository;
import com.sipriano.biblioteca.repository.LivroRepository;
import com.sipriano.biblioteca.repository.specs.LivroSpecs;
import com.sipriano.biblioteca.validator.LivroValidator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

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

    public Page<LivroResponseDTO> listar(String titulo,
                                         String isbn,
                                         Integer anoPublicacao,
                                         GeneroLivro genero,
                                         String nomeAutor,
                                         Integer pagina,
                                         Integer tamanhoPagina) {
        Specification<Livro> specs = Specification
                .where(LivroSpecs.tituloLike(titulo))
                .and(LivroSpecs.isbnEquals(isbn))
                .and(LivroSpecs.anoPublicacaoEquals(anoPublicacao))
                .and(LivroSpecs.generoEquals(genero))
                .and(LivroSpecs.nomeAutorLike(nomeAutor));

        Pageable pageRequest = PageRequest.of(pagina, tamanhoPagina);

        Page<Livro> livros = livroRepository.findAll(specs, pageRequest);
        
        return livros.map(livroMapper::toDTO);
    }

    public LivroResponseDTO buscarPorId(Long id) {
        return livroRepository.findById(id).map(livroMapper::toDTO)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado"));
    }

    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado!"));

        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setDataPublicacao(dto.dataPublicacao());
        livro.setGenero(dto.genero());
        livro.setPreco(dto.preco());
        Autor autor = autorRepository.findById(dto.autorId()).orElseThrow(() -> new RegistroNaoEncontradoException("Autor não  encontrado!"));
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
