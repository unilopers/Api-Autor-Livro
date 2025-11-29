package com.trabalho.api.autores_livros.repositories;


import com.trabalho.api.autores_livros.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
