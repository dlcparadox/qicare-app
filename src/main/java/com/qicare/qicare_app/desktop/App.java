package com.qicare.qicare_app.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Bem-vindo ao AcuCare App");
        Scene scene = new Scene(label, 400, 300);
        stage.setScene(scene);
        stage.setTitle("AcuCare App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
