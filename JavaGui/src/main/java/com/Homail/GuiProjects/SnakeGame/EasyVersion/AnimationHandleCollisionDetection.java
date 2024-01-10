package com.Homail.GuiProjects.SnakeGame.EasyVersion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AnimationHandleCollisionDetection {
    // FIELDS
    private PutSnakeOnAnimationAndHandleFood putSnakeOnAnimationAndHandleFood;
    private SnakeFxmlController snakeFxmlController;
    protected GameRestartOperations gameRestartOperations;
    // Constructor
    protected AnimationHandleCollisionDetection(PutSnakeOnAnimationAndHandleFood putSnakeOnAnimationAndHandleFood, SnakeFxmlController snakeFxmlController){
        this.snakeFxmlController=snakeFxmlController;
        this.putSnakeOnAnimationAndHandleFood = putSnakeOnAnimationAndHandleFood;
        this.gameRestartOperations=new GameRestartOperations(snakeFxmlController,putSnakeOnAnimationAndHandleFood,this);
        this.moveTheCircleNamedToCheckIfSnakeCollidesItselfWithTheSnake();
    }
    // METHODS
    protected void handleAnimation(){
        if (this.putSnakeOnAnimationAndHandleFood.startAnimation && this.putSnakeOnAnimationAndHandleFood.stopAnimation) {
            this.displaySnakeFlexibly();
            this.checkIfSnakeReachedTheWalls();
            this.snakeEyesAndCircleSettings();
            this.checkIfSnakeEatsFood();
            this.checkIfSnakeCollidesWithItself();

        }
        this.makeTheNotAllowUserBoolTrue();
    }
    private void makeTheNotAllowUserBoolTrue(){

        this.putSnakeOnAnimationAndHandleFood.notAllowUserPressMultipleKeysAtATime=true;
    }
    // Collide Settings
    private void checkIfSnakeCollidesWithItself(){
        for (int i = 1; i<this.putSnakeOnAnimationAndHandleFood.snakeArr.size(); i++){
            if (this.snakeFxmlController.circleToCheckIfSnakeCollidesItself.getBoundsInParent().intersects(this.putSnakeOnAnimationAndHandleFood.snakeArr.get(i).getBoundsInParent())){
                 this.putSnakeOnAnimationAndHandleFood.stopAnimation=false;
                 this.putSnakeOnAnimationAndHandleFood.startAnimation=false;
                 this.gameRestartOperations.boolToRestartTheGame=false;
                 this.changeMainPageText();
                 this.putEyesAtTheCollidedPlace();
                 break;
            }
        }
    }
    private void changeMainPageText(){
        this.snakeFxmlController.mainPageText.setVisible(true);
        this.snakeFxmlController.mainPageText.setText("Press Space to exit");
    }
    private void putEyesAtTheCollidedPlace(){
        this.snakeFxmlController.snakeHead.toFront();
        this.snakeFxmlController.hboxForEyes.toFront();
        this.snakeFxmlController.circleToCheckIfSnakeCollidesItself.toFront();
        this.snakeFxmlController.snakeHead.setFill(Color.valueOf("#ff0000"));
    }
    // Others
    protected void setScoresOnScreen(){
        this.snakeFxmlController.currentScore.setText("Current-Score:"+this.putSnakeOnAnimationAndHandleFood.currentScoreCount);
        if (this.putSnakeOnAnimationAndHandleFood.currentScoreCount>this.putSnakeOnAnimationAndHandleFood.highestScoreCount){
            this.putSnakeOnAnimationAndHandleFood.highestScoreCount=this.putSnakeOnAnimationAndHandleFood.currentScoreCount;
            this.snakeFxmlController.highestScore.setText("Highest-Score:"+this.putSnakeOnAnimationAndHandleFood.highestScoreCount);
        }
    }
    private void displaySnakeFlexibly(){
        this.putSnakeOnAnimationAndHandleFood.snakeArr.getLast().setVisible(true);
        for (int i = this.putSnakeOnAnimationAndHandleFood.snakeArr.size()-1; i>0; i--){
            Rectangle currentSegment=this.putSnakeOnAnimationAndHandleFood.snakeArr.get(i);
            Rectangle nextSegment=this.putSnakeOnAnimationAndHandleFood.snakeArr.get(i-1);
            currentSegment.setLayoutX(nextSegment.getLayoutX());
            currentSegment.setLayoutY(nextSegment.getLayoutY());
        }
        this.snakeFxmlController.snakeHead.setLayoutX(this.snakeFxmlController.snakeHead.getLayoutX() + this.putSnakeOnAnimationAndHandleFood.xDirection);
        this.snakeFxmlController.snakeHead.setLayoutY(this.snakeFxmlController.snakeHead.getLayoutY() + this.putSnakeOnAnimationAndHandleFood.yDirection);
    }
    protected void moveTheCircleNamedToCheckIfSnakeCollidesItselfWithTheSnake(){
        this.snakeFxmlController.circleToCheckIfSnakeCollidesItself.setLayoutY(this.snakeFxmlController.snakeHead.getLayoutY()+13);
        this.snakeFxmlController.circleToCheckIfSnakeCollidesItself.setLayoutX(this.snakeFxmlController.snakeHead.getLayoutX()+13.5);
    }
    private void checkIfSnakeEatsFood(){
        if (this.snakeFxmlController.snakeHead.getBoundsInParent().intersects(this.snakeFxmlController.food.getBoundsInParent())){
            Rectangle rectangle=new Rectangle(26,26);
            rectangle.setId("snake");
            this.putSnakeOnAnimationAndHandleFood.snakeArr.add(rectangle);
            this.snakeFxmlController.mainBoard.getChildren().add(rectangle);
            this.putSnakeOnAnimationAndHandleFood.snakeArr.getLast().setVisible(false);
            this.putSnakeOnAnimationAndHandleFood.currentScoreCount++;
            this.increaseCurrentScoreForSpecialFood();
            this.putSnakeOnAnimationAndHandleFood.putFoodRandomly();
            this.increaseSnakeSpeed();
            this.setScoresOnScreen();
        }
    }
    private void increaseCurrentScoreForSpecialFood(){
         if (this.snakeFxmlController.food.getFill()==Color.GOLD){
             this.putSnakeOnAnimationAndHandleFood.currentScoreCount+=4;
         }
    }
    private void increaseSnakeSpeed(){
        if (this.putSnakeOnAnimationAndHandleFood.snakeSpeed-1>0) {
            this.putSnakeOnAnimationAndHandleFood.snakeSpeed-=1;
            this.putSnakeOnAnimationAndHandleFood.timeline.stop();
            this.putSnakeOnAnimationAndHandleFood.timeline=new Timeline(new KeyFrame(Duration.millis(this.putSnakeOnAnimationAndHandleFood.snakeSpeed),(e)->this.handleAnimation()));
            this.putSnakeOnAnimationAndHandleFood.timeline.setCycleCount(Timeline.INDEFINITE);
            this.putSnakeOnAnimationAndHandleFood.timeline.play();
        }
    }
    private void checkIfSnakeReachedTheWalls(){
        if (this.snakeFxmlController.snakeHead.getLayoutY()<-5) {
            this.snakeFxmlController.snakeHead.setLayoutY(this.snakeFxmlController.mainBoard.getHeight()-25);
        }
        else if (this.snakeFxmlController.snakeHead.getLayoutY()>this.snakeFxmlController.mainBoard.getHeight()-20) {
            this.snakeFxmlController.snakeHead.setLayoutY(0);
        }
        else if (this.snakeFxmlController.snakeHead.getLayoutX()<-5) {
            this.snakeFxmlController.snakeHead.setLayoutX(this.snakeFxmlController.mainBoard.getWidth()-25);
        }
        else if (this.snakeFxmlController.snakeHead.getLayoutX()>this.snakeFxmlController.mainBoard.getWidth()-20) {
            this.snakeFxmlController.snakeHead.setLayoutX(0);
        }
    }
    private void snakeEyesAndCircleSettings(){
        if (this.putSnakeOnAnimationAndHandleFood.xDirection==0) this.snakeFxmlController.hboxForEyes.setRotate(0);
        else if (this.putSnakeOnAnimationAndHandleFood.yDirection==0) this.snakeFxmlController.hboxForEyes.setRotate(90);
        this.snakeFxmlController.hboxForEyes.setLayoutX(this.snakeFxmlController.snakeHead.getLayoutX());
        this.snakeFxmlController.hboxForEyes.setLayoutY(this.snakeFxmlController.snakeHead.getLayoutY());
        this.moveTheCircleNamedToCheckIfSnakeCollidesItselfWithTheSnake();
    }
}