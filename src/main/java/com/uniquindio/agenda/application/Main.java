package com.uniquindio.agenda.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage= new Stage();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VentanaAgenda.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Principal");
        stage.setScene(scene);
        stage.show();

    }

    public void stop() throws Exception {
        super.stop();
    }


}
