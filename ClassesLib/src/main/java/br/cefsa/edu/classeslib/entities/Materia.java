package br.cefsa.edu.classeslib.entities;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private int id;
    private String nome;
    private Curso curso;
    private int periodoLecionado;
    List<Nota> notas = new ArrayList<Nota>();
    List<Frequencia> frequencias = new ArrayList<Frequencia>();

    public Materia() {
    }

    public Materia(int id, String nome, Curso curso, int periodoLecionado, List<Nota> notas, List<Frequencia> frequencias) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.periodoLecionado = periodoLecionado;
        this.notas = notas;
        this.frequencias = frequencias;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getPeriodoLecionado() {
        return periodoLecionado;
    }

    public void setPeriodoLecionado(int periodoLecionado) {
        this.periodoLecionado = periodoLecionado;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    public void addNota(Nota nota) {
        notas.add(nota);
    }

    public List<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(List<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }
    
    public void addFrequencia(Frequencia frequencia) {
        frequencias.add(frequencia);
    }
    
    
}
