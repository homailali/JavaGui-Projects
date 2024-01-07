package com.Homail.GuiProjects.StopWatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StopWatchMain extends Application {
    private int count=0;
    private Text text=new Text("0");
    public void start(Stage stage){
        HBox hBox=new HBox();
        hBox.getChildren().add(text);
        hBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(hBox,600,600,Color.SKYBLUE);
        stage.setScene(scene);
        makeAnimation();
        stage.show();
    }
    private void makeAnimation(){
        this.text.setFont(new Font(40));
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(1),e->animationHandler());
        Timeline timeline=new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void animationHandler(){
        count++;
        this.text.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
