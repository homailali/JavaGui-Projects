package com.Homail.GuiProjects.Calculator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
public class CalculatorDesigns {
    private static final CalculatorEventHandler calculatorEventHandler=new CalculatorEventHandler();
    private static final GridPane GRID_PANE=new GridPane();
    // GridPane
    private void addButtonsToGridPane(){
        GRID_PANE.add(CalculatorNodes.SCREEN,0,0,4,1);

        GRID_PANE.add(CalculatorNodes.DELETE,0,1,1,1);
        GRID_PANE.add(CalculatorNodes.DOT,1,1,1,1);
        GRID_PANE.add(CalculatorNodes.MODULO,2,1,1,1);
        GRID_PANE.add(CalculatorNodes.DIVIDE,3,1,1,1);

        GRID_PANE.add(CalculatorNodes.BUTTON_7,0,2,1,1);
        GRID_PANE.add(CalculatorNodes.BUTTON_8,1,2,1,1);
        GRID_PANE.add(CalculatorNodes.BUTTON_9,2,2,1,1);
        GRID_PANE.add(CalculatorNodes.MULTIPLY,3,2,1,1);

        GRID_PANE.add(CalculatorNodes.BUTTON_4,0,3,1,1);
        GRID_PANE.add(CalculatorNodes.BUTTON_5,1,3,1,1);
        GRID_PANE.add(CalculatorNodes.BUTTON_6,2,3,1,1);
        GRID_PANE.add(CalculatorNodes.MINUS,3,3,1,1);

        GRID_PANE.add(CalculatorNodes.BUTTON_1,0,4,1,1);
        GRID_PANE.add(CalculatorNodes.BUTTON_2,1,4,1,1);
        GRID_PANE.add(CalculatorNodes.BUTTON_3,2,4,1,1);
        GRID_PANE.add(CalculatorNodes.PLUS,3,4,1,1);

        GRID_PANE.add(CalculatorNodes.BUTTON_0,0,5,2,1);
        GRID_PANE.add(CalculatorNodes.CLEAR_ONE_CHARACTER,2,5,1,1);
        GRID_PANE.add(CalculatorNodes.EQUAL,3,5,1,1);
    }
    private void setUpGridPane(){
        GRID_PANE.setHgap(10);
        GRID_PANE.setVgap(10);
        GRID_PANE.setAlignment(Pos.BOTTOM_CENTER);
        GRID_PANE.setPadding(new Insets(0,0,10,0));
        GRID_PANE.setStyle(
                "-fx-background-color:#F5F5F5;"
        );
    }
    // Screen
    private void screenSettings(){
        CalculatorNodes.SCREEN.setAlignment(Pos.CENTER_LEFT);
        CalculatorNodes.SCREEN.setPrefHeight(40);
        CalculatorNodes.SCREEN.setPrefWidth(100);
        CalculatorNodes.SCREEN.setTranslateY(-10);
        CalculatorNodes.SCREEN.setFont(new Font(20));
        CalculatorNodes.SCREEN.setStyle(
                "-fx-background-color:transparent;"+
                "-fx-border-width:2;"+
                "-fx-border-color:black;"
        );
        CalculatorNodes.SCREEN.setEditable(false);
        CalculatorNodes.SCREEN.setPromptText("Free Palestine");
    }
    // Buttons
    private void setUpAllTheButtons(){
        class ClassForSettingButtons{
             private void passButtons(){
                 setButtons(CalculatorNodes.BUTTON_0,0);
                 setButtons(CalculatorNodes.BUTTON_1,0);
                 setButtons(CalculatorNodes.BUTTON_2,0);
                 setButtons(CalculatorNodes.BUTTON_3,0);
                 setButtons(CalculatorNodes.BUTTON_4,0);
                 setButtons(CalculatorNodes.BUTTON_5,0);
                 setButtons(CalculatorNodes.BUTTON_6,0);
                 setButtons(CalculatorNodes.BUTTON_7,0);
                 setButtons(CalculatorNodes.BUTTON_8,0);
                 setButtons(CalculatorNodes.BUTTON_9,0);
                 setButtons(CalculatorNodes.MINUS,1);
                 setButtons(CalculatorNodes.MODULO,1);
                 setButtons(CalculatorNodes.MULTIPLY,1);
                 setButtons(CalculatorNodes.DIVIDE,1);
                 setButtons(CalculatorNodes.PLUS,1);
                 setButtons(CalculatorNodes.EQUAL,1);
                 setButtons(CalculatorNodes.DELETE,1);
                 setButtons(CalculatorNodes.CLEAR_ONE_CHARACTER,0);
                 setButtons(CalculatorNodes.DOT,1);
                 zeroButtonSettings();
                 multiplyButtonSettings();
             }
             private void setButtons(Button button,int numForColor){
                 button.setFont(new Font(20));
                 button.setOnAction(calculatorEventHandler);
                 switch (numForColor){
                     case 0 -> {
                         button.setStyle(
                                 "-fx-background-radius:5em;"+
                                 "-fx-min-width:50px;"+
                                 "-fx-min-height:50px;"+
                                 "-fx-background-color:#D3D3D3;"+
                                 "-fx-text-fill:black;"
                         );
                     }
                     case 1 -> {
                         button.setStyle(
                                 "-fx-background-radius:5em;"+
                                 "-fx-min-width:50px;"+
                                 "-fx-min-height:50px;"+
                                 "-fx-background-color:#2E5CB8;"+
                                 "-fx-text-fill:white;"
                         );
                     }
                 }
             }
             private void multiplyButtonSettings(){
                 CalculatorNodes.MULTIPLY.setPadding(new Insets(9,0,0,0));
             }
             private void zeroButtonSettings(){
                CalculatorNodes.BUTTON_0.setPrefWidth(110);
                CalculatorNodes.BUTTON_0.setPadding(new Insets(0,60,0,0));
             }
        }
        ClassForSettingButtons classForSettingButtons=new ClassForSettingButtons();
        classForSettingButtons.passButtons();
    }
    private void methodsToCallBeforePassingGridPane(){
        addButtonsToGridPane();
        setUpGridPane();
        setUpAllTheButtons();
        screenSettings();
    }
    GridPane getGridPane(){
        methodsToCallBeforePassingGridPane();
        return GRID_PANE;
    }
}