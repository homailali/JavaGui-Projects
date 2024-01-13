package com.Homail.Practice.GuiPractice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    private GridPane gridPane;
    private Circle circle;
    private int initialColumn;

    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: white;"); // Set background color

        circle = createMovableCircle();
        gridPane.add(circle, 0, 0);

        Scene scene = new Scene(gridPane, 400, 400);
        setupMouseHandlers();

        primaryStage.setTitle("Drag Circle in GridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createMovableCircle() {
        Circle circle = new Circle(20, Color.BLUE);
        circle.setStroke(Color.BLACK);
        return circle;
    }

    private void setupMouseHandlers() {
        circle.setOnMousePressed(this::handleMousePressed);
        circle.setOnMouseDragged(this::handleMouseDragged);
        circle.setOnMouseReleased(this::handleMouseReleased);
    }

    private void handleMousePressed(MouseEvent event) {
        initialColumn = GridPane.getColumnIndex(circle);
    }

    private void handleMouseDragged(MouseEvent event) {
        circle.setCenterX(event.getX());
    }

    private void handleMouseReleased(MouseEvent event) {
        int releasedColumn = calculateReleasedColumn(event.getX());
        System.out.println("Circle released at column: " + releasedColumn);
    }

    private int calculateReleasedColumn(double x) {
        // Assuming each column width is 50 units
        int columnWidth = 50;
        int releasedColumn = initialColumn + (int) (x / columnWidth);
        return Math.max(0, Math.min(gridPane.getColumnConstraints().size() - 1, releasedColumn));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
