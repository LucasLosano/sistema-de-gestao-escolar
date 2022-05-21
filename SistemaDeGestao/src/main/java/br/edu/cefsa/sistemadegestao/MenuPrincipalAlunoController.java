package br.edu.cefsa.sistemadegestao;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPrincipalAlunoController {
    
    @FXML
    private Button btnNotas; 
    
    @FXML
    private void switchToNotas() throws IOException {
        App.setRoot("visualizarNotas");
    }
}
