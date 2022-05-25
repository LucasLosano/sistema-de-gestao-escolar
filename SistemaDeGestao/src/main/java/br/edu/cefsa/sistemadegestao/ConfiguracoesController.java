package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.ConfiguracoesDAO;
import br.cefsa.edu.classeslib.business.Calculos;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import br.cefsa.edu.classeslib.entities.Configuracoes;
import br.cefsa.edu.classeslib.entities.PeriodoLetivo;
import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import br.cefsa.edu.classeslib.exception.messages.JavaFXException;
import br.edu.cefsa.helper.Alerts;
import br.edu.cefsa.helper.Contraints;
import br.edu.cefsa.helper.Validacao;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;


public class ConfiguracoesController implements Initializable{
    
    private final String paginaAnterior = "menuPrincipalAdministrador";
    @FXML
    private TextField txtNomeInstituicao; 
    @FXML
    private Label lblNomeInstituicaoError; 
    @FXML
    private TextField txtN1; 
    @FXML
    private TextField txtN2; 
    @FXML
    private TextField txtN3; 
    @FXML
    private TextField txtN4; 
    @FXML
    private Label lblPesosError; 
    @FXML
    private CheckBox chbFatorFrequencia; 
    @FXML
    private ComboBox cbxPeriodo; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ConfiguracoesDAO contexto = new ConfiguracoesDAO();
            var configuracoes = contexto.GetAll().get(0);

            Contraints.setTextFieldDouble(txtN1);
            Contraints.setTextFieldDouble(txtN2);
            Contraints.setTextFieldDouble(txtN3);
            Contraints.setTextFieldDouble(txtN4);
            txtNomeInstituicao.setText(configuracoes.getNomeInstituicao());
            txtN1.setText(Double.toString(configuracoes.getPeso(0)));
            txtN2.setText(Double.toString(configuracoes.getPeso(1)));
            txtN3.setText(Double.toString(configuracoes.getPeso(2)));
            txtN4.setText(Double.toString(configuracoes.getPeso(3)));
            chbFatorFrequencia.setSelected(configuracoes.isFatorFrequencia());
            setPeriodo(configuracoes);
        } catch (Exception e) {
            Alerts.showAlert(JavaFXException.TITULO_BANCO_DADOS, null, JavaFXException.MENSAGEM_BANCO_DADOS, Alert.AlertType.WARNING);
        }        
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
        boolean isValido = true;
        
        periodo.setTipoPeriodo((EnumPeriodoLetivo) cbxPeriodo.getValue());
        pesos[0] = Double.parseDouble(txtN1.getText());
        pesos[1] = Double.parseDouble(txtN2.getText());
        pesos[2] = Double.parseDouble(txtN3.getText());
        pesos[3] = Double.parseDouble(txtN4.getText());
        try {
            Calculos.validaPesos(pesos);
            lblPesosError.setText("");
        } catch (Exception ex) {
            lblPesosError.setText(ex.getMessage());
            isValido = false;
        }
        try {
            Validacao.validaTexto(txtNomeInstituicao.getText());
            lblNomeInstituicaoError.setText("");
        } catch (Exception ex) {
            lblNomeInstituicaoError.setText(ex.getMessage());
            isValido = false;
        }
        if(!isValido)
            return;
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
        
        Alerts.showAlert(JavaFXException.TITULO_SALVO_SUCESSO, null, JavaFXException.SALVO_SUCESSO, Alert.AlertType.INFORMATION);
        switchGoBack();
    }

    private void setPeriodo(Configuracoes configuracoes) {
        List<EnumPeriodoLetivo> lista = new ArrayList<>(EnumSet.allOf(EnumPeriodoLetivo.class));      
        var obsList = FXCollections.observableArrayList(lista);

        cbxPeriodo.setItems(obsList);
        cbxPeriodo.setValue(configuracoes.getPeriodo().getTipoPeriodo());
    }
    
}
