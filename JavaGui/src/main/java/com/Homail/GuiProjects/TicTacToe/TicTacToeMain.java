/*  CopyRight all rights reserved author:Homail ali Date:27/12/2023
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
 */
package com.Homail.GuiProjects.TicTacToe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class TicTacToeMain extends Application{
    public void start(Stage stage){
        TicTacToeBoardDesign ticTacToeBoardDesign = TicTacToeBoardDesign.getBoardDesign();
        VBox vBox= ticTacToeBoardDesign.getV_BOX();
        Scene scene=new Scene(vBox,300,400);
        scene.setFill(Color.MEDIUMBLUE);
        stageSettings(stage,scene);
    }
    public static void main(String[] args){

        launch(args);
    }
    void stageSettings(Stage stage,Scene scene){
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.getIcons().add(new Image("Tic-tac-toe.png"));
        stage.show();
    }
}