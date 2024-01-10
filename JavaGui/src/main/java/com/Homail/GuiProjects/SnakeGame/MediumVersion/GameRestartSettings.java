package com.Homail.GuiProjects.SnakeGame.MediumVersion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

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
            this.deleteSnakeSegments();
            this.resetSpecialFoodRange();
            this.makeXAndYDirectionsZero();
            this.SNAKE_ANIMATION_MAKER.putFoodRandomly();
            this.resetAnimationSpeedAndMakeANewAnimation();
            this.SNAKE_ANIMATION_MAKER.placeSnakeHeadAtCenter();
            this.SNAKE_ANIMATION_MAKER.ANIMATION_HANDLER.setTheLinePosition();
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
    private void resetAnimationSpeedAndMakeANewAnimation(){
        this.SNAKE_ANIMATION_MAKER.timeline.stop();
        this.SNAKE_ANIMATION_MAKER.animationSpeed=150;
        KeyFrame keyFrame=new KeyFrame(Duration.millis(this.SNAKE_ANIMATION_MAKER.animationSpeed),e->this.SNAKE_ANIMATION_MAKER.ANIMATION_HANDLER.mainAnimationHandler());
        this.SNAKE_ANIMATION_MAKER.timeline=new Timeline(keyFrame);
        this.SNAKE_ANIMATION_MAKER.timeline.setCycleCount(Timeline.INDEFINITE);
        this.SNAKE_ANIMATION_MAKER.timeline.play();
    }
    private void resetSpecialFoodRange(){
        this.SNAKE_ANIMATION_MAKER.specialFoodCountRange=10;
    }
}
