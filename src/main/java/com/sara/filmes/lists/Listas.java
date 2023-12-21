package com.sara.filmes.lists;

import java.util.ArrayList;
import java.util.List;

import com.sara.filmes.model.AnaliseModel;
import com.sara.filmes.model.FilmeModel;

public class Listas {
    private static List<AnaliseModel> analises = new ArrayList<>();
    private static List<FilmeModel> filmes = new ArrayList<>();

    public static List<AnaliseModel> getAnalises() {
        return analises;
    }

    public static List<FilmeModel> getFilmes() {
        return filmes;
    }

    public static void cadastrarAnalise(AnaliseModel analise, int idFilme) {
        analise.setId(analises.size() + 1);
        analise.setFilme(retornarFilme(idFilme));
        analise.setTitulo(retornarFilme(idFilme).getTitulo());
        analises.add(analise);
    }

    public static void cadastrarFilme(FilmeModel filme) {
        filme.setId(filmes.size() + 1);
        filmes.add(filme);
    }

    public static FilmeModel retornarFilme(int id) {
        for (FilmeModel filme : filmes) {
            if (filme.getId() == id) {
                return filme;
            }
        }

        return null;
    }

}
