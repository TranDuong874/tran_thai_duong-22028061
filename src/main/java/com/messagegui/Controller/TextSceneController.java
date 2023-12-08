package com.messagegui.Controller;

import com.messagegui.Components.TextCell;
import com.messagegui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextSceneController extends BaseController{
    List<TextCell> textHistory = new ArrayList<>();

    @FXML
    protected VBox messageBox;

    @FXML
    public void toContact() throws IOException {
        SceneManager.switchScene(SceneManager.getInstance().contactScene);
    }

    @FXML
    public void startCall() throws IOException {
        SceneManager.switchScene(SceneManager.getInstance().callScene);
    }

    @FXML
    TextField textEditor;

    static boolean currentSender = false;
    static int cnt = 1;
    @FXML
    public void sendText() {
        if (cnt % 2 == 1) {
            currentSender = !currentSender;
        }
        cnt++;
        String content = textEditor.getText();
        TextCell textCell = new TextCell(currentSender, content);
        messageBox.getChildren().add(textCell.getTextCell());
        textEditor.clear();
        textHistory.add(textCell);
    }


}
