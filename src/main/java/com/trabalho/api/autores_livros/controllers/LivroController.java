package com.trabalho.api.autores_livros.controllers;


import com.trabalho.api.autores_livros.models.Livro;
import com.trabalho.api.autores_livros.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Livro livro) {
        Livro novoLivro = livroService.salvar(livro);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Livro criado com sucesso: " + novoLivro.getTitulo());
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(livroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Livro livro) {

        Livro atualizado = livroService.atualizar(id, livro);
        return ResponseEntity.ok("Livro atualizado com sucesso: " + atualizado.getTitulo());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.ok("Livro deletado com sucesso");
    }
}
