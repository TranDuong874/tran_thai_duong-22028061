package com.messagegui.Controller;

import com.messagegui.SceneManager;
import javafx.fxml.FXML;

import java.io.IOException;

public class CallSceneController extends BaseController {
    @FXML
    public void endCall() throws IOException {
        SceneManager.switchScene(SceneManager.getInstance().textScene);
    }
}
