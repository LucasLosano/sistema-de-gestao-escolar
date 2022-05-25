/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.business.Calculos;
import br.cefsa.edu.classeslib.entities.Frequencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author losan
 */
public class FrequenciaRow {
    private Integer materiaId;
    private String materiaNome;
    private String professorNome;
    private Double contPresente = 0d;
    private Double contAusente = 0d;    
    private Double frequencia;

    public FrequenciaRow() {
    }
    
    public List<FrequenciaRow> FrequenciaListToFrequenciaTableList(List<Frequencia> frequencias)
    {
        List<FrequenciaRow> frequenciaTableList = new ArrayList<>();
        
        for(Frequencia frequencia : frequencias){
            Integer materiaId = frequencia.getMateria().getId();
            if(!frequenciaTableList.stream().anyMatch(frequenciaRow -> Objects.equals(frequenciaRow.getMateriaId(), materiaId)))
            {
                FrequenciaRow temp = new FrequenciaRow();
                temp.setMateriaId(materiaId);
                frequenciaToFrequenciaRow(temp, frequencia);
                frequenciaTableList.add(temp);
            }
            else
            {
                FrequenciaRow frequenciaRow =  frequenciaTableList.stream().filter(row -> Objects.equals(row.getMateriaId(), materiaId)).findFirst().get();
                frequenciaToFrequenciaRow(frequenciaRow, frequencia);
            }
        }
        
        for(FrequenciaRow frequenciaRow : frequenciaTableList)
        {
            calculaFreuquencia(frequenciaRow);
        }
        
        return frequenciaTableList;
    }
    
    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public String getMateriaNome() {
        return materiaNome;
    }

    public void setMateriaNome(String materiaNome) {
        this.materiaNome = materiaNome;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    public Double getContPresente() {
        return contPresente;
    }

    public void setContPresente(Double contPresente) {
        this.contPresente = contPresente;
    }

    public Double getContAusente() {
        return contAusente;
    }

    public void setContAusente(Double contAusente) {
        this.contAusente = contAusente;
    }
    

    private void frequenciaToFrequenciaRow(FrequenciaRow frequenciaRow, Frequencia frequencia) {
        frequenciaRow.setMateriaNome(frequencia.getMateria().getNome());
        frequenciaRow.setProfessorNome(frequencia.getMateria().getProfessor().getNome());
        if(frequencia.isStatus())
            frequenciaRow.setContPresente(frequenciaRow.getContPresente()+1);
        else
            frequenciaRow.setContAusente(frequenciaRow.getContAusente()+1);
    }

    private void calculaFreuquencia(FrequenciaRow frequenciaRow) {
        Double frequencia = Calculos.arredondaParaDuasCasas(frequenciaRow.getContPresente() / (frequenciaRow.getContAusente() + frequenciaRow.getContPresente()));
        frequenciaRow.setFrequencia(frequencia);
    }
}
