package com.Homail.GuiProjects.SnakeGame.MediumVersion;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class HandleSnakeMovement implements EventHandler<KeyEvent>{

    private final SnakeController SNAKE_CONTROLLER;
    private final SnakeAnimationMaker SNAKE_ANIMATION_MAKER;
    public HandleSnakeMovement(SnakeController snakeController, SnakeAnimationMaker snakeAnimationMaker) {
        SNAKE_CONTROLLER = snakeController;
        SNAKE_ANIMATION_MAKER = snakeAnimationMaker;
    }





    public void handle(KeyEvent keyEvent) {
        this.moveTheSnake(keyEvent);
    }



    private void moveTheSnake(KeyEvent keyEvent){

        if (this.SNAKE_ANIMATION_MAKER.boolToNotAllowUserPressTwoKeysAtATime) {
            switch (keyEvent.getCode()) {
                case UP -> {
                    if (this.SNAKE_ANIMATION_MAKER.yDirection == 0)
                        changeSnakeDirections(0, -this.SNAKE_ANIMATION_MAKER.distanceToCover);
                }
                case DOWN -> {
                    if (this.SNAKE_ANIMATION_MAKER.yDirection == 0)
                        changeSnakeDirections(0, this.SNAKE_ANIMATION_MAKER.distanceToCover);
                }
                case LEFT -> {
                    if (this.SNAKE_ANIMATION_MAKER.xDirection == 0)
                        changeSnakeDirections(-this.SNAKE_ANIMATION_MAKER.distanceToCover, 0);
                }
                case RIGHT -> {
                    if (this.SNAKE_ANIMATION_MAKER.xDirection == 0)
                        changeSnakeDirections(this.SNAKE_ANIMATION_MAKER.distanceToCover, 0);
                }
            }
        }
    }

    private void changeSnakeDirections(int xDirection,int yDirection){
        this.SNAKE_ANIMATION_MAKER.xDirection=xDirection;
        this.SNAKE_ANIMATION_MAKER.yDirection=yDirection;
        this.SNAKE_ANIMATION_MAKER.boolToNotAllowUserPressTwoKeysAtATime=false;
    }

}
