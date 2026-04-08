package com.sipriano.biblioteca.repository;

import com.sipriano.biblioteca.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNomeIgnoreCase(String nome);

}
