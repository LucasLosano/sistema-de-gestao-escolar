package br.cefsa.edu.classeslib.entities;

public class Turma {

    private int id;
    private Curso curso;
    private int periodoAtual;

    public Turma() {
    }

    public Turma(int id, Curso curso, int periodoAtual) {
        this.id = id;
        this.curso = curso;
        this.periodoAtual = periodoAtual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getPeriodoAtual() {
        return periodoAtual;
    }

    public void setPeriodoAtual(int periodoAtual) {
        this.periodoAtual = periodoAtual;
    }

}
