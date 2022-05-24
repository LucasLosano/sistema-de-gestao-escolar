package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.LoginDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import br.cefsa.edu.classeslib.entities.Pessoa;
import br.cefsa.edu.classeslib.enums.EnumCargo;

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
        LoginDAO contexto = new LoginDAO();
        Pessoa pessoa = new Pessoa();
        
        System.out.print(txtLogin.getText());
        
        try{
            pessoa.setEmail(txtLogin.getText());
            pessoa.setSenha(txtSenha.getText());
            if (contexto.ValidateLogin(pessoa.getEmail(), pessoa.getSenha()))
                App.setRoot("menuPrincipal" + pessoa.getCargo().name());
            else {
                System.out.print("Mensagem de login/senha inválida");
            }
        }catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}