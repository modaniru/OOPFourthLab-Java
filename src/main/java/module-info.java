module com.example.testjavafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testjavafxapp to javafx.fxml;
    exports com.example.testjavafxapp;
    exports com.example.testjavafxapp.models;
    opens com.example.testjavafxapp.models to javafx.fxml;
}