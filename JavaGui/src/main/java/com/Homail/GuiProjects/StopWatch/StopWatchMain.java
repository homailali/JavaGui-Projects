package com.Homail.GuiProjects.StopWatch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StopWatchMain extends Application {
    protected Stage stage=new Stage();
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/Homail/GuiProjects/StopWatch/StopWatchFxml.fxml"));
        Parent parent=fxmlLoader.load();
        StopWatchController stopWatchController=fxmlLoader.getController();

        StopWatchLogic stopWatchLogic=new StopWatchLogic(this,stopWatchController);
        this.sendStopWatchLogicInstanceToController(stopWatchController,stopWatchLogic);

        Scene scene=new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/com/Homail/GuiProjects/StopWatch/StopWatchcss.css").toExternalForm());

        stageSettings(scene);
    }

    private void sendStopWatchLogicInstanceToController(StopWatchController stopWatchController,StopWatchLogic stopWatchLogic){
        stopWatchController.getStopWatchLogic(stopWatchLogic);
    }

    private void stageSettings(Scene scene){
        this.stage.setScene(scene);
        this.stage.setTitle("Stop Watch");
        this.stage.setResizable(false);
        stage.getIcons().add(new Image("stopWatch.png"));
        this.stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
