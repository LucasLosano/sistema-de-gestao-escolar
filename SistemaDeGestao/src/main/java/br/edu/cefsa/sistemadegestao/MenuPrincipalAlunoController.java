package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.entities.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuPrincipalAlunoController implements Initializable {
    
    @FXML
    private void switchToNotas() throws IOException {
        App.setRoot("visualizarNotas");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Login login = Login.getInstance();
        System.out.print(login.getCargo().name());
    }
}
