package com.Homail.GuiProjects.ToDoApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ToDoMain extends Application  {
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/ToDoApp/ToDoFxml.fxml"));
        Parent parent=fxmlLoader.load();
        parent.getStylesheets().add(getClass().getResource("/com/Homail/GuiProjects/ToDoApp/Style.css").toExternalForm());
        Scene scene=new Scene(parent);
        stageSettings(stage,scene);
    }
    private void stageSettings(Stage stage,Scene scene){
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("To Do App");
        stage.getIcons().add(new Image("to-do-app.jpeg"));
        stage.show();
    }
    public static void main(String[] args) {
       launch(args);
    }
}
