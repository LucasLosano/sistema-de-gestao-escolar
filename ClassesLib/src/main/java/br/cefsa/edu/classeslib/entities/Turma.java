package br.cefsa.edu.classeslib.entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private int id;
    private Curso curso;
    private int periodoAtual;
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private List<GradeHoraria> gradesHorarias = new ArrayList<GradeHoraria>();
    public Turma() {
    }

    public Turma(int id, Curso curso, int periodoAtual, List<Aluno> alunos, List<GradeHoraria> gradesHorarias) {
        this.id = id;
        this.curso = curso;
        this.periodoAtual = periodoAtual;
        this.alunos = alunos;
        this.gradesHorarias = gradesHorarias;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<GradeHoraria> getGradesHorarias() {
        return gradesHorarias;
    }

    public void setGradesHorarias(List<GradeHoraria> gradesHorarias) {
        this.gradesHorarias = gradesHorarias;
    }
    
    public void addGradesHorarias(GradeHoraria gradeHoraria) {
        gradesHorarias.add(gradeHoraria);
    }
}
