package com.Homail.GuiProjects.SnakeGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.ArrayList;
public class GameRestartOperations {
    // Fields
    protected boolean boolToRestartTheGame=true;
    private SnakeFxmlController snakeFxmlController;
    private PutSnakeOnAnimationAndHandleFood putSnakeOnAnimationAndHandleFood;
    private AnimationHandleCollisionDetection animationHandleCollisionDetection;
    // Constructor
    protected GameRestartOperations(SnakeFxmlController snakeFxmlController, PutSnakeOnAnimationAndHandleFood putSnakeOnAnimationAndHandleFood, AnimationHandleCollisionDetection animationHandleCollisionDetection){
        this.snakeFxmlController=snakeFxmlController;
        this.putSnakeOnAnimationAndHandleFood=putSnakeOnAnimationAndHandleFood;
        this.animationHandleCollisionDetection = animationHandleCollisionDetection;
    }
    // METHODS
    protected void main(){

        this.operationsToPerformIfSnakeCollidesItself();
    }
    private void operationsToPerformIfSnakeCollidesItself(){
        this.resetSnakeSpeed();
        this.resetCurrentScore();
        this.modifyXAndYValues();
        this.changeStartPageText();
        this.changeSnakeHeadColor();
        this.stopGameAndShowScreen();
        this.resetSpecialFoodSettings();
        this.makeMainScreenTextDisappear();
        this.removingSnakesFromSnakeArrAndBoard();
        this.placeSnakeAtCenterAndMakeItMoveXWise();
        this.resetSnakeEyes();
    }
    private void resetSpecialFoodSettings(){
        this.putSnakeOnAnimationAndHandleFood.rangeForSpecialFood=10;
        this.snakeFxmlController.food.setFill(Color.WHITE);
    }

    private void removingSnakesFromSnakeArrAndBoard(){
        for (int i = 1; i<this.putSnakeOnAnimationAndHandleFood.snakeArr.size(); i++){
            this.snakeFxmlController.mainBoard.getChildren().remove(this.putSnakeOnAnimationAndHandleFood.snakeArr.get(i));
        }
        this.putSnakeOnAnimationAndHandleFood.snakeArr=new ArrayList<>();
        this.putSnakeOnAnimationAndHandleFood.snakeArr.add(this.snakeFxmlController.snakeHead);
    }
    private void placeSnakeAtCenterAndMakeItMoveXWise(){
        this.snakeFxmlController.snakeHead.setLayoutY(242);
        this.snakeFxmlController.snakeHead.setLayoutX(242);
        this.putSnakeOnAnimationAndHandleFood.xDirection=this.putSnakeOnAnimationAndHandleFood.coverDistance;
        this.putSnakeOnAnimationAndHandleFood.yDirection=0;
    }
    private void resetSnakeSpeed(){
        this.putSnakeOnAnimationAndHandleFood.snakeSpeed=150;
        this.putSnakeOnAnimationAndHandleFood.timeline.stop();
        this.putSnakeOnAnimationAndHandleFood.timeline=new Timeline(new KeyFrame(Duration.millis(this.putSnakeOnAnimationAndHandleFood.snakeSpeed), e->this.animationHandleCollisionDetection.handleAnimation()));
        this.putSnakeOnAnimationAndHandleFood.timeline.setCycleCount(Timeline.INDEFINITE);
        this.putSnakeOnAnimationAndHandleFood.timeline.play();
    }
    private void stopGameAndShowScreen(){
        this.putSnakeOnAnimationAndHandleFood.stopAnimation=false;
        this.snakeFxmlController.startingPage.setVisible(true);
    }
    private void resetSnakeEyes(){
        this.snakeFxmlController.hboxForEyes.setLayoutX(this.snakeFxmlController.snakeHead.getLayoutX());
        this.snakeFxmlController.hboxForEyes.setLayoutY(this.snakeFxmlController.snakeHead.getLayoutY());
    }
    private void changeStartPageText(){

        this.snakeFxmlController.startPageText.setText("To play again press Enter");
    }
    private void resetCurrentScore(){
        this.putSnakeOnAnimationAndHandleFood.currentScoreCount=0;
        this.animationHandleCollisionDetection.setScoresOnScreen();
    }
    private void makeMainScreenTextDisappear(){
        this.snakeFxmlController.mainPageText.setVisible(false);

    }
    private void changeSnakeHeadColor(){

        this.snakeFxmlController.snakeHead.setFill(Color.valueOf("#414141"));
    }
    private void modifyXAndYValues(){
        this.putSnakeOnAnimationAndHandleFood.xDirection=0;
        this.putSnakeOnAnimationAndHandleFood.yDirection=0;
    }
}