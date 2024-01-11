package com.Homail.GuiProjects.ConnectFour;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.util.Arrays;

public class ConnectFourLogic {
    // Fields
    protected final Circle[][] CIRCLE_ARR=new Circle[7][8];
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    // CONSTRUCTOR
    public ConnectFourLogic(ConnectFourMain connectFourMain, ConnectFourController connectFourController) {
        CONNECT_FOUR_MAIN = connectFourMain;
        CONNECT_FOUR_CONTROLLER = connectFourController;
        this.fillArrWithGridPaneCircles();
    }
    // METHODS







    private void fillArrWithGridPaneCircles(){

    }

}
