package com.trabalho.api.autores_livros.repositories;


import com.trabalho.api.autores_livros.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
