package br.edu.cefsa.sistemadegestao;

import br.cefsa.edu.classeslib.DAO.AlunoDAO;
import br.cefsa.edu.classeslib.DAO.NotaDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class VisualizarNotasController implements Initializable{
    private final String paginaAnterior = "menuPrincipalAluno";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NotaDAO contexto = new NotaDAO();
        var notas = contexto.GetAll();
        var obsList = FXCollections.observableArrayList(notas);

        //tbvNotas.getItems().add(new String[] {"teset", "teset", "teset", "teset", "teset", "teset", "teset"});
        tbvNotas.setItems(obsList);
    }
    
    @FXML
    private TableView tbvNotas = new TableView(); 
    
    @FXML
    private void switchGoBack() throws IOException {
        App.setRoot(paginaAnterior);
    }


}
