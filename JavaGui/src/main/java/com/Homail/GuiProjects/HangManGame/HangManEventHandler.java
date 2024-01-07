package com.Homail.GuiProjects.HangManGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class HangManEventHandler implements EventHandler<ActionEvent>{
    protected boolean callGSIOnlyOnce=true;
    protected boolean toCheckIfUserHasGuessed=true;
    protected int rightMoves=0;
    protected int wrongMoves=0;
    // Fields
    StringBuilder globalStringBuilder=new StringBuilder();
    HangManFxmlController hangManFxmlController;
    HangManMain hangManMain;
    // Constructor
    HangManEventHandler(HangManFxmlController hangManFxmlController){
        this.hangManFxmlController=hangManFxmlController;

    }
    // Methods
    // Main
    public void handle(ActionEvent actionEvent){
        if (this.toCheckIfUserHasGuessed) {
            globalStringBuilderInitialization(hangManFxmlController.wordGuessedByComputer);
            if (hangManFxmlController.textField.getText().isEmpty())
                hangManFxmlController.textField.setPromptText("Enter something!");
            else {
                hangManFxmlController.textField.setPromptText("Enter a word or a char");
                checkingIfRightGuess();
            }
        }
    }
    private void globalStringBuilderInitialization(String word){
        if (callGSIOnlyOnce) {
            for (int i = 0; i < word.length(); i++) {
                this.globalStringBuilder.append("_");
            }
            callGSIOnlyOnce=false;
        }
    }
    // Call methods based on situation
    private void checkingIfRightGuess(){
        String textFieldText=hangManFxmlController.textField.getText();
        if (hangManFxmlController.wordGuessedByComputer.toLowerCase().contains(textFieldText.toLowerCase()) && !String.valueOf(this.globalStringBuilder).toLowerCase().contains(textFieldText.toLowerCase())) {
            operationsToPerformIfGuessIsCorrect(hangManFxmlController.wordGuessedByComputer,textFieldText);
            actionOnRightMove();
            toCheckIfGameHasEnded();
        }
        else {
            operationToPerFormIfGuessIsNotRight();
            actionOnWrongMove();
        }

        hangManFxmlController.settingTotalRightAndWrongMovesText(this);
    }
    private void operationToPerFormIfGuessIsNotRight(){
        hangManFxmlController.textField.clear();
        hangManFxmlController.rightOrWrongMove.setText("Wrong Move");
    }
    // Game end logic
    private void actionOnRightMove(){
        hangManFxmlController.textField.clear();
        hangManFxmlController.rightOrWrongMove.setText("Right Move");
        rightMoves++;
    }
    private void actionOnWrongMove(){
        if (wrongMoves==1) hangManFxmlController.man2.setVisible(true);
        else hangManFxmlController.manLines.get(wrongMoves).setVisible(true);
        wrongMoves++;
        if (wrongMoves==7) {
            this.toCheckIfUserHasGuessed=false;
            hangManFxmlController.rightOrWrongMove.setText("You Lost!");
            hangManFxmlController.textField.setPromptText("You Lost!");
        }
    }
    private void toCheckIfGameHasEnded(){
        if (this.toCheckIfUserHasGuessed) {
            this.toCheckIfUserHasGuessed = checkIfAllGuessed(this.toCheckIfUserHasGuessed);
            if (!this.toCheckIfUserHasGuessed) {
                hangManFxmlController.rightOrWrongMove.setText("You Won!");
                hangManFxmlController.textField.setPromptText("You Won!");
            }
        }
    }
    private boolean checkIfAllGuessed(boolean bool){
        if (bool) {
            for (int i = 0; i < this.globalStringBuilder.length(); i++) {
                if (globalStringBuilder.charAt(i) == '_') return true;
            }
            return false;
        }
        return bool;
    }
    // Fill after user guess
    private void displayGSB(){
        StringBuilder gSBDuplicateToShow=new StringBuilder();
        for (int i=0;i<this.globalStringBuilder.length();i++){
            gSBDuplicateToShow.append(this.globalStringBuilder.charAt(i)+" ");
        }
        hangManFxmlController.userWord.setText("Your word: "+gSBDuplicateToShow);
    }
    private void operationForManyCharacters(String computerGuess,String textField){
        for (int i=0;i<textField.length();i++){
            for (int j=0;j<computerGuess.length();j++){
                if (computerGuess.toLowerCase().charAt(j)==textField.toLowerCase().charAt(i)) this.globalStringBuilder.setCharAt(j,textField.charAt(i));
            }
        }
        displayGSB();
    }
    private void operationForOneChar(String computerGuess,String textField){
        for (int i=0;i<computerGuess.length();i++){
            if (computerGuess.toLowerCase().charAt(i)==textField.toLowerCase().charAt(0)){
                globalStringBuilder.setCharAt(i,textField.charAt(0));
            }
        }
         displayGSB();
    }
    private void operationsToPerformIfGuessIsCorrect(String computerGuess,String textFieldText){
        if (textFieldText.length()==1) operationForOneChar(computerGuess,textFieldText);
        else operationForManyCharacters(computerGuess,textFieldText);
    }
}