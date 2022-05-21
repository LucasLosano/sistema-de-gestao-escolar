module br.edu.cefsa.sistemadegestao {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.cefsa.sistemadegestao to javafx.fxml;
    exports br.edu.cefsa.sistemadegestao;
}
