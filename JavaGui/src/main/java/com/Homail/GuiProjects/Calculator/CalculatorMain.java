package com.Homail.GuiProjects.Calculator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorMain extends Application{
    public void start(Stage stage){
        CalculatorDesigns calculatorDesigns=new CalculatorDesigns();
        GridPane gridPane=calculatorDesigns.getGridPane();
        Scene scene=new Scene(gridPane,260,400);
        //stage Settings
        stageSettings(stage,scene);
    }
    private void stageSettings(Stage stage, Scene scene){
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.getIcons().add(new Image("calculator-icon.png"));
        stage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}