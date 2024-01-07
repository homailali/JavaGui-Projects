package com.Homail.GuiProjects.HangManGame;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import java.util.ResourceBundle;
import javafx.scene.shape.Circle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class HangManFxmlController implements Initializable {
    static CloseButtonHandler closeButtonHandler;

    // FXML
    @FXML
    private Line man1;
    @FXML
    private Line man3;
    @FXML
    private Line man4;
    @FXML
    private Line man5;
    @FXML
    private Line man6;
    @FXML
    private Line man7;
    @FXML
    private Text title;
    @FXML
    protected Circle man2;
    @FXML
    protected Button close;
    @FXML
    protected Text userWord;
    @FXML
    protected Button restart;
    @FXML
    private Button guessButton;
    @FXML
    protected TextField textField;
    @FXML
    protected Text totalMovesText;
    @FXML
    protected Text rightMovesText;
    @FXML
    protected Text wrongMovesText;
    @FXML
    protected Text rightOrWrongMove;

    // Fields
    protected String wordGuessedByComputer;
    protected ArrayList<Line> manLines=new ArrayList<>();
    // Methods
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HangManEventHandler hangManEventHandler=new HangManEventHandler(this);
        // On Actions
        restart.setOnAction(new RestartButtonHandler(this));
        guessButton.setOnAction(hangManEventHandler);
        close.setOnAction(closeButtonHandler);

        ChooseARandomWord chooseARandomWord = new ChooseARandomWord();
        String word = chooseARandomWord.selectAWord();
        wordGuessedByComputer=word;

        addBracesToUserWord(word);
        fillLineArr();
        settingTotalRightAndWrongMovesText(hangManEventHandler);
    }
    private void fillLineArr(){
        manLines.add(man1);
        manLines.add(new Line());
        manLines.add(man3);
        manLines.add(man4);
        manLines.add(man5);
        manLines.add(man6);
        manLines.add(man7);
        for (Line line : manLines){
            line.setVisible(false);
        }
        man2.setVisible(false);
    }
    private void addBracesToUserWord(String word){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<word.length();i++){
            stringBuilder.append("_ ");
        }
        this.userWord.setText("Your word: "+stringBuilder);
    }
    protected void settingTotalRightAndWrongMovesText(HangManEventHandler hangManEventHandler){
        this.totalMovesText.setText("Total moves:"+(hangManEventHandler.rightMoves+hangManEventHandler.wrongMoves));
        this.rightMovesText.setText("Right moves:"+hangManEventHandler.rightMoves);
        this.wrongMovesText.setText("Wrong moves:"+hangManEventHandler.wrongMoves);
    }
}
