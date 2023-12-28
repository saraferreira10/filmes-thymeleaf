package com.sara.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.sara.filmes.model.FilmeModel;
import com.sara.filmes.service.FilmeService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @GetMapping("/filmes/cadastro")
    public String mostrarPaginaCadastro(Model model) {
        model.addAttribute("filme", new FilmeModel());
        return "cadastrar-filme";
    }

    @PostMapping("/filmes/cadastro")
    public String cadastrarFilme(@ModelAttribute FilmeModel filme, Model model) {
        filmeService.save(filme);
        List<FilmeModel> filmes = filmeService.getAll();

        model.addAttribute("filmes", filmes);
        model.addAttribute("filme", filme);
        return "redirect:/filmes/listar";
    }

    @GetMapping("/filmes/listar")
    public String mostrarFilmes(Model model) {
        List<FilmeModel> filmes = filmeService.getAll();
        model.addAttribute("filmes", filmes);
        return "listar-filmes";
    }

    @GetMapping("/filmes/editar/{id}")
    public String editarFilme(@PathVariable Integer id, Model model) {
        if (!filmeService.exists(id)) {
            return "redirect:/filmes/listar";
        }

        model.addAttribute("filme", filmeService.getById(id));
        return "editar-filme";
    }
}
