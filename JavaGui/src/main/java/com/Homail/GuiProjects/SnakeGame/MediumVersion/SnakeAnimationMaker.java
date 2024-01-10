package com.Homail.GuiProjects.SnakeGame.MediumVersion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Random;
public class SnakeAnimationMaker {
    // Fields
    protected int specialFoodCountRange=10;
    protected int scoreCount=0;
    protected boolean boolToStopTheGame=true;
    protected boolean boolToNotAllowUserPressTwoKeysAtATime=true;
    protected int animationSpeed=150;
    protected int distanceToCover=24;
    protected int xDirection;
    protected int yDirection;
    protected final SnakeMainMedium SNAKE_MAIN;
    private final SnakeController SNAKE_CONTROLLER;
    protected final AnimationHandler ANIMATION_HANDLER;
    private final Random RANDOM=new Random();
    protected  ArrayList<Rectangle> snakeArr=new ArrayList<>();
    protected Timeline timeline;
    // Constructor
    protected SnakeAnimationMaker(SnakeMainMedium snakeMainMedium, SnakeController snakeController){
        this.SNAKE_MAIN= snakeMainMedium;
        this.SNAKE_CONTROLLER= snakeController;
        ANIMATION_HANDLER=new AnimationHandler(this.SNAKE_CONTROLLER, this.SNAKE_MAIN,this);

    }
    // Methods
    protected void launchAnimation(){
        this.makeAnimation();
        this.putFoodRandomly();
        this.snakeHeadSettings();
        this.placeSnakeHeadAtCenter();
        this.ANIMATION_HANDLER.setScoreCountAsTextOnScreen();
    }
    private void snakeHeadSettings(){

        this.snakeArr.add(this.SNAKE_CONTROLLER.snakeHead);
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
        for (int i=0;i<this.snakeArr.size();i++){
            if (this.SNAKE_CONTROLLER.food.getBoundsInParent().intersects(this.snakeArr.get(i).getBoundsInParent())){
                return true;
            }
        }
        return false;
    }
    protected void placeSnakeHeadAtCenter(){
        this.SNAKE_CONTROLLER.snakeHead.setLayoutY(this.SNAKE_MAIN.SCENE.getHeight()/2-8);
        this.SNAKE_CONTROLLER.snakeHead.setLayoutX(this.SNAKE_MAIN.SCENE.getWidth()/2-8);
    }
}