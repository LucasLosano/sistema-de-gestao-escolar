package br.cefsa.edu.classeslib.entities;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private int id;
    private String nome;
    private int quantidadePeriodos;
    private Professor coordenador;
    List<Turma> turmas = new ArrayList<>();
    List<Materia> materias = new ArrayList<>();

    public Curso() {
    }

    public Curso(int id, String nome, int quantidadePeriodos, Professor coordenador, List<Turma> turmas, List<Materia> materias) {
        this.id = id;
        this.nome = nome;
        this.quantidadePeriodos = quantidadePeriodos;
        this.coordenador = coordenador;
        this.turmas = turmas;
        this.materias = materias;
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

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    
}
