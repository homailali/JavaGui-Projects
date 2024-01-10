package com.Homail.GuiProjects.SnakeGame.MediumVersion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
public class AnimationHandler {
    // Fields
    private final SnakeController SNAKE_CONTROLLER;
    private final SnakeMainMedium SNAKE_MAIN;
    private final SnakeAnimationMaker SNAKE_ANIMATION_MAKER;
    // Constructor
    public AnimationHandler(SnakeController snakeController, SnakeMainMedium snakeMainMedium, SnakeAnimationMaker snakeAnimationMaker) {
        this.SNAKE_CONTROLLER = snakeController;
        this.SNAKE_MAIN = snakeMainMedium;
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
            this.moveTheMainBoardTextAndScoreTextToTop();
            this.checkIfSnakeReachedTheEnds();
            this.checkIfSnakeCollidesWithItself();
            this.modifyMainBoardTextValue();
        }
        this.SNAKE_ANIMATION_MAKER.boolToNotAllowUserPressTwoKeysAtATime = true;
    }
    private void moveTheMainBoardTextAndScoreTextToTop(){
        this.SNAKE_CONTROLLER.scoreText.toFront();
        this.SNAKE_CONTROLLER.mainBoardText.toFront();
    }
    private void setScoreAtCenter(){
        this.SNAKE_CONTROLLER.scoreText.setLayoutX(this.SNAKE_MAIN.SCENE.getWidth()/2-283);
        this.SNAKE_CONTROLLER.scoreText.setLayoutY(this.SNAKE_MAIN.SCENE.getHeight()/2+37);
    }
    private void setMainBoardTextAtCenter(){
        this.SNAKE_CONTROLLER.mainBoardText.setLayoutY(this.SNAKE_MAIN.SCENE.getHeight()/2-240);
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
    protected void setTheLinePosition(){
        this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutX(this.SNAKE_CONTROLLER.snakeHead.getLayoutX()-8);
        this.SNAKE_CONTROLLER.snakeHeadLine.setLayoutY(this.SNAKE_CONTROLLER.snakeHead.getLayoutY()-55);
        this.rotateTheLine();
    }
    private void increaseScore(){
        this.SNAKE_ANIMATION_MAKER.scoreCount++;

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
            this.throwSpecialFood();
            this.addNewSegmentToSnake();
            this.setScoreCountAsTextOnScreen();
            this.SNAKE_ANIMATION_MAKER.putFoodRandomly();
        }
    }
    protected void setScoreCountAsTextOnScreen(){

        this.SNAKE_CONTROLLER.scoreText.setText(String.valueOf(this.SNAKE_ANIMATION_MAKER.scoreCount));
    }
    private void throwSpecialFood(){
        if (this.SNAKE_ANIMATION_MAKER.scoreCount==this.SNAKE_ANIMATION_MAKER.specialFoodCountRange){
            this.SNAKE_ANIMATION_MAKER.scoreCount+=5;
            this.SNAKE_ANIMATION_MAKER.specialFoodCountRange+=15;
        }
        if (this.SNAKE_ANIMATION_MAKER.scoreCount+1==this.SNAKE_ANIMATION_MAKER.specialFoodCountRange){
            this.SNAKE_CONTROLLER.food.setFill(Color.valueOf("#6D2E46"));
        } else {
            this.SNAKE_CONTROLLER.food.setFill(Color.valueOf("#57A773"));
        }
    }
    private void addNewSegmentToSnake(){
        Rectangle rectangle=new Rectangle(25,25, Color.WHITE);
        this.SNAKE_ANIMATION_MAKER.snakeArr.add(rectangle);
        this.SNAKE_CONTROLLER.mainBoard.getChildren().add(rectangle);
        this.SNAKE_ANIMATION_MAKER.snakeArr.getLast().setVisible(false);
    }
    private void checkIfSnakeReachedTheEnds(){

        double minY=0;
        double minX=0;
        double maxY=this.SNAKE_MAIN.SCENE.getHeight()-(this.SNAKE_CONTROLLER.snakeHead.getHeight());
        double maxX=this.SNAKE_MAIN.SCENE.getWidth()-(this.SNAKE_CONTROLLER.snakeHead.getWidth());


        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutY()<minY) {
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutY()>maxY) {
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutX()<minX) {
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
        }
        if (this.SNAKE_CONTROLLER.snakeHead.getLayoutX()>maxX) {
            this.SNAKE_ANIMATION_MAKER.boolToStopTheGame=false;
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