package br.cefsa.edu.classeslib.entities;

import java.time.LocalDate;

public class Frequencia {

    private int id;
    private LocalDate data;
    private boolean status;
    private Materia materia;
    private Aluno aluno;
    private PeriodoLetivo periodo;

    public Frequencia() {
    }

    public Frequencia(int id, LocalDate data, boolean status, Materia materia, Aluno aluno, PeriodoLetivo periodo) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.materia = materia;
        this.aluno = aluno;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public PeriodoLetivo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLetivo periodo) {
        this.periodo = periodo;
    }

}
