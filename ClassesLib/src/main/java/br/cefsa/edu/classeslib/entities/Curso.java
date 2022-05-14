package br.cefsa.edu.classeslib.entities;

public class Curso {

    private int id;
    private String nome;
    private int quantidadePeriodos;
    private Pessoa coordenador;

    public Curso() {
    }

    public Curso(int id, String nome, int quantidadePeriodos) {
        this.id = id;
        this.nome = nome;
        this.quantidadePeriodos = quantidadePeriodos;
    }

    public Curso(int id, String nome, int quantidadePeriodos, Pessoa coordenador) {
        this.id = id;
        this.nome = nome;
        this.quantidadePeriodos = quantidadePeriodos;
        this.coordenador = coordenador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadePeriodos() {
        return quantidadePeriodos;
    }

    public void setQuantidadePeriodos(int quantidadePeriodos) {
        this.quantidadePeriodos = quantidadePeriodos;
    }

    public Pessoa getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Pessoa coordenador) {
        this.coordenador = coordenador;
    }

}
