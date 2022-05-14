/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import java.util.Date;

/**
 *
 * @author rafae
 */
public class PeriodoLetivo {
    private int id;
    private EnumPeriodoLetivo tipoPeriodo;
    private Date dataInicio;
    private Date dataFim;

    public PeriodoLetivo() {
    }

    public PeriodoLetivo(int id, EnumPeriodoLetivo tipoPeriodo, Date dataInicio, Date dataFim) {
        this.id = id;
        this.tipoPeriodo = tipoPeriodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumPeriodoLetivo getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(EnumPeriodoLetivo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    
}
