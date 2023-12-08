package com.messagegui;

import com.messagegui.Controller.TextSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        TextSceneController initSC = SceneManager.getInstance().textScene;

        Scene scene = new Scene(SceneManager.getInstance().textScene.getRoot());

        primaryStage.setResizable(false);
        primaryStage.setWidth(335);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}