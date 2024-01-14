package com.Homail.GuiProjects.ConnectFour;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class ConnectFourBallsThrower {
    // Fields
    protected int column;
    private Circle circle;
    protected int endColInt;
    protected int drawsCount;
    protected int startColInt;
    protected  Color winnerColor;
    protected int player1WinsCount;
    protected int player2WinsCount;
    protected int countForPlayerColor;
    protected boolean boolToKeepTheGameRunning;
    private boolean boolToStopMovingTheCircle=true;
    private final ConnectFourMain CONNECT_FOUR_MAIN;
    protected boolean boolToCheckIfWonRowWise=true;
    private final SideScreenManager SIDE_SCREEN_MANAGER;
    protected final Color PLAYER_ONE_COLOR=Color.CRIMSON;
    protected final Color BOARD_CIRCLES_COLOR=Color.WHITE;
    protected boolean boolToCheckIfWonDiagonallyLeft=true;
    protected final Circle[][] CIRCLE_ARR=new Circle[6][6];
    protected final Color PLAYER_TWO_COLOR=Color.DODGERBLUE;
    protected boolean boolToSeparateDrawAndWinSituation=true;
    private final ConnectFourController CONNECT_FOUR_CONTROLLER;
    private final ConnectFourWinnerChecker CONNECT_FOUR_WINNER_CHECKER;
    // CONSTRUCTOR
    public ConnectFourBallsThrower(ConnectFourMain connectFourMain, ConnectFourController connectFourController) {
        this.CONNECT_FOUR_MAIN = connectFourMain;
        this.CONNECT_FOUR_CONTROLLER = connectFourController;
        this.CONNECT_FOUR_WINNER_CHECKER=new ConnectFourWinnerChecker(this.CONNECT_FOUR_MAIN,this.CONNECT_FOUR_CONTROLLER,this);
        this.SIDE_SCREEN_MANAGER=new SideScreenManager(this.CONNECT_FOUR_MAIN,this.CONNECT_FOUR_CONTROLLER,this,this.CONNECT_FOUR_WINNER_CHECKER);
        this.thingsToDoWhenObjectIsCreated();
    }
    // METHODS
    private void thingsToDoWhenObjectIsCreated(){
        this.fillArrWithGridPaneCircles();
        this.boolToKeepTheGameRunning=true;
    }
    protected void pressHandler(MouseEvent mouseEvent){
        if (mouseEvent.getButton()== MouseButton.PRIMARY && this.boolToKeepTheGameRunning) {
            this.setUpTheCircle();
            this.placeTheCircleAtRequiredPlace(mouseEvent);
            this.column=this.updateTheColumn(mouseEvent);
            this.SIDE_SCREEN_MANAGER.upDateTheThrowingInColText();
        }
    }
    protected void dragHandler(MouseEvent mouseEvent){
        if (mouseEvent.getButton()==MouseButton.PRIMARY && this.boolToKeepTheGameRunning) {
            this.checkIfCircleCrossedTheLimits(mouseEvent);
            if (this.boolToStopMovingTheCircle) {
                this.circle.setTranslateX(mouseEvent.getX());
                this.column=this.updateTheColumn(mouseEvent);
                this.SIDE_SCREEN_MANAGER.methodsToActivateWhenTheUserDragsTheCircle();
            }
        }
    }
    protected void releaseHandler(MouseEvent mouseEvent){
        if (mouseEvent.getButton()==MouseButton.PRIMARY && this.boolToKeepTheGameRunning){
            this.fillTheColumnAfterMouseRelease();
            this.SIDE_SCREEN_MANAGER.thingsToCallAfterButtonRelease();
            this.CONNECT_FOUR_CONTROLLER.placeToThrowBalls.getChildren().remove(this.circle);
            this.CONNECT_FOUR_WINNER_CHECKER.mainOfConnect4Winner();
        }
    }
    // Press Settings
    private void setUpTheCircle(){
        this.circle = new Circle();
        this.circle.setFill(this.countForPlayerColor%2==0?this.PLAYER_ONE_COLOR:this.PLAYER_TWO_COLOR);
        this.circle.setStroke(null);
        this.circle.setRadius(26);
        this.circle.setLayoutY(38);
        this.CONNECT_FOUR_CONTROLLER.placeToThrowBalls.add(circle,0,0);
    }
    private void placeTheCircleAtRequiredPlace(MouseEvent mouseEvent){
        if (mouseEvent.getX()<0) this.circle.setTranslateX(0);
        else if (mouseEvent.getX()>295) this.circle.setTranslateX(295);
        else this.circle.setTranslateX(mouseEvent.getX());
    }

    // Drag Settings
    private int updateTheColumn(MouseEvent mouseEvent){
        double columnWidth = 56;
        int column=(int) (mouseEvent.getX() / columnWidth);
        if (column>5) column=5;
        else if (column<0) column=0;
        return column;
    }
    private void checkIfCircleCrossedTheLimits(MouseEvent mouseEvent){
        if (mouseEvent.getX() < 0 || mouseEvent.getX() > 295) {
            this.boolToStopMovingTheCircle = false;
        } else {
            this.boolToStopMovingTheCircle = true;
        }
    }
    // Release Settings
    private void fillTheColumnAfterMouseRelease(){
        boolean bool=false;
        for (int i=this.CIRCLE_ARR.length-1;i>=0;i--){
            if (this.CIRCLE_ARR[i][this.column].getFill()==this.BOARD_CIRCLES_COLOR){
                this.CIRCLE_ARR[i][this.column].setFill(this.countForPlayerColor%2==0?this.PLAYER_ONE_COLOR:this.PLAYER_TWO_COLOR);
                bool=true;
                break;
            }
        }
        if (bool) {
            this.increaseTheCount();
            this.CONNECT_FOUR_CONTROLLER.colFilledText.setText("Go on buddy");
        }
        else {
            this.CONNECT_FOUR_CONTROLLER.colFilledText.setText("Column "+this.column+" filled");
        }
    }
    private void increaseTheCount(){

        this.countForPlayerColor++;
    }
    // Filling the circle arr
    private void fillArrWithGridPaneCircles(){
        int row;
        int column;
        for (Node circle : this.CONNECT_FOUR_CONTROLLER.mainBoard.getChildren()){
            row=returningRowAndColumn(circle,0,-1);
            column=returningRowAndColumn(circle,-1,0);
            this.CIRCLE_ARR[row][column]=(Circle)circle;
            circle.setId((row+""+column));
        }
    }
    private int returningRowAndColumn(Node circle,int row,int column){
        if (row==0){
            try {
                row=GridPane.getRowIndex(circle);
            } catch (Exception exception){
                row=0;
            }
            return row;
        } else {
            try {
                column=GridPane.getColumnIndex(circle);
            } catch (Exception exception){
                column=0;
            }
            return column;
        }
    }
}