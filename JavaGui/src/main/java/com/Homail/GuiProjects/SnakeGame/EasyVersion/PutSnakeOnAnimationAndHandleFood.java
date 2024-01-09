package com.Homail.GuiProjects.SnakeGame.EasyVersion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Random;
public class PutSnakeOnAnimationAndHandleFood {
    //FIELDS
    protected boolean notAllowUserPressMultipleKeysAtATime=true;
    protected int rangeForSpecialFood=10;
    protected double snakeSpeed=150;
    protected int currentScoreCount;
    protected int highestScoreCount;
    protected int coverDistance=27;
    protected int yDirection=0;
    protected int xDirection=0;
    protected boolean startAnimation=false;
    protected boolean stopAnimation;
    private Random random=new Random();
    protected ArrayList<Rectangle> snakeArr=new ArrayList<>();
    protected SnakeFxmlController snakeFxmlController;
    protected AnimationHandleCollisionDetection animationHandleCollisionDetection;
    protected  KeyFrame keyFrame = new KeyFrame(Duration.millis(this.snakeSpeed), (e) -> animationHandleCollisionDetection.handleAnimation());
    protected Timeline timeline = new Timeline(keyFrame);
    //CONSTRUCTOR
    protected PutSnakeOnAnimationAndHandleFood(SnakeFxmlController snakeFxmlController){
        this.snakeFxmlController=snakeFxmlController;
        animationHandleCollisionDetection =new AnimationHandleCollisionDetection(this,snakeFxmlController);
    }
    //METHODS
    protected void launchAnimation(){
        snakeHeadSettings();
        makingAnimation();
        putFoodRandomly();
    }
    private void snakeHeadSettings(){

        this.snakeArr.add(this.snakeFxmlController.snakeHead);
    }
    private void makingAnimation(){

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    protected void putFoodRandomly(){
        int xDirection;
        int yDirection;
        boolean bool=true;
        while (bool){
            xDirection=random.nextInt(20,480);
            yDirection=random.nextInt(20,480);
            this.snakeFxmlController.food.setLayoutX(xDirection);
            this.snakeFxmlController.food.setLayoutY(yDirection);
            bool=checkIfFoodPlacedOnSnake();
        }
        if (this.currentScoreCount==this.rangeForSpecialFood){
            this.snakeFxmlController.food.setFill(Color.GOLD);
            this.rangeForSpecialFood+=15;
        } else {
            this.snakeFxmlController.food.setFill(Color.WHITE);
        }
    }
    private boolean checkIfFoodPlacedOnSnake(){
        for (int i=0;i<this.snakeArr.size();i++){
            if (this.snakeFxmlController.food.getBoundsInParent().intersects(this.snakeArr.get(i).getBoundsInParent())){
                return true;
            }
        }
        return false;
    }
}