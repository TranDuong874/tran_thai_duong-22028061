package com.messagegui.Controller;

import com.messagegui.SceneManager;
import javafx.fxml.FXML;

import java.io.IOException;

public class TextSceneController extends BaseController{
    @FXML
    public void toContact() throws IOException {
        SceneManager.switchScene(SceneManager.getInstance().contactScene);
    }
}
