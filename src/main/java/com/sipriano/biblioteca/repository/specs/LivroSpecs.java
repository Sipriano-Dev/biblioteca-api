package com.sipriano.biblioteca.repository.specs;

import com.sipriano.biblioteca.domain.Livro;
import com.sipriano.biblioteca.domain.enums.GeneroLivro;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class LivroSpecs {

    public static Specification<Livro> tituloLike(String titulo) {
        return (root, query, cb) ->
                titulo == null ? null :
                        cb.like(cb.upper(root.get("titulo")), "%" + titulo.toUpperCase() + "%");
    }

    public static Specification<Livro> isbnEquals(String isbn) {
        return (root, query, cb) ->
                isbn == null ? null :
                        cb.equal(root.get("isbn"), isbn);
    }

    public static Specification<Livro> anoPublicacaoEquals(Integer anoPublicacao) {
        return (root, query, cb) ->
                anoPublicacao == null ? null :
                        cb.equal(
                                cb.function("date_part", Integer.class,
                                        cb.literal("year"),
                                        root.get("dataPublicacao")
                                ), anoPublicacao);
    }

    public static Specification<Livro> generoEquals(GeneroLivro genero) {
        return (root, query, cb) ->
                genero == null ? null :
                        cb.equal(root.get("genero"), genero);
    }


    public static Specification<Livro> nomeAutorLike(String nomeAutor) {
        return (root, query, cb) ->
                nomeAutor == null ? null :
                        cb.like(cb.upper(root.join("autor").get("nome")), "%" + nomeAutor.toUpperCase() + "%");
    }


}
