package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.AlunoDAO;
import br.cefsa.edu.classeslib.DAO.NotaDAO;
import br.cefsa.edu.classeslib.entities.Nota;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VisualizarNotasController implements Initializable {

    private final String paginaAnterior = "menuPrincipalAluno";

    @FXML
    private TableView<NotaRow> tbvNotas = new TableView<>();
    @FXML
    private TableColumn<NotaRow, String> materiaCol;
    @FXML
    private TableColumn<NotaRow, String> professorCol;
    @FXML
    private TableColumn<NotaRow, Nota> n1Col;
    @FXML
    private TableColumn<NotaRow, Nota> n2Col;
    @FXML
    private TableColumn<NotaRow, Nota> n3Col;
    @FXML
    private TableColumn<NotaRow, Nota> n4Col;
    @FXML
    private TableColumn<NotaRow, Double> mediaCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NotaDAO contexto = new NotaDAO();
        var notas = contexto.GetByAluno(1);
        
        NotaRow notaRow = new NotaRow();
        materiaCol.setCellValueFactory(new PropertyValueFactory<>("materiaNome"));
        professorCol.setCellValueFactory(new PropertyValueFactory<>("professorNome"));
        n1Col.setCellValueFactory(new PropertyValueFactory<>("n1"));
        n2Col.setCellValueFactory(new PropertyValueFactory<>("n2"));
        n3Col.setCellValueFactory(new PropertyValueFactory<>("n3"));
        n4Col.setCellValueFactory(new PropertyValueFactory<>("n4"));
        mediaCol.setCellValueFactory(new PropertyValueFactory<>("media"));
        
        
        try {
            List<NotaRow> notasList = notaRow.NotasToNotasTableList(notas);
            tbvNotas.getItems().addAll(notasList);
        } catch (Exception ex) {
            System.out.print("a");
        }
    }

    @FXML
    private void switchGoBack() throws IOException {
        App.setRoot(paginaAnterior);
    }

}
