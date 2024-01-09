package com.Homail.GuiPractice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Shutdown and Sleep Buttons");

        Button sleepButton = new Button("Sleep Computer");
        sleepButton.setOnAction(e -> sleepComputer());

        Button shutdownButton = new Button("Shutdown Computer");
        shutdownButton.setOnAction(e -> shutdownComputer());

        VBox vBox = new VBox(10); // 10 pixels spacing
        vBox.getChildren().addAll(sleepButton, shutdownButton);

        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void sleepComputer() {
        executeCommand("rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
    }

    private void shutdownComputer() {
        executeCommand("shutdown -s -t 0");
    }

    private void executeCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

