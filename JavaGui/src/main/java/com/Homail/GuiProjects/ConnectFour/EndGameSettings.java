package com.Homail.GuiProjects.ConnectFour;

public class EndGameSettings {
    // Fields
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourBallsThrower CONNECT_FOUR_BALLS_THROWER;
    private final ConnectFourWinnerChecker CONNECT_FOUR_WINNER_CHECKER;
    // Constructor
    public EndGameSettings(ConnectFourMain connectFourMain, ConnectFourController connectFourController, ConnectFourBallsThrower connectFourBallsThrower, ConnectFourWinnerChecker connectFourWinnerChecker) {
        CONNECT_FOUR_MAIN = connectFourMain;
        CONNECT_FOUR_CONTROLLER = connectFourController;
        CONNECT_FOUR_BALLS_THROWER = connectFourBallsThrower;
        CONNECT_FOUR_WINNER_CHECKER = connectFourWinnerChecker;
    }
    // Methods
    protected void endGameMain(){
        this.changeSideScreenColumnThrowText();
        if (this.CONNECT_FOUR_BALLS_THROWER.toIdentifyTheWinner!=2) this.displayTheWinnerInPlayerTurnContainer();
        else this.drawSettings();
    }

    private void drawSettings(){
        this.CONNECT_FOUR_CONTROLLER.turnString.setText("Drawn");
        this.CONNECT_FOUR_CONTROLLER.playerString.setText("Match");
        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setVisible(false);
        this.CONNECT_FOUR_CONTROLLER.turnString.setTranslateX(this.CONNECT_FOUR_CONTROLLER.turnString.getTranslateX()-30);
    }
    private void displayTheWinnerInPlayerTurnContainer(){
        this.CONNECT_FOUR_CONTROLLER.turnString.setText("Won");
        this.CONNECT_FOUR_CONTROLLER.playerTurnCircle.setFill(
                switch (this.CONNECT_FOUR_BALLS_THROWER.toIdentifyTheWinner){
                    case 0->this.CONNECT_FOUR_BALLS_THROWER.PLAYER_ONE_COLOR;
                    case 1->this.CONNECT_FOUR_BALLS_THROWER.PLAYER_TWO_COLOR;
                    default -> throw new RuntimeException();
                }
        );
    }
    private void changeSideScreenColumnThrowText(){
        this.CONNECT_FOUR_CONTROLLER.throwingInColText.setText("Game Ended");
    }
}
