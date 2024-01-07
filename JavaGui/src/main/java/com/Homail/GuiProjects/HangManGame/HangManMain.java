package com.Homail.GuiProjects.HangManGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class HangManMain extends Application {
    Stage stage=new Stage();
    public void start(Stage stage1) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/HangManGame/HangManFxml.fxml"));
        HangManFxmlController.closeButtonHandler= new CloseButtonHandler(this.stage);
        Parent parent=fxmlLoader.load();
        Scene scene=new Scene(parent);
        stageSettings(stage,scene);
    }
    private void stageSettings(Stage stage,Scene scene){
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Hang Man Game");
        stage.getIcons().add(new Image("hangMan.jpg"));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
