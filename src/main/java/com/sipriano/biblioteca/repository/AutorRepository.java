package com.sipriano.biblioteca.repository;

import com.sipriano.biblioteca.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("select a from Autor a where a.nome like %:nome%")
    List<Autor> findByNomeIgnoreCase(@Param("nome") String nome);

}
