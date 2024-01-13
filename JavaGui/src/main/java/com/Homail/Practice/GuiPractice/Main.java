package com.Homail.Practice.GuiPractice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final int CIRCLE_RADIUS = 50;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: white;"); // Set background color

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                Circle circle = createEmptyCircle();
                gridPane.add(circle, col, row);
            }
        }

        Scene scene = new Scene(gridPane, COLUMNS * (CIRCLE_RADIUS * 2 + 10), ROWS * (CIRCLE_RADIUS * 2 + 10));
        primaryStage.setTitle("Connect Four Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createEmptyCircle() {
        Circle circle = new Circle(CIRCLE_RADIUS, Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setOnMouseClicked(event -> handleCircleClick(circle));
        return circle;
    }

    private void handleCircleClick(Circle circle) {
        // Handle player's move (change circle color, check for win, etc.)
        circle.setFill(Color.RED); // For example, set the color to red for the player's move
    }

    public static void main(String[] args) {
        launch(args);
    }
}
