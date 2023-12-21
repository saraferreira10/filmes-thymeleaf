package com.sara.filmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sara.filmes.lists.Listas;
import com.sara.filmes.model.AnaliseModel;

@Controller
public class AnaliseController {

    @GetMapping("/listar-analises")
    public String mostrarAnalises(Model model) {
        model.addAttribute("analises", Listas.getAnalises());
        return "listar-analises";
    }

    @GetMapping("/cadastrar-analise")
    public String mostrarPagina(@RequestParam int idFilme,
            Model model, @ModelAttribute AnaliseModel analise) {
        analise.setFilme(Listas.retornarFilme(idFilme));
        analise.setTitulo(analise.getFilme().getTitulo());
        model.addAttribute("analise", analise);

        return "cadastrar-analise";
    }

    @PostMapping("/cadastrar-analise")
    public String cadastrarAnalise(@RequestParam int idFilme,
            Model model, @ModelAttribute AnaliseModel analise) {
        Listas.cadastrarAnalise(analise, idFilme);
        return "redirect:/listar-filmes";
    }
}