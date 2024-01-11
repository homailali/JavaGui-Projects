package com.Homail.GuiProjects.ConnectFour;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class ConnectFourMain extends Application {
    // Fields
    private final FXMLLoader FXMLLOADER=new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/ConnectFour/Connect4Fxml.fxml"));
    private final Parent PARENT=FXMLLOADER.load();
    private final Scene SCENE=new Scene(PARENT);
    private final Stage STAGE=new Stage();
    private final ConnectFourController CONNECT_FOUR_CONTROLLER=FXMLLOADER.getController();
    private final ConnectFourLogic CONNECT_FOUR_LOGIC=new ConnectFourLogic(this,this.CONNECT_FOUR_CONTROLLER);
    // Constructor
    public ConnectFourMain() throws IOException {
    }
    // Methods
    public void start(Stage primaryStage){
        this.sceneSettings();
        this.stageSettings();
    }
    private void sceneSettings(){

        this.SCENE.getStylesheets().add(getClass().getResource("/com/Homail/GuiProjects/ConnectFour/Connect4Css.css").toExternalForm());
    }
    private void stageSettings(){
        this.STAGE.setScene(this.SCENE);
        this.STAGE.setResizable(false);
        this.STAGE.setTitle("Connect Four");
        this.STAGE.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}
