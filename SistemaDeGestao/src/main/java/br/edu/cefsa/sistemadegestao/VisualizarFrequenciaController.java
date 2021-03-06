package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.FrequenciaDAO;
import br.cefsa.edu.classeslib.entities.Login;
import br.cefsa.edu.classeslib.exception.messages.JavaFXException;
import br.edu.cefsa.helper.Alerts;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VisualizarFrequenciaController implements Initializable {

    private final String paginaAnterior = "menuPrincipalAluno";

    @FXML
    private TableView<FrequenciaRow> tbvFrequencia = new TableView<>();
    @FXML
    private TableColumn<FrequenciaRow, String> materiaCol;
    @FXML
    private TableColumn<FrequenciaRow, String> professorCol;
    @FXML
    private TableColumn<NotaRow, Double> frequenciaCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FrequenciaDAO contexto = new FrequenciaDAO();
            var frequencias = contexto.GetByAluno(Login.getInstance().getIdUsuario());

            FrequenciaRow frequenciaRow = new FrequenciaRow();
            materiaCol.setCellValueFactory(new PropertyValueFactory<>("materiaNome"));
            professorCol.setCellValueFactory(new PropertyValueFactory<>("professorNome"));
            frequenciaCol.setCellValueFactory(new PropertyValueFactory<>("frequencia"));

            List<FrequenciaRow> frequenciaList = frequenciaRow.FrequenciaListToFrequenciaTableList(frequencias);
            tbvFrequencia.getItems().addAll(frequenciaList);
        } catch (Exception ex) {
            Alerts.showAlert(JavaFXException.TITULO_BANCO_DADOS, null, JavaFXException.MENSAGEM_BANCO_DADOS, Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void switchGoBack() throws IOException {
        App.setRoot(paginaAnterior);
    }

}
