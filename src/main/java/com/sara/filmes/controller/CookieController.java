package com.sara.filmes.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
    @GetMapping("/")
    public String mudarTema(HttpServletResponse response,
            @CookieValue(name = "tema", defaultValue = "") String temaAtual) {
        String tema = temaAtual.equals("escuro") ? "claro" : "escuro";

        Cookie cookieTema = new Cookie("tema", tema);
        cookieTema.setDomain("localhost");
        cookieTema.setHttpOnly(true);
        cookieTema.setMaxAge(86400);
        response.addCookie(cookieTema);
        cookieTema.setPath("/");

        return "redirect:filmes/listar";
    }

}
