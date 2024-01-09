package com.Homail.GuiProjects.SnakeGame.MediumVersion;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class SnakeAnimationMaker {
    protected boolean boolToStopTheGame=true;
    protected boolean boolToNotAllowUserPressTwoKeysAtATime=true;
    protected int animationSpeed=150;
    protected int distanceToCover=24;
    protected int xDirection;
    protected int yDirection;
    private final SnakeMain SNAKE_MAIN;
    private final SnakeController SNAKE_CONTROLLER;
    private final AnimationHandler ANIMATION_HANDLER;
    private final Random RANDOM=new Random();
    protected final ArrayList<Rectangle> SNAKE_ARR=new ArrayList<>();
    protected Timeline timeline;
    protected SnakeAnimationMaker(SnakeMain snakeMain, SnakeController snakeController){
        this.SNAKE_MAIN= snakeMain;
        this.SNAKE_CONTROLLER= snakeController;
        ANIMATION_HANDLER=new AnimationHandler(this.SNAKE_CONTROLLER, this.SNAKE_MAIN,this);

    }



    protected void launchAnimation(){
        makeAnimation();
        snakeHeadSettings();
        this.putFoodRandomly();
    }

    private void snakeHeadSettings(){
        this.SNAKE_ARR.add(this.SNAKE_CONTROLLER.snakeHead);
    }
    private void makeAnimation(){
        KeyFrame keyFrame=new KeyFrame(Duration.millis(this.animationSpeed),e->this.ANIMATION_HANDLER.mainAnimationHandler());
        timeline=new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    protected void putFoodRandomly(){
        int xDirection;
        int yDirection;
        boolean bool=true;
        while (bool){
            xDirection=RANDOM.nextInt(20,(int) this.SNAKE_MAIN.SCENE.getWidth()-40);
            yDirection=RANDOM.nextInt(20,(int) this.SNAKE_MAIN.SCENE.getHeight()-40);
            this.SNAKE_CONTROLLER.food.setLayoutY(yDirection);
            this.SNAKE_CONTROLLER.food.setLayoutX(xDirection);
            bool=checkIfPlacedFoodCorrectly();
        }
    }
    private boolean checkIfPlacedFoodCorrectly(){
        for (int i=0;i<this.SNAKE_ARR.size();i++){
            if (this.SNAKE_CONTROLLER.food.getBoundsInParent().intersects(this.SNAKE_ARR.get(i).getBoundsInParent())){
                return true;
            }
        }
        return false;
    }
}
