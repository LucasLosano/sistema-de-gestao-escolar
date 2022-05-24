package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.LoginDAO;
import br.cefsa.edu.classeslib.entities.Login;
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
        Login login = Login.getInstance();
        
        try{
            login.setEmail(txtLogin.getText());
            login.setSenha(txtSenha.getText());
            if (contexto.ValidateLogin(login)){
                System.out.print("menuPrincipalAluno".equals("menuPrincipal" + login.getCargo().name()));
                App.setRoot("menuPrincipal" + login.getCargo().name());
            }
            else {
                System.out.print("Mensagem de login/senha inválida");
            }
        }catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}