package br.cefsa.edu.classeslib.entities;

public class Aluno extends Pessoa {

    private Turma turma;

    public Aluno() {
    }

    public Aluno(int id, String nome, String email, String telefone, String rua, String cidade, Turma turma) {
        super(id, nome, email, telefone, rua, cidade);
        this.turma = turma;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
