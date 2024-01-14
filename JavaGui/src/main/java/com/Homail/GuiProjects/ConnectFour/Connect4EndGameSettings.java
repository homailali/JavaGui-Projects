package com.Homail.GuiProjects.ConnectFour;
import javafx.scene.paint.Color;
public class Connect4EndGameSettings {
    // Fields
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourBallsThrower CONNECT_FOUR_BALLS_THROWER;
    private final ConnectFourWinnerChecker CONNECT_FOUR_WINNER_CHECKER;
    // Constructor
    public Connect4EndGameSettings(ConnectFourMain connectFourMain, ConnectFourController connectFourController, ConnectFourBallsThrower connectFourBallsThrower, ConnectFourWinnerChecker connectFourWinnerChecker) {
        CONNECT_FOUR_MAIN = connectFourMain;
        CONNECT_FOUR_CONTROLLER = connectFourController;
        CONNECT_FOUR_BALLS_THROWER = connectFourBallsThrower;
        CONNECT_FOUR_WINNER_CHECKER = connectFourWinnerChecker;
    }
    // Methods
    protected void endGameMain(){
        this.increaseWinCount();
        this.setWinAndDrawText();
        this.setColFilledAndDirectionText();
        this.changeSideScreenColumnThrowText();
        if (this.CONNECT_FOUR_BALLS_THROWER.boolToSeparateDrawAndWinSituation) this.displayTheWinnerInPlayerTurnContainer();
        else this.drawSettings();
    }
    private void drawSettings(){
        this.CONNECT_FOUR_CONTROLLER.turnString.setText("Drawn");
        this.CONNECT_FOUR_CONTROLLER.playerString.setText("Match");
        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setVisible(false);
        this.CONNECT_FOUR_CONTROLLER.playerString.setLayoutX(this.CONNECT_FOUR_CONTROLLER.playerString.getLayoutX()+15);
        this.CONNECT_FOUR_CONTROLLER.turnString.setLayoutX(this.CONNECT_FOUR_CONTROLLER.turnString.getLayoutX()-15);
    }
    private void displayTheWinnerInPlayerTurnContainer(){
        this.CONNECT_FOUR_CONTROLLER.turnString.setText("Won");
        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setFill(this.CONNECT_FOUR_BALLS_THROWER.winnerColor);
    }
    private void changeSideScreenColumnThrowText(){
        this.CONNECT_FOUR_CONTROLLER.throwingInColText.setText("Game Ended");
    }
    private void increaseWinCount(){
        if (this.CONNECT_FOUR_BALLS_THROWER.winnerColor== Color.CRIMSON && this.CONNECT_FOUR_BALLS_THROWER.boolToSeparateDrawAndWinSituation) this.CONNECT_FOUR_BALLS_THROWER.player1WinsCount++;
        else if (this.CONNECT_FOUR_BALLS_THROWER.winnerColor==Color.DODGERBLUE && this.CONNECT_FOUR_BALLS_THROWER.boolToSeparateDrawAndWinSituation) this.CONNECT_FOUR_BALLS_THROWER.player2WinsCount++;
    }
    private void setWinAndDrawText(){
        this.CONNECT_FOUR_CONTROLLER.drawsText.setText("Draws "+this.CONNECT_FOUR_BALLS_THROWER.drawsCount);
        this.CONNECT_FOUR_CONTROLLER.player1WinsText.setText("Wins "+this.CONNECT_FOUR_BALLS_THROWER.player1WinsCount);
        this.CONNECT_FOUR_CONTROLLER.player2WinsText.setText("Wins "+this.CONNECT_FOUR_BALLS_THROWER.player2WinsCount);
    }
    private void setColFilledAndDirectionText(){

        this.CONNECT_FOUR_CONTROLLER.colFilledText.setText("Match ended");
    }
}