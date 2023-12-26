package com.sara.filmes.controller.api;

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

import com.sara.filmes.model.AnaliseModel;
import com.sara.filmes.service.AnaliseService;
import com.sara.filmes.service.FilmeService;

import jakarta.validation.Valid;

@RestController
public class AnaliseRestController {

    @Autowired
    AnaliseService analiseService;

    @Autowired
    FilmeService filmeService;

    @GetMapping("/api/analises")
    public List<AnaliseModel> getAll() {
        return analiseService.getAll();
    }

    @GetMapping("/api/analises/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
        if (!analiseService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("análise não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(analiseService.getById(id));
    }

    @PostMapping("/api/analises")
    public ResponseEntity<Object> save(@RequestBody @Valid AnaliseModel analiseModel) {
        if (!filmeService.exists(analiseModel.getFilme().getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("filme não encontrado");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(analiseService.save(analiseModel));
    }

    @PutMapping("/api/analises")
    public ResponseEntity<Object> update(@RequestBody @Valid AnaliseModel analiseModel) {
        if (!analiseService.exists(analiseModel.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("análise não encontrada");
        }

        if (!filmeService.exists(analiseModel.getFilme().getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("filme não encontrado");
        }

        var analiseAtualizada = analiseService.updateById(analiseModel, analiseModel.getId());
        return ResponseEntity.status(HttpStatus.OK).body(analiseAtualizada);
    }

    @DeleteMapping("/api/analises/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
        if (!analiseService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("análise não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(analiseService.deleteById(id));
    }
}
