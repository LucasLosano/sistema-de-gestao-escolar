package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumTipoNota;

public class Nota {

    private int id;
    private EnumTipoNota tipoNota;
    private float valor = 0;

    public Nota() {
    }

    public Nota(int id, EnumTipoNota tipoNota, float valor, Aluno aluno, Materia materia, PeriodoLetivo periodo) {
        this.id = id;
        this.tipoNota = tipoNota;
        this.valor = valor;
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

}
