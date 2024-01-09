package com.Homail.GuiProjects.SnakeGame.MediumVersion;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AnimationHandler {
    private final SnakeController SNAKE_CONTROLLER;
    private final SnakeMain SNAKE_MAIN;
    private final SnakeAnimationMaker SNAKE_ANIMATION_MAKER;
    public AnimationHandler(SnakeController snakeController, SnakeMain snakeMain, SnakeAnimationMaker snakeAnimationMaker) {
        this.SNAKE_CONTROLLER = snakeController;
        this.SNAKE_MAIN = snakeMain;
        this.SNAKE_ANIMATION_MAKER = snakeAnimationMaker;
    }

    protected void mainAnimationHandler(){
        if (this.SNAKE_ANIMATION_MAKER.boolToStopTheGame) {
            this.displaySnakeFlexibly();
            this.moveTheSnake();
            this.checkIfSnakeReachedTheEnds();
            this.checkIfSnakeEatsFood();
            this.checkIfSnakeCollidesWithItself();
            this.SNAKE_ANIMATION_MAKER.boolToNotAllowUserPressTwoKeysAtATime = true;
        }
    }


    private void moveTheSnake(){
        this.SNAKE_CONTROLLER.snakeHead.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()+this.SNAKE_ANIMATION_MAKER.xDirection);
        this.SNAKE_CONTROLLER.snakeHead.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()+this.SNAKE_ANIMATION_MAKER.yDirection);
        this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()+9);
        this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()-5);
        this.rotateTheLine();
    }
    private void rotateTheLine(){
        if(this.SNAKE_ANIMATION_MAKER.xDirection==0) {
            this.SNAKE_CONTROLLER.snakeHeadLine.setRotate(0);
            if (this.SNAKE_ANIMATION_MAKER.yDirection<0) this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutY(this.SNAKE_CONTROLLER.snakeHeadLine.getLayoutY()+5);
            else this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutY(this.SNAKE_CONTROLLER.snakeHeadLine.getLayoutY()+30);
        }
        else if (this.SNAKE_ANIMATION_MAKER.yDirection==0){
            this.SNAKE_CONTROLLER.snakeHeadLine.setRotate(90);
            this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutY(this.SNAKE_CONTROLLER.snakeHeadLine.getLayoutY()+17);
            if (this.SNAKE_ANIMATION_MAKER.xDirection<0) this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutX(this.SNAKE_CONTROLLER.snakeHeadLine.getLayoutX()-13);
            else this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutX(this.SNAKE_CONTROLLER.snakeHeadLine.getLayoutX()+13);
        }
    }
    private void checkIfSnakeReachedTheEnds(){
        if (
            this.SNAKE_CONTROLLER.snakeHeadLine.getBoundsInParent().getMinY()<0 ||
            this.SNAKE_CONTROLLER.snakeHeadLine.getBoundsInParent().getMaxY()>this.SNAKE_MAIN.SCENE.getHeight() ||
            this.SNAKE_CONTROLLER.snakeHeadLine.getBoundsInParent().getMinX()<0 ||
            this.SNAKE_CONTROLLER.snakeHeadLine.getBoundsInParent().getMaxX()>this.SNAKE_MAIN.SCENE.getWidth()
        ) {
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
    }
    private void displaySnakeFlexibly(){
        this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.getLast().setVisible(true);
        for (int i=this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.size()-1;i>0;i--){
            Rectangle currentSegment=this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.get(i);
            Rectangle nextSegment=this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.get(i-1);
            currentSegment.setLayoutX(nextSegment.getLayoutX());
            currentSegment.setLayoutY(nextSegment.getLayoutY());
        }
    }
    private void checkIfSnakeEatsFood(){
        if (this.SNAKE_CONTROLLER.snakeHead.getBoundsInParent().intersects(this.SNAKE_CONTROLLER.food.getBoundsInParent())){
            this.increaseSpeed();
            this.addNewSegmentToSnake();
            this.SNAKE_ANIMATION_MAKER.putFoodRandomly();
        }
    }
    private void addNewSegmentToSnake(){
        Rectangle rectangle=new Rectangle(25,25, Color.WHITE);
        this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.add(rectangle);
        this.SNAKE_CONTROLLER.mainBoard.getChildren().add(rectangle);
        this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.getLast().setVisible(false);
    }
    private void increaseSpeed(){
        if (this.SNAKE_ANIMATION_MAKER.animationSpeed-1>0) {
            this.SNAKE_ANIMATION_MAKER.animationSpeed-=1;
            this.SNAKE_ANIMATION_MAKER.timeline.stop();
            KeyFrame keyFrame=new KeyFrame(Duration.millis(this.SNAKE_ANIMATION_MAKER.animationSpeed),e->this.mainAnimationHandler());
            this.SNAKE_ANIMATION_MAKER.timeline=new Timeline(keyFrame);
            this.SNAKE_ANIMATION_MAKER.timeline.setCycleCount(Timeline.INDEFINITE);
            this.SNAKE_ANIMATION_MAKER.timeline.play();
        }
    }
    private void checkIfSnakeCollidesWithItself(){
         for (int i=1;i<this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.size()-1;i++){
             if (this.SNAKE_CONTROLLER.snakeHeadLine.getBoundsInParent().intersects(this.SNAKE_ANIMATION_MAKER.SNAKE_ARR.get(i).getBoundsInParent())){
                 this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
             }
         }
    }
}
