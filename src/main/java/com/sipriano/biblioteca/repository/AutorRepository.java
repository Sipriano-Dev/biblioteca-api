package com.sipriano.biblioteca.repository;

import com.sipriano.biblioteca.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNomeContainingIgnoreCase(String nome);

    List<Autor> findByNacionalidadeContainingIgnoreCase(String nacionalidade);

    List<Autor> findByNomeContainingIgnoreCaseAndNacionalidadeContainingIgnoreCase(
            String nome, String nacionalidade
    );

    Optional<Autor> findByNomeAndDataNascimentoAndNacionalidade(
            String nome, LocalDate dataNascimento, String nacionalidade);

}
