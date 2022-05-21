package br.edu.cefsa.sistemadegestao;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    @FXML
    private Label lblNomeInstituicao;
    @FXML
    private TextField txtLogin; 
    @FXML
    private PasswordField txtSenha; 
    @FXML
    private Button btnLogar; 
    
    @FXML
    private void switchToMenuPrincipal() throws IOException {
        System.out.print(txtLogin.getText());
        try{
            App.setRoot("menuPrincipal" + txtLogin.getText());
        }catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}