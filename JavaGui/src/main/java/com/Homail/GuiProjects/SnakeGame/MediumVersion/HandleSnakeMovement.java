package com.Homail.GuiProjects.SnakeGame.MediumVersion;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class HandleSnakeMovement implements EventHandler<KeyEvent>{
    // Fields
    private final SnakeController SNAKE_CONTROLLER;
    private final SnakeAnimationMaker SNAKE_ANIMATION_MAKER;
    private final GameRestartSettings GAME_RESTART_SETTINGS;
    // Constructor
    public HandleSnakeMovement(SnakeController snakeController, SnakeAnimationMaker snakeAnimationMaker) {
        SNAKE_CONTROLLER = snakeController;
        SNAKE_ANIMATION_MAKER = snakeAnimationMaker;
        GAME_RESTART_SETTINGS=new GameRestartSettings(this.SNAKE_CONTROLLER,this.SNAKE_ANIMATION_MAKER);
    }
    // Methods
    public void handle(KeyEvent keyEvent) {

        this.moveTheSnake(keyEvent);
    }
    private void moveTheSnake(KeyEvent keyEvent){
        if (this.SNAKE_ANIMATION_MAKER.boolToNotAllowUserPressTwoKeysAtATime) {
            switch (keyEvent.getCode()) {
                case UP -> {
                    this.makeTheNotAllowUserPressMultipleKeysBoolFalse();
                    if (this.SNAKE_ANIMATION_MAKER.yDirection == 0)
                        changeSnakeDirections(0, -this.SNAKE_ANIMATION_MAKER.distanceToCover);
                }
                case DOWN -> {
                    this.makeTheNotAllowUserPressMultipleKeysBoolFalse();
                    if (this.SNAKE_ANIMATION_MAKER.yDirection == 0)
                        changeSnakeDirections(0, this.SNAKE_ANIMATION_MAKER.distanceToCover);
                }
                case LEFT -> {
                    this.makeTheNotAllowUserPressMultipleKeysBoolFalse();
                    if (this.SNAKE_ANIMATION_MAKER.xDirection == 0)
                        changeSnakeDirections(-this.SNAKE_ANIMATION_MAKER.distanceToCover, 0);
                }
                case RIGHT -> {
                    this.makeTheNotAllowUserPressMultipleKeysBoolFalse();
                    if (this.SNAKE_ANIMATION_MAKER.xDirection == 0)
                        changeSnakeDirections(this.SNAKE_ANIMATION_MAKER.distanceToCover, 0);
                }
                case SPACE -> {

                    this.GAME_RESTART_SETTINGS.restartMain();
                }
            }
        }
    }
    private void changeSnakeDirections(int xDirection,int yDirection){
        this.SNAKE_ANIMATION_MAKER.xDirection=xDirection;
        this.SNAKE_ANIMATION_MAKER.yDirection=yDirection;
    }
    private void makeTheNotAllowUserPressMultipleKeysBoolFalse(){

        this.SNAKE_ANIMATION_MAKER.boolToNotAllowUserPressTwoKeysAtATime=false;
    }
}