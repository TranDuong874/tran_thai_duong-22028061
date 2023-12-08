package com.messagegui.Controller;

import javafx.scene.Parent;
public class BaseController {
    private Parent root;

    public void setRoot(Parent root) {
        this.root = root;
    }

    public Parent getRoot() {
        return root;
    }
}
