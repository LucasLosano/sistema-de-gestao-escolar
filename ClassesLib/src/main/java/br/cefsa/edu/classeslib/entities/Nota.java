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
    private float valor = 0;
    private Aluno aluno = new Aluno();
    private Materia materia;
    private PeriodoLetivo periodo;

    public Nota() {
    }

    public Nota(int id, EnumTipoNota tipoNota, float valor, Materia materia, PeriodoLetivo periodo) {
        this.id = id;
        this.tipoNota = tipoNota;
        this.valor = valor;
        this.materia = materia;
        this.periodo = periodo;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public PeriodoLetivo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLetivo periodo) {
        this.periodo = periodo;
    }

}
