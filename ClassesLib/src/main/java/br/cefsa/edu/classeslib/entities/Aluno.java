package br.cefsa.edu.classeslib.entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    
    private List<Nota> notas = new ArrayList<Nota>();
    private List<Frequencia> frequencias = new ArrayList<Frequencia>();
    public Aluno() {
    }

    public Aluno(int id, String nome, String email, String telefone, String rua, String cidade, List<Nota> notas, List<Frequencia> frequencias) {
        super(id, nome, email, telefone, rua, cidade);
        this.notas = notas;
        this.frequencias = frequencias;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    public void addNota(Nota nota) {
        notas.add(nota);
    }

    public List<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(List<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }
    
    public void addFrequencia(Frequencia frequencia) {
        frequencias.add(frequencia);
    }
}
