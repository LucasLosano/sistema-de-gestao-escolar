package br.cefsa.edu.classeslib.entities;

import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodoLetivo {

    private int id;
    private EnumPeriodoLetivo tipoPeriodo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    List<Nota> notas = new ArrayList<Nota>();
    List<Frequencia> frequencias = new ArrayList<Frequencia>();
    List<GradeHoraria> gradesHorarias = new ArrayList<GradeHoraria>();
    
    
    
    public PeriodoLetivo() {
    }

    public PeriodoLetivo(int id, EnumPeriodoLetivo tipoPeriodo, LocalDate dataInicio, LocalDate dataFim, List<Nota> notas, List<Frequencia> frequencias, List<GradeHoraria> gradesHorarias) {
        this.id = id;
        this.tipoPeriodo = tipoPeriodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.notas = notas;
        this.frequencias = frequencias;
        this.gradesHorarias = gradesHorarias;
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    public void addNota(Nota nota) {
        notas.add(nota);
    }

    public List<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(List<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }
    
    public void addFrequencia(Frequencia frequencia) {
        frequencias.add(frequencia);
    }

    public List<GradeHoraria> getGradesHorarias() {
        return gradesHorarias;
    }

    public void setGradesHorarias(List<GradeHoraria> gradesHorarias) {
        this.gradesHorarias = gradesHorarias;
    }
    
    public void addGradeHoraria(GradeHoraria gradeHoraria) {
        gradesHorarias.add(gradeHoraria);
    }
    
    
}
