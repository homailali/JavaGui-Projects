package com.Homail.GuiProjects.RockPaperScissors;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class RPSFxmlController implements Initializable {
    // FXML
    @FXML
    protected TextField mainScreen;
    @FXML
    private Button restart;
    @FXML
    protected ImageView rock;
    @FXML
    protected ImageView paper;
    @FXML
    protected ImageView scissor;
    @FXML
    protected Text wonOrLost;
    @FXML
    protected Text matchEndedText;
    @FXML
    protected Text displayUserGuess;
    @FXML
    protected Text displayCompGuess;
    @FXML
    protected Text textWiningOrLosing;
    // Other
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.mainScreen.setEditable(false);
        onActionSetting();
        settingVisibleAndMainScreenAndOtherText();
    }
    private void settingVisibleAndMainScreenAndOtherText(){
        this.displayUserGuess.setText("");
        this.displayCompGuess.setText("");
        this.matchEndedText.setVisible(false);
        this.displayUserGuess.setVisible(false);
        this.displayCompGuess.setVisible(false);
        this.mainScreen.setText("0:0");
        this.wonOrLost.setText("Waiting!");
        this.textWiningOrLosing.setText("Match ends at 10 wins");
    }
    private void onActionSetting(){
        RPSEventHandler rpsEventHandler=new RPSEventHandler(this);
        RestartEventHandler restartEventHandler=new RestartEventHandler(this);
        this.rock.setOnMouseClicked(rpsEventHandler);
        this.scissor.setOnMouseClicked(rpsEventHandler);
        this.paper.setOnMouseClicked(rpsEventHandler);
        this.restart.setOnMouseClicked(restartEventHandler);
    }
}