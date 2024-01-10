package com.Homail.GuiProjects.SnakeGame.MediumVersion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
public class SnakeMainMedium extends Application {
    //Fields
    private final FXMLLoader FXML_LOADER=new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/SnakeGame/Medium/SnakeMediumFxml.fxml"));
    private final Parent PARENT=FXML_LOADER.load();
    protected final Scene SCENE=new Scene(PARENT,570,570);
    private final Stage STAGE=new Stage();
    private final SnakeController SNAKE_CONTROLLER=FXML_LOADER.getController();
    private final SnakeAnimationMaker SNAKE_ANIMATION_MAKER=new SnakeAnimationMaker(this, this.SNAKE_CONTROLLER);
    private final HandleSnakeMovement HANDLE_SNAKE_MOVEMENT=new HandleSnakeMovement(SNAKE_CONTROLLER,SNAKE_ANIMATION_MAKER);
    // Constructor
    public SnakeMainMedium() throws IOException {
    }
    // Methods
    public void start(Stage primaryStage){
        this.SNAKE_ANIMATION_MAKER.launchAnimation();
        sceneSettings();
        stageSettings();
    }
    private void sceneSettings(){

        this.SCENE.setOnKeyPressed(this.HANDLE_SNAKE_MOVEMENT);
    }
    private void stageSettings(){
        this.STAGE.setScene(SCENE);
        this.STAGE.setTitle("Medium Snake Game");
        this.STAGE.getIcons().add(new Image("snakeMedium.png"));
        this.STAGE.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}