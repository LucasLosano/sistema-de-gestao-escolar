package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import java.time.LocalDate;

public class PeriodoLetivo {

    private int id;
    private EnumPeriodoLetivo tipoPeriodo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public PeriodoLetivo() {
    }

    public PeriodoLetivo(int id, EnumPeriodoLetivo tipoPeriodo, LocalDate dataInicio, LocalDate dataFim) {
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

}
