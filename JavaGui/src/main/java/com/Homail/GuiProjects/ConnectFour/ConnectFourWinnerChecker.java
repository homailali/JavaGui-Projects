package com.Homail.GuiProjects.ConnectFour;
import javafx.scene.paint.Color;
public class ConnectFourWinnerChecker {
    // Fields
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourBallsThrower CONNECT_FOUR_BALLS_THROWER;
    private final EndGameSettings END_GAME_SETTINGS;
    // Constructor
    public ConnectFourWinnerChecker(ConnectFourMain connectFourMain, ConnectFourController connectFourController, ConnectFourBallsThrower connectfourballsthrower) {
        this.CONNECT_FOUR_MAIN = connectFourMain;
        this.CONNECT_FOUR_CONTROLLER = connectFourController;
        this.CONNECT_FOUR_BALLS_THROWER = connectfourballsthrower;
        this.END_GAME_SETTINGS=new EndGameSettings(this.CONNECT_FOUR_MAIN,this.CONNECT_FOUR_CONTROLLER,this.CONNECT_FOUR_BALLS_THROWER,this);
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
                    if (!this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning) this.CONNECT_FOUR_BALLS_THROWER.toIdentifyTheWinner=1;
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
                this.CONNECT_FOUR_BALLS_THROWER.toIdentifyTheWinner = 2;
            }
        }
    }
    private void checkingForTogetherBalls(Color color,int row,int column){
       if (this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning){
           this.checkingColumnWise(color,row,column);
           this.checkingForRowWise(color,row,column);
           this.checkingDiagonallyRight(color,row,column);
           this.checkingDiagonallyLeft(color,row,column);
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
    }
}