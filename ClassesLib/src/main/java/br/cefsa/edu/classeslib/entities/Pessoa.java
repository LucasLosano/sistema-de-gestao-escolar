package br.cefsa.edu.classeslib.entities;
import br.cefsa.edu.classeslib.enums.EnumCargo;
import br.cefsa.edu.classeslib.business.Calculos;

public class Pessoa {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String rua;
    private String cidade;
    private EnumCargo cargo;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String email, String telefone, String rua, String cidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.cidade = cidade;
    }
    
    public Pessoa(String email, String senha, EnumCargo cargo) {
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
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
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        this.senha = Calculos.criptografaSenha(senha);
    }
    
    public EnumCargo getCargo() {
        return cargo;
    }

    public void setCargo(EnumCargo cargo) {
        this.cargo = cargo;
    }

}
