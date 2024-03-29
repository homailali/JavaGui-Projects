package com.Homail.GuiProjects.SnakeGame.EasyVersion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class SnakeMainEasy extends Application {
    // Fields
    private FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/SnakeGame/Easy/SnakeFxmlFile.fxml"));
    private Parent parent=fxmlLoader.load();
    private SnakeFxmlController snakeFxmlController=fxmlLoader.getController();
    private Scene scene=new Scene(parent);
    private Stage stage=new Stage();
    private PutSnakeOnAnimationAndHandleFood putSnakeOnAnimationAndHandleFood =new PutSnakeOnAnimationAndHandleFood(snakeFxmlController);
    private SceneEventHandler sceneEventHandler=new SceneEventHandler(this,snakeFxmlController, putSnakeOnAnimationAndHandleFood);
    // Constructor
    public SnakeMainEasy() throws IOException {
    }
    // METHODS
    public void start(Stage stage){
        putSnakeOnAnimationAndHandleFood.launchAnimation();
        sceneSettings();
        stageSettings();
    }
    private void sceneSettings(){
        this.scene.getStylesheets().add(getClass().getResource("/com/Homail/GuiProjects/SnakeGame/Easy/SnakeStyle.css").toExternalForm());
        this.scene.setOnKeyPressed(this.sceneEventHandler);
    }
    private void stageSettings(){
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.stage.setTitle("Easy Snake Game");
        this.stage.getIcons().add(new Image("snakeEasy.png"));
        this.stage.setAlwaysOnTop(true);
        this.stage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}
