package com.messagegui.Controller;

import com.messagegui.Components.TextCell;
import com.messagegui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextSceneController extends BaseController{
    String fromUser = "/main/ainsley.jpg";
    String toUser = "/main/pepe.jpg";
    List<TextCell> textHistory = new ArrayList<>();

    @FXML
    protected VBox messageBox;
    @FXML
    protected Circle userProfilePic;

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
    protected ScrollPane messageScroll;
    public void initialize() {
        messageScroll.vvalueProperty().bind(messageBox.heightProperty());
        HelperFunctions.getInstance().loadPicture(userProfilePic, fromUser);
    }
    @FXML
    public void sendText() {
        if (textEditor.getText().isEmpty()) return;
        if (cnt % 2 == 1) {
            currentSender = !currentSender;
        }
        cnt++;
        String content = textEditor.getText();
        TextCell textCell = new TextCell(currentSender, content);
        if (currentSender) {
            HelperFunctions.getInstance().loadPicture(textCell.getProfilePic(), fromUser);
        } else {
            HelperFunctions.getInstance().loadPicture(textCell.getProfilePic(), toUser);
        }

        messageBox.getChildren().add(textCell.getTextCell());
        textEditor.clear();
        textHistory.add(textCell);
    }


}
