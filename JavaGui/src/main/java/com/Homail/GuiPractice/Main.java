package com.Homail.GuiPractice;

import com.Homail.GuiProjects.SnakeGame.EasyVersion.SnakeMainEasy;
import com.Homail.GuiProjects.SnakeGame.MediumVersion.SnakeMainMedium;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Main extends Application{
    Button button0=new Button("Easy Version");
    Button button1=new Button("Medium Version");
    public void start(Stage stage){
        VBox vBox=new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(button0);
        vBox.getChildren().add(button1);

        button0.setOnMouseClicked(this::buttonHandler);
        button1.setOnMouseClicked(this::buttonHandler);

        Scene scene=new Scene(vBox,400,400);
        stage.setScene(scene);
        stage.show();
    }
    private void buttonHandler(MouseEvent mouseEvent){
        if (mouseEvent.getSource()==button0) SnakeMainEasy.main(new String[]{});
        else if (mouseEvent.getSource()==button1) SnakeMainMedium.main(new String[]{});
    }
}