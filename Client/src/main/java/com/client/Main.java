package com.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        Button btn1 = new Button("Botón 1");
        Button btn2 = new Button("Botón 2");
        root.getChildren().addAll(btn1, btn2);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Mi Aplicación JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
