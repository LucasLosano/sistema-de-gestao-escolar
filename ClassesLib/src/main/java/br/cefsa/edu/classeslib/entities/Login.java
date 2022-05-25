/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.business.Calculos;
import br.cefsa.edu.classeslib.enums.EnumCargo;

public class Login {
    private static Login login;
    private String email;
    private String senha;
    private EnumCargo cargo;
    private int idUsuario;
    
    public Login() {
    }

    public static Login getInstance() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumCargo getCargo() {
        return cargo;
    }

    public void setCargo(EnumCargo cargo) {
        this.cargo = cargo;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        this.senha = Calculos.criptografaSenha(senha);
    }
    
    public void setSenhaBanco(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
