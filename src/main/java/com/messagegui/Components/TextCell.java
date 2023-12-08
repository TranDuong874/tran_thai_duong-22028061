package com.messagegui.Components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

public class TextCell {
    private HBox textCell;
    private VBox imageContainer;
    private Circle profilePic;
    private HBox textContainer;
    private Text messageText;
    private boolean textFrom = true;
    private final int maxWrappingWidth = 200;

    public TextCell() {


    }

    public TextCell(boolean fromText, String content) {
        textCell = new HBox();
        textCell.setPrefHeight(0.0);
        textCell.setPrefWidth(333.0);
        textCell.getStylesheets().add(String.valueOf(getClass().getResource("/main/style.css")));
        textCell.getStyleClass().add("text-cell");

        imageContainer = new VBox();
        imageContainer.setAlignment(Pos.BOTTOM_CENTER);
        imageContainer.getStyleClass().add("image-container");

        profilePic = new Circle();
        profilePic.setFill(Color.DODGERBLUE);
        profilePic.setRadius(15.0);
        profilePic.setStroke(Color.BLACK);
        profilePic.setStrokeType(StrokeType.INSIDE);
        profilePic.getStyleClass().add("profile-pic");

        imageContainer.getChildren().add(profilePic);

        textContainer = new HBox();
        textContainer.setPrefHeight(30.0);
        textContainer.setPrefWidth(39.0);
        textContainer.setStyle("-fx-background-color: pink; -fx-background-radius: 15;");
        textContainer.getStyleClass().add("message-container");

        messageText = new Text();
        messageText.setStrokeType(StrokeType.OUTSIDE);
        messageText.setStrokeWidth(0.0);
        messageText.setWrappingWidth(156.0);
        HBox.setHgrow(messageText, Priority.ALWAYS);
        messageText.getStyleClass().add("text");

        textContainer.getChildren().add(messageText);
        if (!textFrom) {
            textCell.setAlignment(Pos.CENTER_LEFT);
            textCell.getChildren().addAll(imageContainer, textContainer);
        } else {
            textCell.setAlignment(Pos.CENTER_RIGHT);
            textCell.getChildren().addAll(textContainer, imageContainer);
        }
        setText(content);
    }

    public HBox getTextCell() {
        return textCell;
    }

    public void setText(String content) {
        this.messageText.setWrappingWidth(0);
        this.messageText.setText(content);
        double width = this.messageText.getBoundsInLocal().getWidth();
        if (width >= this.maxWrappingWidth)
            this.messageText.setWrappingWidth(this.maxWrappingWidth);
    }
}
