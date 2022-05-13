/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

import java.util.Date;

/**
 *
 * @author rafael.pignatari
 */
public class Frequencia {
    private int id;
    private Date data;
    private boolean status;
    private Materia materia;
    private Aluno aluno = new Aluno();
    private PeriodoLetivo periodo;

    public Frequencia() {
    }

    public Frequencia(int id, Materia materia, Date data, PeriodoLetivo periodo, boolean status) {
        this.id = id;
        this.materia = materia;
        this.data = data;
        this.periodo = periodo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public PeriodoLetivo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLetivo periodo) {
        this.periodo = periodo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
