package com.Homail.GuiProjects.StopWatch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
public class StopWatchController implements Initializable {
    @FXML
    protected Text hoursText;
    @FXML
    protected Text minutesText;
    @FXML
    protected Button resetButton;
    @FXML
    protected Text secondsText;
    @FXML
    protected Button startAndPauseButtons;
    @FXML
    protected AnchorPane stopWatchBG;
    @FXML
    protected Button alwaysOnTopButton;
    @FXML
    protected Text dayMonthYear;
    @FXML
    protected Text currentTime;
    @FXML
    protected Text limitReachedText;
    private StopWatchLogic stopWatchLogic;
    public void initialize(URL url, ResourceBundle resourceBundle){
         this.resetButton.setOnMouseClicked(e->this.stopWatchLogic.resetButtonController());
         this.startAndPauseButtons.setOnMouseClicked(e->this.stopWatchLogic.startAndPauseButtonController());
         this.alwaysOnTopButton.setOnMouseClicked(e->this.stopWatchLogic.alwaysOnTopController());


    }
    protected void getStopWatchLogic(StopWatchLogic stopWatchLogic){
        this.stopWatchLogic=stopWatchLogic;
        this.stopWatchLogic.setCurrentDateAndTime();
    }
}
