package com.Homail.GuiProjects.RockPaperScissors;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
public class RPSEventHandler implements EventHandler<MouseEvent>{
    // Fields
    private int userWonCount;
    private int compWonCount;
    private String computerGuess;
    private String userGuess;
    private RPSFxmlController rpsFxmlController;
    private boolean boolToStopTheGame=true;
    // Constructor
    RPSEventHandler(RPSFxmlController rpsFxmlController){

        this.rpsFxmlController=rpsFxmlController;
    }
    // Methods
    public void handle(MouseEvent mouseEvent){
        if (boolToStopTheGame) {
            userGuess = getImageClickedByUser(mouseEvent);
            computerGuess = makingComputerTakeAGuess();
            displayingTheWinner();
            settingTextForUserAndComp();
            settingTextOfMainScreen();
            settingWinnerOrLoserText();
            checkIfDrawOneOfThePlayerHasWon();
        }
    }
    private int checkTheWinner(){
        if (userGuess.equals("rock") && computerGuess.equals("scissor")) return 0;
        if (userGuess.equals("scissor") && computerGuess.equals("paper")) return 0;
        if (userGuess.equals("paper") && computerGuess.equals("rock")) return 0;
        if (userGuess.equals(computerGuess)) return 2;
        return 1;
    }
    private void displayingTheWinner(){
        int winner=checkTheWinner();
        switch (winner){
            case 0 -> {
                this.rpsFxmlController.wonOrLost.setText("User Won");

                this.userWonCount++;
            }
            case 1 -> {
                rpsFxmlController.wonOrLost.setText("Comp Won");
                this.compWonCount++;
            }
            case 2 -> rpsFxmlController.wonOrLost.setText("Match draw");
        }
    }
    private void settingTextOfMainScreen(){

        rpsFxmlController.mainScreen.setText(this.userWonCount+":"+this.compWonCount);
    }
    private void settingWinnerOrLoserText(){
        if (this.userWonCount>this.compWonCount) rpsFxmlController.textWiningOrLosing.setText("User is Winning");
        else if (this.userWonCount<this.compWonCount) rpsFxmlController.textWiningOrLosing.setText("Comp is Winning");
        else rpsFxmlController.textWiningOrLosing.setText("Both have same wins");
    }
    private void settingTextForUserAndComp(){
        this.rpsFxmlController.displayUserGuess.setVisible(true);
        this.rpsFxmlController.displayCompGuess.setVisible(true);
        this.rpsFxmlController.displayUserGuess.setText(this.userGuess);
        this.rpsFxmlController.displayCompGuess.setText(this.computerGuess);
    }
    private String makingComputerTakeAGuess(){
        String[] rPS={"rock","paper","scissor"};
        Random random=new Random();
        int computerChoice=random.nextInt(3);
        return rPS[computerChoice];
    }
    private void checkIfDrawOneOfThePlayerHasWon(){
        if (userWonCount==10 && compWonCount==10){
            this.rpsFxmlController.textWiningOrLosing.setText("Match has drawn!");
            this.boolToStopTheGame=false;
        } else if (userWonCount==10){
            this.rpsFxmlController.textWiningOrLosing.setText("Congratulations user you won!");
            this.boolToStopTheGame=false;
        } else if (compWonCount==10) {
            this.rpsFxmlController.textWiningOrLosing.setText("Congratulation Comp you won!");
            this.boolToStopTheGame=false;
        }
        if (!this.boolToStopTheGame) this.rpsFxmlController.matchEndedText.setVisible(true);
    }
    private String getImageClickedByUser(MouseEvent mouseEvent){
        if (mouseEvent.getSource()==this.rpsFxmlController.rock) return "rock";
        if (mouseEvent.getSource()==this.rpsFxmlController.paper) return "paper";
        if (mouseEvent.getSource()==this.rpsFxmlController.scissor) return "scissor";
        throw new NullPointerException();
    }
}