package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumTipoNota;

public class Nota {

    private int id;
    private EnumTipoNota tipoNota;
    private float valor = 0;
    private Aluno aluno = new Aluno();
    private Materia materia;
    private PeriodoLetivo periodo;

    public Nota() {
    }

    public Nota(int id, EnumTipoNota tipoNota, float valor, Aluno aluno, Materia materia, PeriodoLetivo periodo) {
        this.id = id;
        this.tipoNota = tipoNota;
        this.valor = valor;
        this.aluno = aluno;
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

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
    
    
}
