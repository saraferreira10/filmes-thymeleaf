package com.sara.filmes.model;

public class Analise {
    private int id;
    private Filme filme;
    private String resenha;
    private String titulo;
    private byte nota;

    public Analise() {
    }

    public Analise(int id, Filme filme, String resenha, byte nota, String titulo) {
        this.id = id;
        this.filme = filme;
        this.resenha = resenha;
        this.nota = nota;
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public byte getNota() {
        return nota;
    }

    public void setNota(byte nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
