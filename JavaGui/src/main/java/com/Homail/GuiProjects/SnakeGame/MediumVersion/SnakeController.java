package com.Homail.GuiProjects.SnakeGame.MediumVersion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SnakeController implements Initializable {
    @FXML
    protected Rectangle food;
    @FXML
    protected AnchorPane mainBoard;
    @FXML
    protected Rectangle snakeHead;
    @FXML
    protected Line snakeHeadLine;
    @FXML
    protected Text scoreText;
    @FXML
    protected Text mainBoardText;

    public void initialize(URL url, ResourceBundle resourceBundle){
        this.mainBoardText.toFront();
        this.snakeHeadLine.toFront();
    }
}