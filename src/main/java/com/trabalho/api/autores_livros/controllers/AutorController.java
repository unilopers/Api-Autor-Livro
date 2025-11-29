package com.trabalho.api.autores_livros.controllers;


import com.trabalho.api.autores_livros.models.Autor;
import com.trabalho.api.autores_livros.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Autor autor) {
        Autor novoAutor = autorService.salvar(autor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Autor criado com sucesso: " + novoAutor.getNome());
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        return ResponseEntity.ok(autorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Autor autor) {

        Autor atualizado = autorService.atualizar(id, autor);

        return ResponseEntity.ok("Autor atualizado com sucesso: " + atualizado.getNome());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.ok("Autor deletado com sucesso");
    }
}

