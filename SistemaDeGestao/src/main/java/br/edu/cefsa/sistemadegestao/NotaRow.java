package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.ConfiguracoesDAO;
import br.cefsa.edu.classeslib.DAO.FrequenciaDAO;
import br.cefsa.edu.classeslib.business.Calculos;
import br.cefsa.edu.classeslib.entities.Configuracoes;
import br.cefsa.edu.classeslib.entities.Frequencia;
import br.cefsa.edu.classeslib.entities.Login;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotaRow {
    private Integer materiaId;
    private String materiaNome;
    private String professorNome;
    private Nota n1 = new Nota();
    private Nota n2 = new Nota();
    private Nota n3 = new Nota();
    private Nota n4 = new Nota();
    private Double media;

    public NotaRow() {
    }
    
    public List<NotaRow> NotasToNotasTableList(List<Nota> notas) throws Exception
    {
        List<NotaRow> notasTableList = new ArrayList<>();
        for(Nota nota : notas){
            Integer materiaId = nota.getMateria().getId();
            if(!notasTableList.stream().anyMatch(notaRow -> Objects.equals(notaRow.getMateriaId(), materiaId)))
            {
                NotaRow temp = new NotaRow();
                temp.setMateriaId(materiaId);
                notaToNotaRow(temp, nota);
                notasTableList.add(temp);
            }
            else
            {
                NotaRow notaRow =  notasTableList.stream().filter(row -> Objects.equals(row.getMateriaId(), materiaId)).findFirst().get();
                notaToNotaRow(notaRow, nota);
            }
        }
        
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

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
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
        if(configuracoes.isFatorFrequencia())
        {
            FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
            List<Frequencia> frequencias = frequenciaDAO.GetForAluno(
                    Login.getInstance().getIdUsuario(), 
                    notaRow.getMateriaId());
            notaRow.setMedia(Calculos.calculaMedia(notas, configuracoes.getPesos(), frequencias.toArray(Frequencia[]::new)));
        }
        else
            notaRow.setMedia(Calculos.calculaMedia(notas, configuracoes.getPesos()));
            
    }
}


