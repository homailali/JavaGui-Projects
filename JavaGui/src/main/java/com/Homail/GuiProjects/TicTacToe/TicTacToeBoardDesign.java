package com.Homail.GuiProjects.TicTacToe;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class TicTacToeBoardDesign {
    //fields
    boolean bool=true;
    int countForBoxes=4;
    final VBox V_BOX=new VBox();
    final HBox[] H_BOXES=new HBox[5];
    static TicTacToeBoardDesign ticTacToeBoardDesign =new TicTacToeBoardDesign();
    final TicTacToeHandleEvents ticTacToeHandleEvents =new TicTacToeHandleEvents();
    // Constructor
    TicTacToeBoardDesign(){}
    // Getters
    VBox getV_BOX(){
       codeToExecuteBeforeSendingVBox();
       return V_BOX;
    }
    HBox getHBox(){
        HBox hBox=H_BOXES[countForBoxes];
        countForBoxes--;
        return hBox;
    }
    // Others
    void hBoxSettings(){
        for (int i=0;i<H_BOXES.length;i++){
            H_BOXES[i]=new HBox();
        }
        H_BOXES[4]=new HBox(10);
        H_BOXES[0].getChildren().add(TicTacToeNodes.BUTTON_1);
        H_BOXES[0].getChildren().add(TicTacToeNodes.BUTTON_2);
        H_BOXES[0].getChildren().add(TicTacToeNodes.BUTTON_3);
        H_BOXES[1].getChildren().add(TicTacToeNodes.BUTTON_4);
        H_BOXES[1].getChildren().add(TicTacToeNodes.BUTTON_5);
        H_BOXES[1].getChildren().add(TicTacToeNodes.BUTTON_6);
        H_BOXES[2].getChildren().add(TicTacToeNodes.BUTTON_7);
        H_BOXES[2].getChildren().add(TicTacToeNodes.BUTTON_8);
        H_BOXES[2].getChildren().add(TicTacToeNodes.BUTTON_9);
        H_BOXES[3].getChildren().add(TicTacToeNodes.screen);
        H_BOXES[4].getChildren().add(TicTacToeNodes.title);
        H_BOXES[4].getChildren().add(TicTacToeNodes.RESTART);
    }
    void textSettings(){
        H_BOXES[3].setAlignment(Pos.CENTER);
        H_BOXES[4].setAlignment(Pos.CENTER);
        TicTacToeNodes.title.setFont(Font.font(35));
        TicTacToeNodes.title.setTranslateY(-20);
        TicTacToeNodes.title.setFill(Color.WHITE);
        TicTacToeNodes.screen.setFill(Color.WHITE);
        TicTacToeNodes.screen.setTranslateY(-20);
        TicTacToeNodes.screen.setFont(Font.font(35));
    }
    void buttonDesinSettings(){
        class ClassForDesign{
            Font font=new Font(35);
            void restartButtonSettings(){
                TicTacToeNodes.RESTART.setPrefWidth(100);
                TicTacToeNodes.RESTART.setPrefHeight(5);
                TicTacToeNodes.RESTART.setFont(new Font(20));
                TicTacToeNodes.RESTART.setTranslateY(-17);
                TicTacToeNodes.RESTART.setOnAction(ticTacToeHandleEvents);
                TicTacToeNodes.RESTART.setStyle(
                        "-fx-background-color:darkslategray;"+
                        "-fx-text-fill: white;"+
                        "-fx-background-radius:100;"
                );
            }
            void passingButtons(){
                restartButtonSettings();
                settingButtonsDesign(TicTacToeNodes.BUTTON_1);
                settingButtonsDesign(TicTacToeNodes.BUTTON_2);
                settingButtonsDesign(TicTacToeNodes.BUTTON_3);
                settingButtonsDesign(TicTacToeNodes.BUTTON_4);
                settingButtonsDesign(TicTacToeNodes.BUTTON_5);
                settingButtonsDesign(TicTacToeNodes.BUTTON_6);
                settingButtonsDesign(TicTacToeNodes.BUTTON_7);
                settingButtonsDesign(TicTacToeNodes.BUTTON_8);
                settingButtonsDesign(TicTacToeNodes.BUTTON_9);
            }
            void settingButtonsDesign(Button button){
                button.setPrefHeight(90);
                button.setPrefWidth(140);
                button.setFont(font);
                button.setStyle(
                    "-fx-background-color: darkslategray;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-color: black;" +
                    "-fx-border-width: 2;"
                );
                button.setOnAction(ticTacToeHandleEvents);
            }
        }
        ClassForDesign classForDesign=new ClassForDesign();
        classForDesign.passingButtons();
    }
    static TicTacToeBoardDesign getBoardDesign(){

        return ticTacToeBoardDesign;
    }
    void vBoxSettings(VBox vBox){
        vBox.getChildren().add(ticTacToeBoardDesign.getHBox());
        vBox.getChildren().add(ticTacToeBoardDesign.getHBox());
        vBox.getChildren().add(ticTacToeBoardDesign.getHBox());
        vBox.getChildren().add(ticTacToeBoardDesign.getHBox());
        vBox.getChildren().add(ticTacToeBoardDesign.getHBox());
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setStyle(
                "-fx-background-color: #001F3F;"
        );
    }
    void codeToExecuteBeforeSendingVBox(){
        hBoxSettings();
        vBoxSettings(V_BOX);
        buttonDesinSettings();
        textSettings();
    }
}