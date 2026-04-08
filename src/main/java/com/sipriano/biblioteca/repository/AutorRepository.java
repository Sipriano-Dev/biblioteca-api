package com.sipriano.biblioteca.repository;

import com.sipriano.biblioteca.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNomeContainingIgnoreCase(String nome);

    List<Autor> findByNacionalidadeContainingIgnoreCase(String nacionalidade);

    List<Autor> findByNomeContainingIgnoreCaseAndNacionalidadeContainingIgnoreCase(
            String nome, String nacionalidade
    );

}
