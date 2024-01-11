package com.Homail.Practice.GuiPractice;
import com.Homail.GuiProjects.SnakeGame.EasyVersion.SnakeMainEasy;
import com.Homail.GuiProjects.SnakeGame.MediumVersion.SnakeMainMedium;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private Button easy=new Button("Easy");
    private Button medium=new Button("Medium");
    public void start(Stage primaryStage){
        easy.setOnMouseClicked(this::buttonHandler);
        medium.setOnMouseClicked(this::buttonHandler);


        HBox hBox=new HBox(10);
        hBox.getChildren().add(easy);
        hBox.getChildren().add(medium);
        hBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(hBox,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private List<Integer> doStuff(){
        return new ArrayList<>();
    }

    private void buttonHandler(MouseEvent mouseEvent){
        if (mouseEvent.getSource()==easy){
            launchApplications(SnakeMainEasy.class);
        } else if (mouseEvent.getSource()==medium){
            launchApplications(SnakeMainMedium.class);
        }
    }

    private void launchApplications(Class<? extends Application> snakeGame){
        try {
            Stage stage = new Stage();
            snakeGame.newInstance().start(stage);
        } catch (Exception exception){
            System.out.println("Exception thrown");
        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}