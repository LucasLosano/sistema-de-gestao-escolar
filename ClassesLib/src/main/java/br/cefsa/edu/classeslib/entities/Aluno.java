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

    public double getMedia(Nota[]notas, double[] pesos) throws Exception {
        if(notas.length > 4)
            throw new Exception("São necessários menos de 4 notas");
        
        if(pesos.length != 4)
            throw new Exception("São necessários 4 pesos");
        
        if(Arrays.stream(pesos).sum() != 1)
            throw new Exception("A soma dos pesos deve ser 1");
        
        double media = 0;
        for(int i = 0; i < notas.length; i++)
        {
            media += notas[i].getValor() * pesos[i];
        }
        
        return media;
    }
    
}
