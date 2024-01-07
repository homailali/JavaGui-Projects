package com.Homail.GuiProjects.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
public class TicTacToeHandleEvents implements EventHandler<ActionEvent>{
    static int count=0;
    boolean bool=true;
    static int winnerCount=0;
    // Main
    public void handle(ActionEvent actionEvent){
        Button button = findButtonPressed(actionEvent);
        if (button== TicTacToeNodes.RESTART && !bool){
            restartButtonSettings();
            return;
        }
        if (bool && button != TicTacToeNodes.RESTART){
            if (count % 2 == 0) fillBoard(button, "X");
            else fillBoard(button, "O");
            bool = checkForWinner("X", bool);
            bool = checkForWinner("O", bool);
            bool = checkForDraw();
            if (!bool) displayWinner();
        }
    }
    // Others
    void screenStyle(){
        TicTacToeNodes.RESTART.setStyle(
                "-fx-background-color:seagreen;"+
                "-fx-text-fill: white;"+
                "-fx-background-radius:100;"
        );
    }
    void displayWinner(){
        switch (winnerCount){
            case 0-> TicTacToeNodes.screen.setText("Player O wins!");
            case 1-> TicTacToeNodes.screen.setText("Player X wins!");
            case 2-> {
                screenStyle();
                TicTacToeNodes.screen.setText("Draw!");
            }
        }
    }
    boolean checkForDraw(){
        if (bool) {
            if (
                TicTacToeNodes.BUTTON_1.getText().isEmpty() || TicTacToeNodes.BUTTON_2.getText().isEmpty() ||
                TicTacToeNodes.BUTTON_3.getText().isEmpty() || TicTacToeNodes.BUTTON_4.getText().isEmpty() ||
                TicTacToeNodes.BUTTON_5.getText().isEmpty() || TicTacToeNodes.BUTTON_6.getText().isEmpty() ||
                TicTacToeNodes.BUTTON_7.getText().isEmpty() || TicTacToeNodes.BUTTON_8.getText().isEmpty() ||
                TicTacToeNodes.BUTTON_9.getText().isEmpty()
            ) {
                return true;
            }
            winnerCount = 2;
            return false;
        }
        return bool;
    }
    void restartButtonSettings(){
        class ResetButtons{
            void passButtons(Button button){
                button.setText("");
                button.setStyle(
                        "-fx-background-color: darkslategray;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 2;"
                );
                TicTacToeNodes.RESTART.setStyle(
                        "-fx-background-color:darkslategray;"+
                        "-fx-text-fill: white;"+
                        "-fx-background-radius:100;"
                );
            }

        }
        ResetButtons resetButtons=new ResetButtons();
        count=0;
        bool=true;
        winnerCount=0;
        resetButtons.passButtons(TicTacToeNodes.BUTTON_1);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_2);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_3);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_4);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_5);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_6);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_7);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_8);
        resetButtons.passButtons(TicTacToeNodes.BUTTON_9);
        TicTacToeNodes.screen.setText("Start X");
    }
    void changingColors(Button button){
        button.setStyle(
                "-fx-background-color:seagreen;"+
                        "-fx-text-fill: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 2;"
        );
        screenStyle();
    }
    void fillBoard(Button button,String player){
        if (button.getText().isEmpty()){
            button.setText(player);
            TicTacToeNodes.screen.setText("Go on "+(player.equals("X")?"O":"X"));
            count++;
        } else TicTacToeNodes.screen.setText("Space Occupied!");
    }
    Button findButtonPressed(ActionEvent actionEvent){
        if (actionEvent.getSource()== TicTacToeNodes.BUTTON_1) return TicTacToeNodes.BUTTON_1;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_2) return TicTacToeNodes.BUTTON_2;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_3) return TicTacToeNodes.BUTTON_3;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_4) return TicTacToeNodes.BUTTON_4;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_5) return TicTacToeNodes.BUTTON_5;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_6) return TicTacToeNodes.BUTTON_6;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_7) return TicTacToeNodes.BUTTON_7;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_8) return TicTacToeNodes.BUTTON_8;
        else if (actionEvent.getSource()== TicTacToeNodes.BUTTON_9) return TicTacToeNodes.BUTTON_9;
        else if (actionEvent.getSource()== TicTacToeNodes.RESTART) return TicTacToeNodes.RESTART;
        return new Button();
    }
    boolean checkForWinner(String player,boolean bool){
        if (bool) {
            if (TicTacToeNodes.BUTTON_1.getText().equals(player) && TicTacToeNodes.BUTTON_2.getText().equals(player) && TicTacToeNodes.BUTTON_3.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_1, TicTacToeNodes.BUTTON_2, TicTacToeNodes.BUTTON_3);
                return false;
            }
            else if (TicTacToeNodes.BUTTON_4.getText().equals(player) && TicTacToeNodes.BUTTON_5.getText().equals(player) && TicTacToeNodes.BUTTON_6.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_4, TicTacToeNodes.BUTTON_5, TicTacToeNodes.BUTTON_6);
                return false;
            }
            else if (TicTacToeNodes.BUTTON_7.getText().equals(player) && TicTacToeNodes.BUTTON_8.getText().equals(player) && TicTacToeNodes.BUTTON_9.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_7, TicTacToeNodes.BUTTON_8, TicTacToeNodes.BUTTON_9);
                return false;
            }

            else if (TicTacToeNodes.BUTTON_1.getText().equals(player) && TicTacToeNodes.BUTTON_4.getText().equals(player) && TicTacToeNodes.BUTTON_7.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_1, TicTacToeNodes.BUTTON_4, TicTacToeNodes.BUTTON_7);
                return false;
            }
            else if (TicTacToeNodes.BUTTON_2.getText().equals(player) && TicTacToeNodes.BUTTON_5.getText().equals(player) && TicTacToeNodes.BUTTON_8.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_2, TicTacToeNodes.BUTTON_5, TicTacToeNodes.BUTTON_8);
                return false;
            }
            else if (TicTacToeNodes.BUTTON_3.getText().equals(player) && TicTacToeNodes.BUTTON_9.getText().equals(player) && TicTacToeNodes.BUTTON_6.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_3, TicTacToeNodes.BUTTON_9, TicTacToeNodes.BUTTON_6);
                return false;
            }

            else if (TicTacToeNodes.BUTTON_9.getText().equals(player) && TicTacToeNodes.BUTTON_5.getText().equals(player) && TicTacToeNodes.BUTTON_1.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_9, TicTacToeNodes.BUTTON_5, TicTacToeNodes.BUTTON_1);
                return false;
            }
            else if (TicTacToeNodes.BUTTON_7.getText().equals(player) && TicTacToeNodes.BUTTON_5.getText().equals(player) && TicTacToeNodes.BUTTON_3.getText().equals(player)) {
                changeWinnersColor(TicTacToeNodes.BUTTON_7, TicTacToeNodes.BUTTON_5, TicTacToeNodes.BUTTON_3);
                return false;
            }

            else return true;
        }
        winnerCount=1;
        return bool;
    }
    void changeWinnersColor(Button button1,Button button2,Button button3){
        changingColors(button1);
        changingColors(button2);
        changingColors(button3);
    }
}