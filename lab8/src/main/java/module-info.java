module com.example.lab8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.lab8 to javafx.fxml;
    exports com.example.lab8;
}