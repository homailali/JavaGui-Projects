package com.Homail.GuiProjects.RockPaperScissors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Application;
public class RPSMain extends Application{
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/RockPaperScissorsResources/RPSFxml.fxml"));
        Parent parent=fxmlLoader.load();
        Scene scene=new Scene(parent);
        stageSettings(stage,scene);
    }
    private void stageSettings(Stage stage, Scene scene){
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Rock Paper Scissor");
        stage.getIcons().add(new Image("rockPaperScissor.jpg"));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
