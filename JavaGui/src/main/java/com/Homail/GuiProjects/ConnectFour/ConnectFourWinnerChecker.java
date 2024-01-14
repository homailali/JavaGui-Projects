package com.Homail.GuiProjects.ConnectFour;
import javafx.scene.paint.Color;
public class ConnectFourWinnerChecker {
    // Fields
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourBallsThrower CONNECT_FOUR_BALLS_THROWER;
    private final Connect4EndGameSettings END_GAME_SETTINGS;
    // Constructor
    public ConnectFourWinnerChecker(ConnectFourMain connectFourMain, ConnectFourController connectFourController, ConnectFourBallsThrower connectfourballsthrower) {
        this.CONNECT_FOUR_MAIN = connectFourMain;
        this.CONNECT_FOUR_CONTROLLER = connectFourController;
        this.CONNECT_FOUR_BALLS_THROWER = connectfourballsthrower;
        this.END_GAME_SETTINGS=new Connect4EndGameSettings(this.CONNECT_FOUR_MAIN,this.CONNECT_FOUR_CONTROLLER,this.CONNECT_FOUR_BALLS_THROWER,this);
    }
    // Methods
    protected void mainOfConnect4Winner(){

        this.checkIfFourBallsOfSameColorAreTogether();
    }
    private void checkIfFourBallsOfSameColorAreTogether(){
        for (int i=0;i<this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR.length;i++){
            for (int j=0;j<this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i].length;j++){
                if (this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][j].getFill()==this.CONNECT_FOUR_BALLS_THROWER.PLAYER_ONE_COLOR){
                    this.checkingForTogetherBalls(this.CONNECT_FOUR_BALLS_THROWER.PLAYER_ONE_COLOR,i,j);
                } else if (this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][j].getFill()==this.CONNECT_FOUR_BALLS_THROWER.PLAYER_TWO_COLOR){
                    this.checkingForTogetherBalls(this.CONNECT_FOUR_BALLS_THROWER.PLAYER_TWO_COLOR,i,j);
                }

            }
            if (!this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning) break;
        }
        this.checkIfMatchDrawn();
        if (!this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning){
            this.END_GAME_SETTINGS.endGameMain();
        }
    }
    private void checkIfMatchDrawn(){
        if (this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning) {
            boolean bool = false;
            for (int i = 0; i < this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR.length; i++) {
                for (int j = 0; j < this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i].length; j++) {
                    if (this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][j].getFill() == Color.WHITE) bool = true;
                }
            }
            if (!bool) {
                this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning = false;
                this.CONNECT_FOUR_BALLS_THROWER.boolToSeparateDrawAndWinSituation=false;
                this.CONNECT_FOUR_BALLS_THROWER.drawsCount++;
            }
        }
    }
    private void checkingForTogetherBalls(Color color,int row,int column){
       if (this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning){
           this.checkingColumnWise(color,row,column);
           this.checkingForRowWise(color,row,column);
           this.checkingDiagonallyRight(color,row,column);
           this.checkingDiagonallyLeft(color,row,column);
           if (!this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning) {
               this.CONNECT_FOUR_BALLS_THROWER.winnerColor=color;
               this.CONNECT_FOUR_BALLS_THROWER.startColInt=column;
               if (this.CONNECT_FOUR_BALLS_THROWER.boolToCheckIfWonDiagonallyLeft) {
                   if (this.CONNECT_FOUR_BALLS_THROWER.boolToCheckIfWonRowWise) {
                       this.CONNECT_FOUR_BALLS_THROWER.endColInt = column + 3;
                   } else {
                       this.CONNECT_FOUR_CONTROLLER.directionText.setText("Row Wise");
                       this.CONNECT_FOUR_BALLS_THROWER.endColInt=column;
                   }
               }
               else {
                   this.CONNECT_FOUR_CONTROLLER.directionText.setText("Diagonally Left");
                   this.CONNECT_FOUR_BALLS_THROWER.endColInt=column-3;
               }
               this.setStartAndEndText();
           }
       }
    }
    private void setStartAndEndText(){
        if (this.CONNECT_FOUR_BALLS_THROWER.boolToSeparateDrawAndWinSituation) {
            this.CONNECT_FOUR_CONTROLLER.startEndColText.setVisible(true);
            this.CONNECT_FOUR_CONTROLLER.directionText.setVisible(true);
            this.CONNECT_FOUR_CONTROLLER.startEndColText.setText("Start col:"+this.CONNECT_FOUR_BALLS_THROWER.startColInt+" End col:"+this.CONNECT_FOUR_BALLS_THROWER.endColInt);
        }
    }
    private void checkingColumnWise(Color color,int row,int column){
        int columnEnd=column+3;
        if (columnEnd>5) return;
        else {
            for (int i=row;i<=row;i++){
                for (int j=column;j<=columnEnd;j++){
                    if (this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][j].getFill()!=color) return;
                }
            }
        }
        this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning=false;
        this.CONNECT_FOUR_CONTROLLER.directionText.setText("Column wise");
    }
    private void checkingForRowWise(Color color,int row,int column){
        int rowEnd=row+3;
        if (rowEnd>5) return;
        else {
            for (int i=row;i<=rowEnd;i++){
                if (this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][column].getFill()!=color) return;
            }
        }
        this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning=false;
        this.CONNECT_FOUR_BALLS_THROWER.boolToCheckIfWonRowWise=false;
    }
    private void checkingDiagonallyRight(Color color,int row,int column){
        int rowEnd=row+3;
        int columnEnd=column+3;
        if (rowEnd>5 || columnEnd>5) return;
        else {
            for (int i=row;i<=rowEnd;i++){
                if (this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][column].getFill()!=color) return;
                column++;
            }
        }
        this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning=false;
        this.CONNECT_FOUR_CONTROLLER.directionText.setText("Diagonally Right");
    }
    private void checkingDiagonallyLeft(Color color,int row,int column){
        int rowEnd=row+3;
        int columnEnd=column-3;
        if (columnEnd<0 || rowEnd>5) return;
        else {
            for (int i=row;i<=rowEnd;i++){
                if (this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][column].getFill()!=color) return;
                column--;
            }
        }
        this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning=false;
        this.CONNECT_FOUR_BALLS_THROWER.boolToCheckIfWonDiagonallyLeft=false;
    }
}