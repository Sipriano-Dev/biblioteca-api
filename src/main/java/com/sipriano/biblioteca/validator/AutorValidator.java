package com.sipriano.biblioteca.validator;

import com.sipriano.biblioteca.domain.Autor;
import com.sipriano.biblioteca.dto.AutorRequestDTO;
import com.sipriano.biblioteca.exceptions.RegistroDuplicadoException;
import com.sipriano.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    private AutorRepository autorRepository;

    public AutorValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void validarAutor(Autor autor) throws RegistroDuplicadoException {
        if (existeAutorCadastrado(autor)) {
            throw new RegistroDuplicadoException("Registro duplicado");
        }
    }

    private boolean existeAutorCadastrado(Autor autor) {
        Optional<Autor> autorEncontrado = autorRepository.findByNomeAndDataNascimentoAndNacionalidade(
                autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade()
        );

        if (autor.getId() == null) {
            return autorEncontrado.isPresent();
        }

        return autorEncontrado.isPresent() && !autor.getId().equals(autorEncontrado.get().getId());
    }

}
