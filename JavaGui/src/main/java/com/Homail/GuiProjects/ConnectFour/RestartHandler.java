package com.Homail.GuiProjects.ConnectFour;

public class RestartHandler {
    // Fields
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourBallsThrower CONNECT_FOUR_BALLS_THROWER;
    private final ConnectFourWinnerChecker CONNECT_FOUR_WINNER_CHECKER;
    // Constructor
    public RestartHandler(ConnectFourMain connectFourMain, ConnectFourController connectFourController, ConnectFourBallsThrower connectFourBallsThrower, ConnectFourWinnerChecker connectFourWinnerChecker) {
        CONNECT_FOUR_MAIN = connectFourMain;
        CONNECT_FOUR_CONTROLLER = connectFourController;
        CONNECT_FOUR_BALLS_THROWER = connectFourBallsThrower;
        CONNECT_FOUR_WINNER_CHECKER = connectFourWinnerChecker;
    }
}
