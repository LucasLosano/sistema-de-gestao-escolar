/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumRotuloPessoa;

/**
 *
 * @author rafael.pignatari
 */
public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String rua;
    private String cidade;
    private EnumRotuloPessoa rotulo;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String email, String telefone, String rua, String cidade, EnumRotuloPessoa rotulo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.cidade = cidade;
        this.rotulo = rotulo;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public EnumRotuloPessoa getRotulo() {
        return rotulo;
    }

    public void setRotulo(EnumRotuloPessoa rotulo) {
        this.rotulo = rotulo;
    }
    
    
    
    
}
