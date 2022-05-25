package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.ConfiguracoesDAO;
import br.cefsa.edu.classeslib.DAO.LoginDAO;
import br.cefsa.edu.classeslib.entities.Login;
import br.cefsa.edu.classeslib.exception.messages.JavaFXException;
import br.edu.cefsa.helper.Alerts;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class LoginController implements Initializable {

    @FXML
    private Label lblNomeInstituicao;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Button btnLogar;
    @FXML
    private Label lblErro;

    @FXML
    private void switchToMenuPrincipal() throws IOException {
        LoginDAO contexto = new LoginDAO();
        Login login = Login.getInstance();

        try {
            login.setEmail(txtLogin.getText());
            login.setSenha(txtSenha.getText());
            if (contexto.ValidateLogin(login)) {
                System.out.print("menuPrincipalAluno".equals("menuPrincipal" + login.getCargo().name()));
                App.setRoot("menuPrincipal" + login.getCargo().name());
            } else {
                throw new Exception(JavaFXException.LOGIN_INCOMPLETO);
            }
        } catch (Exception e) {
            lblErro.setText(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ConfiguracoesDAO contexto = new ConfiguracoesDAO();
            var configuracoes = contexto.GetAll().get(0);
            lblNomeInstituicao.setText(configuracoes.getNomeInstituicao());
        }
        catch (Exception e) {
            Alerts.showAlert(JavaFXException.TITULO_BANCO_DADOS, null, JavaFXException.MENSAGEM_BANCO_DADOS, Alert.AlertType.WARNING);
        }
    }
}
