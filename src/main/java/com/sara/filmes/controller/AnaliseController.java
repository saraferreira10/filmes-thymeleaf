package com.sara.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/listar-analises")
    public String mostrarAnalises(Model model) {
        List<AnaliseModel> analises = analiseService.getAll();
        List<FilmeModel> filmes = filmeService.getAll();
        model.addAttribute("analises", analises);
        model.addAttribute("filmes", filmes);
        return "listar-analises";
    }

    @GetMapping("/cadastrar-analise")
    public String mostrarPagina(@RequestParam int idFilme,
            Model model, @ModelAttribute AnaliseModel analise) {
        analise.setFilme(filmeService.getById(idFilme));
        analise.setTitulo(filmeService.getById(idFilme).getTitulo());
        System.out.println(filmeService.getById(idFilme).getTitulo());
        System.out.println("-----------------------------------------------------------------------------------------");
        model.addAttribute("analise", analise);
        return "cadastrar-analise";
    }

    @PostMapping("/cadastrar-analise")
    public String cadastrarAnalise(
            Model model, @ModelAttribute AnaliseModel analise) {
        analiseService.save(analise);
        return "redirect:/listar-filmes";
    }
}