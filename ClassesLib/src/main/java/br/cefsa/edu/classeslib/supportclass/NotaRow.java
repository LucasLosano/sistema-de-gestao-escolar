/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.supportclass;

import br.cefsa.edu.classeslib.DAO.ConfiguracoesDAO;
import br.cefsa.edu.classeslib.business.Calculos;
import br.cefsa.edu.classeslib.entities.Configuracoes;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author losan
 */
public class NotaRow {
    
    private Integer materiaId;
    private String materiaNome;
    private String professorNome;
    private Nota n1 = new Nota();
    private Nota n2 = new Nota();
    private Nota n3 = new Nota();
    private Nota n4 = new Nota();
    private double media;

    public NotaRow() {
    }
    
    public List<NotaRow> NotasToNotasTableList(List<Nota> notas) throws Exception
    {
        List<NotaRow> notasTableList = new ArrayList<>();
        notas.forEach(nota -> {
            Integer mateiraId = nota.getMateria().getId();
            if(!notasTableList.stream().anyMatch(notaRow -> Objects.equals(notaRow.getMateriaId(), mateiraId)))
            {
                NotaRow temp = new NotaRow();
                temp.setMateriaId(materiaId);
                notasTableList.add(temp);
            }
            else
            {
                NotaRow notaRow =  notasTableList.stream().findFirst().get();
                notaToNotaRow(notaRow, nota);
            }
        });
        
        for(NotaRow notaRow : notasTableList)
        {
            calculaMedia(notaRow);
        }
        
        return notasTableList;
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

    public Nota getN1() {
        return n1;
    }

    public void setN1(Nota n1) {
        this.n1 = n1;
    }

    public Nota getN2() {
        return n2;
    }

    public void setN2(Nota n2) {
        this.n2 = n2;
    }

    public Nota getN3() {
        return n3;
    }

    public void setN3(Nota n3) {
        this.n3 = n3;
    }

    public Nota getN4() {
        return n4;
    }

    public void setN4(Nota n4) {
        this.n4 = n4;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    private void notaToNotaRow(NotaRow notaRow, Nota nota) {
        notaRow.setMateriaNome(nota.getMateria().getNome());
        notaRow.setProfessorNome(nota.getMateria().getProfessor().getNome());
        if(nota.getTipoNota() == EnumTipoNota.N1)
            notaRow.setN1(nota);
        if(nota.getTipoNota() == EnumTipoNota.N2)
            notaRow.setN2(nota);
        if(nota.getTipoNota() == EnumTipoNota.N3)
            notaRow.setN3(nota);
        if(nota.getTipoNota() == EnumTipoNota.N4)
            notaRow.setN4(nota);
    }

    private void calculaMedia(NotaRow notaRow) throws Exception {
        Nota[] notas = new Nota[]{notaRow.getN1(), notaRow.getN2(), notaRow.getN3(), notaRow.getN4()};
        ConfiguracoesDAO contexto = new ConfiguracoesDAO();
        Configuracoes configuracoes = contexto.GetAll().get(0);
        notaRow.setMedia(Calculos.calculaMedia(notas, configuracoes.getPesos()));
    }
}
