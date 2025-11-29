package com.trabalho.api.autores_livros.services;



import com.trabalho.api.autores_livros.models.Livro;
import com.trabalho.api.autores_livros.repositories.AutorRepository;
import com.trabalho.api.autores_livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));
    }

    public Livro atualizar(Long id, Livro dados) {
        Livro livro = buscarPorId(id);

        livro.setTitulo(dados.getTitulo());
        livro.setAno(dados.getAno());
        livro.setAutor(dados.getAutor());

        return livroRepository.save(livro);
    }   

    public void deletar(Long id) {
        Livro livro = buscarPorId(id);
        livroRepository.delete(livro);
    }
}
