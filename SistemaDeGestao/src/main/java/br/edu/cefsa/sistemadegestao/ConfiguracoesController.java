package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.ConfiguracoesDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import br.cefsa.edu.classeslib.entities.Configuracoes;
import br.cefsa.edu.classeslib.entities.PeriodoLetivo;
import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;


public class ConfiguracoesController implements Initializable{
    
    private final String paginaAnterior = "menuPrincipal";
    @FXML
    private TextField txtNomeInstituicao; 
    @FXML
    private TextField txtN1; 
    @FXML
    private TextField txtN2; 
    @FXML
    private TextField txtN3; 
    @FXML
    private TextField txtN4; 
    @FXML
    private CheckBox chbFatorFrequencia; 
    @FXML
    private ComboBox cbxPeriodo; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConfiguracoesDAO contexto = new ConfiguracoesDAO();
        var configuracoes = contexto.GetAll().get(0);
        
        txtNomeInstituicao.setText(configuracoes.getNomeInstituicao());
        txtN1.setText(Double.toString(configuracoes.getPeso(0)));
        txtN2.setText(Double.toString(configuracoes.getPeso(1)));
        txtN3.setText(Double.toString(configuracoes.getPeso(2)));
        txtN4.setText(Double.toString(configuracoes.getPeso(3)));
        chbFatorFrequencia.setSelected(configuracoes.isFatorFrequencia());
        setPeriodo(configuracoes);
    }
    
    @FXML
    private void switchGoBack() throws IOException {
        App.setRoot(paginaAnterior);
    }
    
    @FXML
    private void Save() throws IOException {
        ConfiguracoesDAO contexto = new ConfiguracoesDAO();
        var configuracao = contexto.GetById(0);
        PeriodoLetivo periodo = new PeriodoLetivo();
        double[] pesos = new double[4];
        boolean novoRegistro = false;
        
        pesos[0] = Double.parseDouble(txtN1.getText());
        pesos[1] = Double.parseDouble(txtN2.getText());
        pesos[2] = Double.parseDouble(txtN3.getText());
        pesos[3] = Double.parseDouble(txtN4.getText());
        periodo.setTipoPeriodo((EnumPeriodoLetivo) cbxPeriodo.getValue());
        
        if (configuracao == null) {
            configuracao = new Configuracoes();
            novoRegistro = true;
        }
        
        configuracao.setNomeInstituicao(txtNomeInstituicao.getText());
        configuracao.setPesos(pesos);
        configuracao.setFatorFrequencia(chbFatorFrequencia.isSelected());
        configuracao.setPeriodo(periodo);
        configuracao.setLogoInstituicao("logo");
        if (novoRegistro)
            contexto.Insert(configuracao);
        else
            contexto.Update(configuracao);
    }

    private void setPeriodo(Configuracoes configuracoes) {
        List<EnumPeriodoLetivo> lista = new ArrayList<>(EnumSet.allOf(EnumPeriodoLetivo.class));      
        var obsList = FXCollections.observableArrayList(lista);

        cbxPeriodo.setItems(obsList);
        cbxPeriodo.setValue(configuracoes.getPeriodo().getTipoPeriodo());
    }
    
}
