package com.Homail.GuiProjects.Calculator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CalculatorEventHandler implements EventHandler<ActionEvent> {
    private String screenGlobalVariable=CalculatorNodes.SCREEN.getText();
    private final CheckForBugsInText CHECK_FOR_BUGS_IN_TEXT=new CheckForBugsInText();
    public void handle(ActionEvent actionEvent) {
         CalculatorNodes.SCREEN.setPromptText("Free Palestine");
         screenGlobalVariable=CalculatorNodes.SCREEN.getText();
         Button button=checkingTheButtonPresses(actionEvent);
         checkingTheValueOfButtonPressed(button);
    }
    private void checkingTheValueOfButtonPressed(Button button){
        if (button.getText().equals("=")) CHECK_FOR_BUGS_IN_TEXT.main();
        else if (button.getText().equalsIgnoreCase("AC")) clearScreen();
        else if (button.getText().equalsIgnoreCase("C1")) clearOneCharacter();
        else fillScreen(button);
    }
    private void fillScreen(Button button){

        CalculatorNodes.SCREEN.appendText(button.getText());
    }
    private void clearOneCharacter(){
        StringBuilder stringBuilder=new StringBuilder(screenGlobalVariable);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        CalculatorNodes.SCREEN.setText(String.valueOf(stringBuilder));
    }
    private void clearScreen(){

        CalculatorNodes.SCREEN.setText("");
    }
    private Button checkingTheButtonPresses(ActionEvent actionEvent){
        if (actionEvent.getSource()==CalculatorNodes.DELETE) return CalculatorNodes.DELETE;
        else if (actionEvent.getSource()==CalculatorNodes.DOT) return CalculatorNodes.DOT;
        else if (actionEvent.getSource()==CalculatorNodes.MODULO) return CalculatorNodes.MODULO;
        else if (actionEvent.getSource()==CalculatorNodes.DIVIDE) return CalculatorNodes.DIVIDE;

        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_7) return CalculatorNodes.BUTTON_7;
        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_8) return CalculatorNodes.BUTTON_8;
        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_9) return CalculatorNodes.BUTTON_9;
        else if (actionEvent.getSource()==CalculatorNodes.MULTIPLY) return CalculatorNodes.MULTIPLY;

        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_4) return CalculatorNodes.BUTTON_4;
        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_5) return CalculatorNodes.BUTTON_5;
        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_6) return CalculatorNodes.BUTTON_6;
        else if (actionEvent.getSource()==CalculatorNodes.MINUS) return CalculatorNodes.MINUS;

        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_1) return CalculatorNodes.BUTTON_1;
        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_2) return CalculatorNodes.BUTTON_2;
        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_3) return CalculatorNodes.BUTTON_3;
        else if (actionEvent.getSource()==CalculatorNodes.PLUS) return CalculatorNodes.PLUS;

        else if (actionEvent.getSource()==CalculatorNodes.BUTTON_0) return CalculatorNodes.BUTTON_0;
        else if (actionEvent.getSource()==CalculatorNodes.CLEAR_ONE_CHARACTER) return CalculatorNodes.CLEAR_ONE_CHARACTER;
        else if (actionEvent.getSource()==CalculatorNodes.EQUAL) return CalculatorNodes.EQUAL;
        else return null;
    }
}