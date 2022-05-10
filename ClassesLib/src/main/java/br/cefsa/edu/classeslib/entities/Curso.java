/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

/**
 *
 * @author rafael.pignatari
 */
public class Curso {
    private int id;
    private String nome;
    private int duracaoSemestre;
    private Pessoa coordenador;

    public Curso() {
    }

    public Curso(int id, String nome, int duracaoSemestre, Pessoa coordenador) {
        this.id = id;
        this.nome = nome;
        this.duracaoSemestre = duracaoSemestre;
        this.coordenador = coordenador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracaoSemestre(int duracaoSemestre) {
        this.duracaoSemestre = duracaoSemestre;
    }

    public void setCoordenador(Pessoa coordenador) {
        this.coordenador = coordenador;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoSemestre() {
        return duracaoSemestre;
    }

    public Pessoa getCoordenador() {
        return coordenador;
    }
    
}
