package com.sara.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sara.filmes.model.AnaliseModel;
import com.sara.filmes.model.FilmeModel;
import com.sara.filmes.service.AnaliseService;
import com.sara.filmes.service.FilmeService;

@Controller
public class AnaliseController {

    @Autowired
    AnaliseService analiseService;

    @Autowired
    FilmeService filmeService;

    @GetMapping("/analises/listar")
    public String mostrarAnalises(Model model, @CookieValue(name = "tema", defaultValue = "claro") String tema) {
        List<AnaliseModel> analises = analiseService.getAll();
        List<FilmeModel> filmes = filmeService.getAll();
        model.addAttribute("analises", analises);
        model.addAttribute("filmes", filmes);
        model.addAttribute("tema", tema);
        return "listar-analises";
    }

    @GetMapping("/analises/editar/{id}")
    public String editarAnalise(@PathVariable(name = "id") Integer id, Model model,
            @CookieValue(name = "tema", defaultValue = "claro") String tema) {
        if (!analiseService.exists(id)) {
            return "redirect:analises/listar";
        }

        AnaliseModel analiseModel = analiseService.getById(id);
        model.addAttribute("analise", analiseModel);
        model.addAttribute("tema", tema);
        return "editar-analise";
    }

    @GetMapping("/analises/cadastrar")
    public String mostrarPagina(@RequestParam Integer idFilme,
            Model model, @CookieValue(name = "tema", defaultValue = "claro") String tema) {
        var analise = new AnaliseModel();
        model.addAttribute("analise", analise);
        analise.setFilme(filmeService.getById(idFilme));
        analise.setTitulo(filmeService.getById(idFilme).getTitulo());
        model.addAttribute("tema", tema);
        return "cadastrar-analise";
    }

    @PostMapping("/analises/cadastrar")
    public String cadastrarAnalise(@ModelAttribute AnaliseModel analise) {
        analiseService.save(analise);
        return "redirect:/analises/listar";
    }
}