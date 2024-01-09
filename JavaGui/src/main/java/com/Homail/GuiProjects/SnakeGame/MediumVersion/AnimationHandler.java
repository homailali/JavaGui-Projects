package com.Homail.GuiProjects.SnakeGame.MediumVersion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
public class AnimationHandler {
    // Fields
    private final SnakeController SNAKE_CONTROLLER;
    private final SnakeMain SNAKE_MAIN;
    private final SnakeAnimationMaker SNAKE_ANIMATION_MAKER;
    // Constructor
    public AnimationHandler(SnakeController snakeController, SnakeMain snakeMain, SnakeAnimationMaker snakeAnimationMaker) {
        this.SNAKE_CONTROLLER = snakeController;
        this.SNAKE_MAIN = snakeMain;
        this.SNAKE_ANIMATION_MAKER = snakeAnimationMaker;
    }
    // Methods
    protected void mainAnimationHandler(){
        if (this.SNAKE_ANIMATION_MAKER.boolToStopTheGame) {
            this.displaySnakeFlexibly();
            this.moveTheSnake();
            this.setScoreAtCenter();
            this.checkIfSnakeEatsFood();
            this.setMainBoardTextAtCenter();
            this.checkIfSnakeReachedTheEnds();
            this.checkIfSnakeCollidesWithItself();
            this.modifyMainBoardTextValue();
        }
        this.SNAKE_ANIMATION_MAKER.boolToNotAllowUserPressTwoKeysAtATime = true;
    }
    private void setScoreAtCenter(){
        this.SNAKE_CONTROLLER.scoreText.setLayoutX(this.SNAKE_MAIN.SCENE.getWidth()/2-285);
        this.SNAKE_CONTROLLER.scoreText.setLayoutY(this.SNAKE_MAIN.SCENE.getHeight()/2+37);
    }
    private void setMainBoardTextAtCenter(){
        this.SNAKE_CONTROLLER.mainBoardText.setLayoutY(this.SNAKE_MAIN.SCENE.getHeight()/2+240);
        this.SNAKE_CONTROLLER.mainBoardText.setLayoutX(this.SNAKE_MAIN.SCENE.getWidth()/2-280);
    }
    private void modifyMainBoardTextValue(){
        if (this.SNAKE_ANIMATION_MAKER.xDirection!=0 || this.SNAKE_ANIMATION_MAKER.yDirection!=0){
            this.SNAKE_CONTROLLER.mainBoardText.setVisible(false);
            this.SNAKE_CONTROLLER.mainBoardText.setText("Press space to restart");
        }
        if (!this.SNAKE_ANIMATION_MAKER.boolToStopTheGame){
            this.SNAKE_CONTROLLER.mainBoardText.setVisible(true);
        }
    }
    private void moveTheSnake(){
        this.SNAKE_CONTROLLER.snakeHead.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()+this.SNAKE_ANIMATION_MAKER.xDirection);
        this.SNAKE_CONTROLLER.snakeHead.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()+this.SNAKE_ANIMATION_MAKER.yDirection);
        this.setTheLinePosition();
    }
    private void setTheLinePosition(){
        this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()-8);
        this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()-55);
        this.rotateTheLine();
    }
    private void increaseScore(){
        this.SNAKE_ANIMATION_MAKER.scoreCount++;
        this.SNAKE_CONTROLLER.scoreText.setText(String.valueOf(this.SNAKE_ANIMATION_MAKER.scoreCount));
    }
    private void rotateTheLine(){
        if(this.SNAKE_ANIMATION_MAKER.xDirection==0) {
            this.SNAKE_CONTROLLER.snakeHeadLine.setRotate(0);
        }
        else if (this.SNAKE_ANIMATION_MAKER.yDirection==0){
            this.SNAKE_CONTROLLER.snakeHeadLine.setRotate(90);
        }
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
    private void displaySnakeFlexibly(){
        this.SNAKE_ANIMATION_MAKER.snakeArr.getLast().setVisible(true);
        for (int i=this.SNAKE_ANIMATION_MAKER.snakeArr.size()-1;i>0;i--){
            Rectangle currentSegment=this.SNAKE_ANIMATION_MAKER.snakeArr.get(i);
            Rectangle nextSegment=this.SNAKE_ANIMATION_MAKER.snakeArr.get(i-1);
            currentSegment.setLayoutX(nextSegment.getLayoutX());
            currentSegment.setLayoutY(nextSegment.getLayoutY());
        }
    }
    private void checkIfSnakeEatsFood(){
        if (this.SNAKE_CONTROLLER.snakeHead.getBoundsInParent().intersects(this.SNAKE_CONTROLLER.food.getBoundsInParent())){
            this.increaseScore();
            this.increaseSpeed();
            this.addNewSegmentToSnake();
            this.SNAKE_ANIMATION_MAKER.putFoodRandomly();
        }
    }
    private void addNewSegmentToSnake(){
        Rectangle rectangle=new Rectangle(25,25, Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        this.SNAKE_ANIMATION_MAKER.snakeArr.add(rectangle);
        this.SNAKE_CONTROLLER.mainBoard.getChildren().add(rectangle);
        this.SNAKE_ANIMATION_MAKER.snakeArr.getLast().setVisible(false);
    }
    private void checkIfSnakeReachedTheEnds(){
        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutY()<18) {
            this.SNAKE_CONTROLLER.snakeHead.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()-18);
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutY()+30>this.SNAKE_MAIN.SCENE.getHeight()) {
            this.SNAKE_CONTROLLER.snakeHead.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()+30);
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutX()<18) {
            this.SNAKE_CONTROLLER.snakeHead.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()-18);
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutX()+30>this.SNAKE_MAIN.SCENE.getWidth()) {
            this.SNAKE_CONTROLLER.snakeHead.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()+30);
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
        if (!this.SNAKE_ANIMATION_MAKER.boolToStopTheGame) {
            this.setTheLinePosition();
            this.displaySnakeFlexibly();
        }
    }
    private void makingSnakeHeadTouchTheWalls(){
        while (true){
            if (this.SNAKE_ANIMATION_MAKER.yDirection==0) {
                this.SNAKE_CONTROLLER.snakeHead.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()+1);
            } else{
                this.SNAKE_CONTROLLER.snakeHead.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()+1);
            }

        }
    }
    private void checkIfSnakeCollidesWithItself(){
        for (int i=1;i<this.SNAKE_ANIMATION_MAKER.snakeArr.size()-1;i++){
            if (this.SNAKE_CONTROLLER.snakeHeadLine.getBoundsInParent().intersects(this.SNAKE_ANIMATION_MAKER.snakeArr.get(i).getBoundsInParent())){
                this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
            }
        }

    }
}