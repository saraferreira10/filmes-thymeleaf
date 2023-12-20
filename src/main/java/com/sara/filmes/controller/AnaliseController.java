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

import com.sara.filmes.model.AnaliseModel;
import com.sara.filmes.service.AnaliseService;

import jakarta.validation.Valid;

@RestController
public class AnaliseController {

    @Autowired
    AnaliseService analiseService;

    @GetMapping("/analises")
    public List<AnaliseModel> getAll() {
        return analiseService.getAll();
    }

    @GetMapping("/analises/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
        if (analiseService.getById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("análise não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(analiseService.getById(id));
    }

    @PostMapping("/analises")
    public ResponseEntity<AnaliseModel> save(@RequestBody @Valid AnaliseModel analiseModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(analiseService.save(analiseModel));
    }

    @PutMapping("/analises")
    public ResponseEntity<Object> update(@RequestBody @Valid AnaliseModel analiseModel) {
        var analiseAtualizada = analiseService.updateById(analiseModel, analiseModel.getId());

        if (analiseAtualizada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("análise não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(analiseAtualizada);
    }

    @DeleteMapping("/analises/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
        if (!analiseService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("análise não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(analiseService.deleteById(id));
    }
}
