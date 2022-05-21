package br.edu.cefsa.sistemadegestao;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConfiguracoesController {
    
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
    
    @FXML
    private void switchGoBack() throws IOException {
        App.setRoot(paginaAnterior);
    }
    
    @FXML
    private void Save() throws IOException {
        
    }
}
