package br.cefsa.edu.classeslib.entities;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    private boolean ehCoordenador;
    private List<Materia> materias = new ArrayList<Materia>();

    public Professor() {
    }

    public Professor(int id, String nome, String email, String telefone, String rua, String cidade, boolean ehCoordenador) {
        super(id, nome, email, telefone, rua, cidade);
        this.ehCoordenador = ehCoordenador;
    }

    public boolean isEhCoordenador() {
        return ehCoordenador;
    }

    public void setEhCoordenador(boolean ehCoordenador) {
        this.ehCoordenador = ehCoordenador;
    }

}
