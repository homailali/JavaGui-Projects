package com.Homail.GuiProjects.SnakeGame.EasyVersion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
public class SnakeFxmlController implements Initializable {
    @FXML
    protected Text currentScore;
    @FXML
    protected Text highestScore;
    @FXML
    protected AnchorPane mainBoard;
    @FXML
    protected AnchorPane startingPage;
    @FXML
    protected Rectangle snakeHead;
    @FXML
    protected Rectangle food;
    @FXML
    protected Text startPageText;
    @FXML
    protected Circle eye1;
    @FXML
    protected Circle eye2;
    @FXML
    protected HBox hboxForEyes;
    @FXML
    protected Text mainPageText;
    @FXML
    protected Pane theContainer;
    @FXML
    protected Circle circleToCheckIfSnakeCollidesItself;
    public void initialize(URL url,ResourceBundle resourceBundle){
        this.thingsToPutAtFront();
    }
    private void thingsToPutAtFront(){
        this.theContainer.toFront();
    }
}