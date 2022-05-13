/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

/**
 *
 * @author rafael.pignatari
 */
public class Materia {
    private int id;
    private String nome;
    private Curso curso;
    private int periodoLecionado;
    private Professor professor;

    public Materia() {
    }

    public Materia(int id, String nome, Curso curso, int periodoLecionado, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.periodoLecionado = periodoLecionado;
        this.professor = professor;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}
