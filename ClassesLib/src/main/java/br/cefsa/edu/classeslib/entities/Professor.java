/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

/**
 *
 * @author rafae
 */
public class Professor extends Pessoa{
    private boolean ehCoordenador;

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
