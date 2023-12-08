package com.messagegui;

import com.messagegui.Controller.BaseController;
import com.messagegui.Controller.CallSceneController;
import com.messagegui.Controller.ContactSceneController;
import com.messagegui.Controller.TextSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public final TextSceneController textScene;
    public final ContactSceneController contactScene;
    public final CallSceneController callScene;

    private SceneManager() throws IOException {
        this.textScene = this.loadScene("/main/TextScene.fxml");
        this.contactScene = this.loadScene("/main/ContactScene.fxml");
        this.callScene = this.loadScene("/main/CallScene.fxml");
    }

    private <T extends BaseController> T loadScene(String localPath)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(localPath));
        try {
            Parent root = loader.load();
            T sceneController = loader.getController();
            sceneController.setRoot(root);
            return sceneController;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static SceneManager instance;

    public static SceneManager getInstance() throws IOException {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public static void switchScene(BaseController newSceneController) {
        Stage primaryStage = App.getPrimaryStage();
        primaryStage.getScene().setRoot(newSceneController.getRoot());
        primaryStage.show();
    }


}
