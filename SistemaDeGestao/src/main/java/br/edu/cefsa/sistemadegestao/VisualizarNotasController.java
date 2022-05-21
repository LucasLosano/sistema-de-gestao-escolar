package br.edu.cefsa.sistemadegestao;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class VisualizarNotasController {
    private final String paginaAnterior = "menuPrincipalAluno";
    
    @FXML
    private TableView tbvNotas; 
    
    @FXML
    private void switchGoBack() throws IOException {
        App.setRoot(paginaAnterior);
    }
}
