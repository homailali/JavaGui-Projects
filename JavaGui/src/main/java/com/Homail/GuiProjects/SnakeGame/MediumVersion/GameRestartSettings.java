package com.Homail.GuiProjects.SnakeGame.MediumVersion;
import java.util.ArrayList;
public class GameRestartSettings {
    // Fields
    private final SnakeController SNAKE_CONTROLLER;
    private final SnakeAnimationMaker SNAKE_ANIMATION_MAKER;
    // Constructor
    public GameRestartSettings(SnakeController snakeController, SnakeAnimationMaker snakeAnimationMaker) {
        SNAKE_CONTROLLER = snakeController;
        SNAKE_ANIMATION_MAKER = snakeAnimationMaker;
    }
    // Methods
    protected void restartMain(){
        if (!this.SNAKE_ANIMATION_MAKER.boolToStopTheGame){
            this.resetScores();
            this.setMainBoardText();
            this.makeTheGameRunAble();
            this.resetAnimationSpeed();
            this.deleteSnakeSegments();
            this.makeXAndYDirectionsZero();
            this.SNAKE_ANIMATION_MAKER.putFoodRandomly();
            this.SNAKE_ANIMATION_MAKER.placeSnakeHeadAtCenter();
        }
    }

    private void makeTheGameRunAble(){

        this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=true;
    }
    private void setMainBoardText(){

        this.SNAKE_CONTROLLER.mainBoardText.setText("To start press one ← ↓ ↑ →");
    }
    private void makeXAndYDirectionsZero(){
        this.SNAKE_ANIMATION_MAKER.xDirection=0;
        this.SNAKE_ANIMATION_MAKER.yDirection=0;
    }
    private void deleteSnakeSegments(){
        this.SNAKE_ANIMATION_MAKER.snakeArr.removeFirst();
        this.SNAKE_CONTROLLER.mainBoard.getChildren().removeAll(this.SNAKE_ANIMATION_MAKER.snakeArr);
        this.SNAKE_ANIMATION_MAKER.snakeArr=new ArrayList<>();
        this.SNAKE_ANIMATION_MAKER.snakeArr.add(this.SNAKE_CONTROLLER.snakeHead);
    }
    private void resetScores(){
        this.SNAKE_ANIMATION_MAKER.scoreCount=0;
        this.SNAKE_CONTROLLER.scoreText.setText(String.valueOf(this.SNAKE_ANIMATION_MAKER.scoreCount));
    }
    private void resetAnimationSpeed(){

        this.SNAKE_ANIMATION_MAKER.animationSpeed=150;
    }
}
