module com.example.la {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.la to javafx.fxml;
    exports com.example.la;
}