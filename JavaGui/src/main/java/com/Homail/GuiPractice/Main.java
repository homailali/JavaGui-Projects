package com.Homail.GuiPractice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label dateTimeLabel = new Label();
        updateDateTimeLabel(dateTimeLabel);

        // Create a timeline to update the label every second
        javafx.animation.Timeline timeline = new javafx.animation.Timeline(
                new javafx.animation.KeyFrame(
                        javafx.util.Duration.seconds(1),
                        event -> updateDateTimeLabel(dateTimeLabel)
                )
        );
        timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(dateTimeLabel, 300, 100);

        primaryStage.setTitle("Date and Time Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateDateTimeLabel(Label label) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y    h/m/s");
        String formattedDateTime = now.format(formatter);

        // Update the label
        label.setText("Current Date and Time: " + formattedDateTime);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
