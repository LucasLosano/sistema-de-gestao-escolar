package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.entities.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
