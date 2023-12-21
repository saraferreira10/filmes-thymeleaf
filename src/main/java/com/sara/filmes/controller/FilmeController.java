package com.sara.filmes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sara.filmes.lists.Listas;
import com.sara.filmes.model.FilmeModel;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmeController {

    @GetMapping("/cadastrar-filme")
    public String mostrarPaginaCadastro(Model model) {
        model.addAttribute("filme", new FilmeModel());
        return "cadastrar-filme";
    }

    @PostMapping("/cadastrar-filme")
    public String cadastrarFilme(@ModelAttribute FilmeModel filme, Model model) {
        Listas.cadastrarFilme(filme);
        List<FilmeModel> filmes = Listas.getFilmes();

        model.addAttribute("filmes", filmes);
        model.addAttribute("filme", filme);
        return "redirect:/listar-filmes";
    }

    @GetMapping("/listar-filmes")
    public String mostrarFilmes(Model model) {
        List<FilmeModel> filmes = Listas.getFilmes();
        model.addAttribute("filmes", filmes);
        return "listar-filmes";
    }

}
