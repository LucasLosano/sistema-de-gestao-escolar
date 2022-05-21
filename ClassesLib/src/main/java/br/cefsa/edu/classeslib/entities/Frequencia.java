package br.cefsa.edu.classeslib.entities;

import java.time.LocalDate;

public class Frequencia {

    private int id;
    private LocalDate data;
    private boolean status;

    public Frequencia() {
    }

    public Frequencia(int id, LocalDate data, boolean status, Materia materia, Aluno aluno) {
        this.id = id;
        this.data = data;
        this.status = status;
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
}
