package com.Homail.GuiProjects.ConnectFour;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
public class Connect4RestartHandler implements EventHandler<MouseEvent> {
    // Fields
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourBallsThrower CONNECT_FOUR_BALLS_THROWER;
    // Constructor
    public Connect4RestartHandler(ConnectFourMain connectFourMain, ConnectFourController connectFourController, ConnectFourBallsThrower connectFourBallsThrower) {
        CONNECT_FOUR_MAIN = connectFourMain;
        CONNECT_FOUR_CONTROLLER = connectFourController;
        CONNECT_FOUR_BALLS_THROWER = connectFourBallsThrower;
    }
    // Methods
    public void handle(MouseEvent mouseEvent) {
        if (!this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning) {
            this.resetAllCounts();
            this.resetColFilledText();
            this.hideStartEndColText();
            this.resetTheThrowInColText();
            this.makeAllBoardCirclesWhite();
            this.resetPlayerTurnContainer();
            this.resetAllTheBools();
        }
    }
    private void resetPlayerTurnContainer(){
        if (!this.CONNECT_FOUR_BALLS_THROWER.boolToSeparateDrawAndWinSituation) this.reSettingThePlayerTurnContainerForDrawSituation();
        else this.reSettingThePlayerTurnContainerForWinSituation();
    }
    private void reSettingThePlayerTurnContainerForWinSituation(){
        this.CONNECT_FOUR_CONTROLLER.turnString.setText("turn");
        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setFill(Color.CRIMSON);
    }
    private void reSettingThePlayerTurnContainerForDrawSituation(){
        this.CONNECT_FOUR_CONTROLLER.playerString.setText("Player");
        this.CONNECT_FOUR_CONTROLLER.playerString.setLayoutX(this.CONNECT_FOUR_CONTROLLER.playerString.getLayoutX()-15);

        this.CONNECT_FOUR_CONTROLLER.turnString.setText("turn");
        this.CONNECT_FOUR_CONTROLLER.turnString.setLayoutX(this.CONNECT_FOUR_CONTROLLER.turnString.getLayoutX()+15);

        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setFill(Color.CRIMSON);
        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setVisible(true);
        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setLayoutX(this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.getLayoutX()+2.5);
    }
    private void resetTheThrowInColText(){

        this.CONNECT_FOUR_CONTROLLER.throwingInColText.setText("Throwing in column ");
    }
    private void makeAllBoardCirclesWhite(){
        for (int i=0;i<this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR.length;i++){
            for (int j=0;j<this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i].length;j++){
                this.CONNECT_FOUR_BALLS_THROWER.CIRCLE_ARR[i][j].setFill(Color.WHITE);
            }
        }
    }
    private void resetAllCounts(){
        this.CONNECT_FOUR_BALLS_THROWER.endColInt=0;
        this.CONNECT_FOUR_BALLS_THROWER.startColInt=0;
        this.CONNECT_FOUR_BALLS_THROWER.countForPlayerColor=0;
    }
    private void resetAllTheBools(){
        this.CONNECT_FOUR_BALLS_THROWER.boolToKeepTheGameRunning=true;
        this.CONNECT_FOUR_BALLS_THROWER.boolToCheckIfWonRowWise=true;
        this.CONNECT_FOUR_BALLS_THROWER.boolToCheckIfWonDiagonallyLeft=true;
        this.CONNECT_FOUR_BALLS_THROWER.boolToSeparateDrawAndWinSituation=true;
    }
    private void resetColFilledText(){

        this.CONNECT_FOUR_CONTROLLER.colFilledText.setText("Go on buddy");
    }
    private void hideStartEndColText(){
        this.CONNECT_FOUR_CONTROLLER.directionText.setVisible(false);
        this.CONNECT_FOUR_CONTROLLER.startEndColText.setVisible(false);
    }
}