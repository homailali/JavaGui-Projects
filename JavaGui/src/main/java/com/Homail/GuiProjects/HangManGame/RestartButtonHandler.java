package com.Homail.GuiProjects.HangManGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class RestartButtonHandler implements EventHandler<ActionEvent>{
    private HangManFxmlController hangManFxmlController;
    // Constructor
    RestartButtonHandler(HangManFxmlController hangManFxmlController){
        this.hangManFxmlController=hangManFxmlController;

    }
    public void handle(ActionEvent actionEvent){
         textAndTextFieldSettings();
         callingTheInitializeMethod();
    }
    private void textAndTextFieldSettings(){
        hangManFxmlController.textField.clear();
        hangManFxmlController.textField.setPromptText("Enter a word or a char");
        hangManFxmlController.rightOrWrongMove.setText("Take a guess");
    }
    private void callingTheInitializeMethod(){
        hangManFxmlController.initialize(null,null);
    }

}
