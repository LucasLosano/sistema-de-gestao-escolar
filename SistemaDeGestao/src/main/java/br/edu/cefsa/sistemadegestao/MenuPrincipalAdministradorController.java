package br.edu.cefsa.sistemadegestao;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuPrincipalAdministradorController {
    
    @FXML
    private void switchToConfiguracoes() throws IOException {
        App.setRoot("configuracoes");
    }
}
