package com.messagegui.Controller;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class HelperFunctions {
    private static HelperFunctions instance;
    public static HelperFunctions getInstance() {
        if (instance == null) {
            instance = new HelperFunctions();
        }
        return instance;
    }
    public void loadPicture(Circle profilePic, String path) {
        Image image = new Image(String.valueOf(getClass().getResource(path)));
        double sideLength = Math.min(image.getWidth(), image.getHeight());

        ImageView imageView = new ImageView(image);

        imageView.setViewport(new Rectangle2D(
                (image.getWidth() - sideLength) / 2,
                (image.getHeight() - sideLength) / 2,
                sideLength,
                sideLength
        ));

        Circle circleClip = new Circle(sideLength / 2);

        imageView.setClip(circleClip);

        profilePic.setFill(new ImagePattern(imageView.getImage()));
    }
}
