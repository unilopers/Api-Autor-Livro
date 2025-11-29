package com.trabalho.api.autores_livros.services;

import com.trabalho.api.autores_livros.models.Autor;

import com.trabalho.api.autores_livros.repositories.AutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor salvar(@Valid Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + id));
    }

    public Autor atualizar(Long id, Autor dados) {
        Autor autor = buscarPorId(id);

        autor.setNome(dados.getNome());
        autor.setNacionalidade(dados.getNacionalidade());

        return autorRepository.save(autor);
    }

    public void deletar(Long id) {
        Autor autor = buscarPorId(id);
        autorRepository.delete(autor);
    }
}
