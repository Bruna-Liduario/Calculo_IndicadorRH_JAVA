module amor.mensagens {
    requires javafx.controls;
    requires javafx.fxml;


    opens amor.mensagens to javafx.fxml;
    exports amor.mensagens;
}