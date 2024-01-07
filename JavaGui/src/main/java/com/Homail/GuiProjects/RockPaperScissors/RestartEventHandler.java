package com.Homail.GuiProjects.RockPaperScissors;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
public class RestartEventHandler implements EventHandler<MouseEvent>{
    private RPSFxmlController rpsFxmlController;
    RestartEventHandler(RPSFxmlController rpsFxmlController){

        this.rpsFxmlController=rpsFxmlController;
    }
    public void handle(MouseEvent mouseEvent){

        rpsFxmlController.initialize(null,null);
    }
}
