package br.edu.cefsa.sistemadegestao;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuPrincipalAlunoController{
    
    @FXML
    private void switchToNotas() throws IOException {
        App.setRoot("visualizarNotas");
    }
    
    @FXML
    private void switchToFrequencia() throws IOException {
        App.setRoot("visualizarFrequencia");
    }
}
