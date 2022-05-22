package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;

public class Configuracoes {

    private String nomeInstituicao;
    private PeriodoLetivo periodo = new PeriodoLetivo();
    private double[] pesos = {2.5f, 2.5f, 2.5f, 2.5f};
    private float media = 6;
    private boolean fatorFrequencia;
    private String logoInstituicao;

    public Configuracoes() {
    }
  
    public Configuracoes(String nomeInstituicao, EnumPeriodoLetivo tipoPeriodo, double[] pesos, boolean fatorFrequencia, String logoInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
        this.periodo.setTipoPeriodo(tipoPeriodo);
        this.pesos = pesos;
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

    public double[] getPesos() {
        return pesos;
    }
    
    public double getPeso(int index) {
        return pesos[index];
    }

    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
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
