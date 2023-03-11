package com.example.testjavafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);

        primaryStage.show();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.setTitle("ООП четвертая лаба");
    }

    public static void main(String[] args) {
        launch(args);
    }
}