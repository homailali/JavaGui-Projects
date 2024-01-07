package com.Homail.GuiProjects.HangManGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CloseButtonHandler implements EventHandler<ActionEvent>{
    Stage stage;
    CloseButtonHandler(Stage stage){
        this.stage=stage;
    }
    public void handle(ActionEvent actionEvent){
        stage.close();
    }

}
