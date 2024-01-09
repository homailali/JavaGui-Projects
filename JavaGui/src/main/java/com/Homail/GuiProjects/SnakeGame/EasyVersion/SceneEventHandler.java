package com.Homail.GuiProjects.SnakeGame.EasyVersion;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
public class SceneEventHandler implements EventHandler<KeyEvent>{
    // Fields
    private SnakeMain snakeMain;
    private PutSnakeOnAnimationAndHandleFood putSnakeOnAnimationAndHandleFood;
    private SnakeFxmlController snakeFxmlController;
    // Constructor
    public SceneEventHandler(SnakeMain snakeMain, SnakeFxmlController snakeFxmlController, PutSnakeOnAnimationAndHandleFood putSnakeOnAnimationAndHandleFood){
        this.snakeMain=snakeMain;
        this.putSnakeOnAnimationAndHandleFood = putSnakeOnAnimationAndHandleFood;
        this.snakeFxmlController=snakeFxmlController;
    }
    public void handle(KeyEvent keyEvent){
        boolean bool=checkIFUserPressedSpace(keyEvent);
        bool=checkingIfKeyPressedIsEnter(keyEvent,bool);
        if (bool) moveTheSnake(keyEvent);
    }
    private void moveTheSnake(KeyEvent keyEvent){
        KeyCode keyCode=keyEvent.getCode();
        if (this.putSnakeOnAnimationAndHandleFood.notAllowUserPressMultipleKeysAtATime) {
            switch (keyCode) {
                case UP -> {
                    this.moveSnakeAndMakeMainTextInvisible();
                    if (this.putSnakeOnAnimationAndHandleFood.yDirection == 0)
                        modifyValuesToMoveTheSnake(0, -this.putSnakeOnAnimationAndHandleFood.coverDistance);
                }
                case DOWN -> {
                    this.moveSnakeAndMakeMainTextInvisible();
                    if (this.putSnakeOnAnimationAndHandleFood.yDirection == 0)
                        modifyValuesToMoveTheSnake(0, this.putSnakeOnAnimationAndHandleFood.coverDistance);
                }
                case LEFT -> {
                    this.moveSnakeAndMakeMainTextInvisible();
                    if (this.putSnakeOnAnimationAndHandleFood.xDirection == 0)
                        modifyValuesToMoveTheSnake(-this.putSnakeOnAnimationAndHandleFood.coverDistance, 0);
                }
                case RIGHT -> {
                    this.moveSnakeAndMakeMainTextInvisible();
                    if (this.putSnakeOnAnimationAndHandleFood.xDirection == 0)
                        modifyValuesToMoveTheSnake(this.putSnakeOnAnimationAndHandleFood.coverDistance, 0);
                }
            }
        }
    }

    private void makeTheNotAllowUserBoolFalse(){

        this.putSnakeOnAnimationAndHandleFood.notAllowUserPressMultipleKeysAtATime=false;
    }

    private boolean checkIFUserPressedSpace(KeyEvent keyEvent){
        if (keyEvent.getCode()== KeyCode.SPACE) {
            if (!this.putSnakeOnAnimationAndHandleFood.animationHandleCollisionDetection.gameRestartOperations.boolToRestartTheGame) {
                this.putSnakeOnAnimationAndHandleFood.animationHandleCollisionDetection.gameRestartOperations.boolToRestartTheGame = true;
                this.putSnakeOnAnimationAndHandleFood.animationHandleCollisionDetection.gameRestartOperations.main();
            }
            return false;
        }
        return true;
    }
    private void moveSnakeAndMakeMainTextInvisible(){
        if (!this.snakeFxmlController.startingPage.isVisible() && this.putSnakeOnAnimationAndHandleFood.stopAnimation){
            this.putSnakeOnAnimationAndHandleFood.startAnimation = true;
            this.snakeFxmlController.mainPageText.setVisible(false);
            this.makeTheNotAllowUserBoolFalse();
        }
    }
    private void modifyValuesToMoveTheSnake(int xDirection,int yDirection){
        this.putSnakeOnAnimationAndHandleFood.xDirection=xDirection;
        this.putSnakeOnAnimationAndHandleFood.yDirection=yDirection;
    }
    private boolean checkingIfKeyPressedIsEnter(KeyEvent keyEvent,boolean bool){
        if (bool) {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                if (this.snakeFxmlController.startingPage.isVisible()) {
                    this.snakeFxmlController.startingPage.setVisible(false);
                    this.putSnakeOnAnimationAndHandleFood.stopAnimation = true;
                    mainPageTextSettings();
                }
                return false;
            }
            return true;
        }
        return bool;
    }
    private void mainPageTextSettings(){
        this.snakeFxmlController.mainPageText.setVisible(true);
        this.snakeFxmlController.mainPageText.setText("To start press one ← ↓ ↑ →");
    }
}