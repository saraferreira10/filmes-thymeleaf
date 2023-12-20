package com.sara.filmes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sara.filmes.model.FilmeModel;
import com.sara.filmes.service.FilmeService;

import jakarta.validation.Valid;

@RestController
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @GetMapping("/filmes")
    public List<FilmeModel> getAll() {
        return filmeService.getAll();
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
        if (filmeService.getById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("filme não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getById(id));
    }

    @PostMapping("/filmes")
    public ResponseEntity<FilmeModel> save(@RequestBody @Valid FilmeModel filmeModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filmeModel));
    }

    @PutMapping("/filmes")
    public ResponseEntity<Object> update(@RequestBody @Valid FilmeModel filmeModel) {
        var filmeAtualizado = filmeService.updateById(filmeModel, filmeModel.getId());

        if (filmeAtualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("filme não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(filmeAtualizado);
    }

    @DeleteMapping("/filmes/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
        if (!filmeService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("filme não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(filmeService.deleteById(id));
    }
}
