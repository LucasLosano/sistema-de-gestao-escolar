/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumTipoNota;

/**
 *
 * @author rafael.pignatari
 */
public class Nota {
    private int id;
    private EnumTipoNota tipoNota;
    private double valor;
    private Pessoa aluno;
    private Materia materia;
    private int semestre;

    public Nota() {
    }

    public Nota(int id, EnumTipoNota tipoNota, double valor, Pessoa aluno, Materia materia, int semestre) {
        this.id = id;
        this.tipoNota = tipoNota;
        this.valor = valor;
        this.aluno = aluno;
        this.materia = materia;
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumTipoNota getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(EnumTipoNota tipoNota) {
        this.tipoNota = tipoNota;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pessoa getAluno() {
        return aluno;
    }

    public void setAluno(Pessoa aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    
}
