package com.sara.filmes.lists;

import java.util.ArrayList;
import java.util.List;

import com.sara.filmes.model.Analise;
import com.sara.filmes.model.Filme;

public class Listas {
    private static List<Analise> analises = new ArrayList<>();
    private static List<Filme> filmes = new ArrayList<>();

    public static List<Analise> getAnalises() {
        return analises;
    }

    public static List<Filme> getFilmes() {
        return filmes;
    }

    public static void cadastrarAnalise(Analise analise, int idFilme) {
        analise.setId(analises.size() + 1);
        analise.setFilme(retornarFilme(idFilme));
        analise.setTitulo(retornarFilme(idFilme).getTitulo());
        analises.add(analise);
    }

    public static void cadastrarFilme(Filme filme) {
        filme.setId(filmes.size() + 1);
        filmes.add(filme);
    }

    public static Filme retornarFilme(int id) {
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                return filme;
            }
        }

        return null;
    }

}
