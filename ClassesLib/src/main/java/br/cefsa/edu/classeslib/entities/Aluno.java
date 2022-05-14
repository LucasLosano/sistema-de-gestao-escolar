/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rafae
 */
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
