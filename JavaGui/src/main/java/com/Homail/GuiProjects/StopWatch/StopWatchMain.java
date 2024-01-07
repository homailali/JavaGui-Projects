package com.Homail.GuiProjects.StopWatch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StopWatchMain extends Application {
    public void start(Stage stage){
        Button button=new Button("Click me!");
        HBox hBox=new HBox();
        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(hBox,600,600,Color.SKYBLUE);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
