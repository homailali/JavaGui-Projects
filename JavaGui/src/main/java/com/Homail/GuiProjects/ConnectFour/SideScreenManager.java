package com.Homail.GuiProjects.ConnectFour;
public class SideScreenManager {
    // Fields
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourBallsThrower CONNECT_FOUR_BALLS_THROWER;
    private final ConnectFourWinnerChecker CONNECT_FOUR_WINNER_CHECKER;
    // Constructor
    public SideScreenManager(ConnectFourMain connectFourMain, ConnectFourController connectFourController, ConnectFourBallsThrower connectFourBallsThrower, ConnectFourWinnerChecker connectFourWinnerChecker) {
        CONNECT_FOUR_MAIN = connectFourMain;
        CONNECT_FOUR_CONTROLLER = connectFourController;
        CONNECT_FOUR_BALLS_THROWER = connectFourBallsThrower;
        CONNECT_FOUR_WINNER_CHECKER = connectFourWinnerChecker;
    }
    // Methods
    // These methods will activate as soon as user releases the primary key
    protected void thingsToCallAfterButtonRelease(){
        this.resetTheThrowingInColText();
        this.managePlayersTurnCircleColor();
    }
    private void managePlayersTurnCircleColor(){
        if (this.CONNECT_FOUR_BALLS_THROWER.countForPlayerColor%2==0)  this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setFill(this.CONNECT_FOUR_BALLS_THROWER.PLAYER_ONE_COLOR);
        else this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setFill(this.CONNECT_FOUR_BALLS_THROWER.PLAYER_TWO_COLOR);
    }
    private void resetTheThrowingInColText(){

        this.CONNECT_FOUR_CONTROLLER.throwingInColText.setText("Throwing in column ");
    }
    // These methods are going to activate as the user drags the key
    protected void methodsToActivateWhenTheUserDragsTheCircle(){

        this.upDateTheThrowingInColText();
    }
    protected void upDateTheThrowingInColText(){

        this.CONNECT_FOUR_CONTROLLER.throwingInColText.setText("Throwing in column "+this.CONNECT_FOUR_BALLS_THROWER.column);
    }
}