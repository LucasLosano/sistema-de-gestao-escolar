/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

/**
 *
 * @author rafae
 */
public class Configuracoes {
    private String nomeInstituicao;
    private PeriodoLetivo periodo;
    private float[] pesos = new float[4];
    private boolean fatorFrequencia;
    private String logoInstituicao;

    public Configuracoes() {
    }

    public Configuracoes(String nomeInstituicao, PeriodoLetivo periodo, boolean fatorFrequencia, String logoInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
        this.periodo = periodo;
        this.fatorFrequencia = fatorFrequencia;
        this.logoInstituicao = logoInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public PeriodoLetivo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLetivo periodo) {
        this.periodo = periodo;
    }

    public float[] getPesos() {
        return pesos;
    }

    public void setPesos(float[] pesos) {
        this.pesos = pesos;
    }

    public boolean isFatorFrequencia() {
        return fatorFrequencia;
    }

    public void setFatorFrequencia(boolean fatorFrequencia) {
        this.fatorFrequencia = fatorFrequencia;
    }

    public String getLogoInstituicao() {
        return logoInstituicao;
    }

    public void setLogoInstituicao(String logoInstituicao) {
        this.logoInstituicao = logoInstituicao;
    }
    
    
}
