package com.Homail.GuiProjects.PxToRem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class PxToRemMain extends Application {
    protected Stage stage = new Stage();
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/PxToRem/PxToRemFxml.fxml"));
        Parent parent = fxmlLoader.load();
        PxToRemController pxToRemController = fxmlLoader.getController();
        Scene scene = new Scene(parent);
        // Apply styleSheet
        scene.getStylesheets().add(getClass().getResource("/com/Homail/GuiProjects/PxToRem/pxToRemStyle.css").toExternalForm());

        // pass pxToRemMain to controller
        pxToRemController.getPxToRemMain(this);
        //stage settings
        stageSettings(stage, scene);
    }
    public static void main(String[] args) {

        launch(args);
    }
    private void stageSettings(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Pixel to Rem");
        stage.setAlwaysOnTop(false);
        stage.show();
    }
}