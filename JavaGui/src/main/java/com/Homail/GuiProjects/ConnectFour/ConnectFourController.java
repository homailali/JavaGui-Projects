package com.Homail.GuiProjects.ConnectFour;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
public class ConnectFourController implements Initializable {
    // Fxml Fields
    @FXML
    protected GridPane mainBoard;
    @FXML
    protected GridPane placeToThrowBalls;
    @FXML
    private AnchorPane sideScreen;
    @FXML
    protected AnchorPane playerTurnTextContainer;
    @FXML
    protected Circle playerTurnCircle;
    @FXML
    protected Text throwingInColText;
    @FXML
    protected Text turnString;
    @FXML
    protected Text directionText;
    @FXML
    protected Text playerString;
    @FXML
    protected Button restartButton;
    @FXML
    protected AnchorPane winsContainer;
    @FXML
    protected Text player1WinsText;
    @FXML
    protected Text player2WinsText;
    @FXML
    protected Text colFilledText;
    @FXML
    protected Text drawsText;
    @FXML
    protected Text startEndColText;
    // Normal Fields
    private ConnectFourBallsThrower connectFourBallsThrower;
    private Connect4RestartHandler connect4RestartHandler;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.eventSettings();

    }
    private void eventSettings(){
        this.placeToThrowBalls.setOnMousePressed(e->this.connectFourBallsThrower.pressHandler(e));
        this.placeToThrowBalls.setOnMouseDragged(e->this.connectFourBallsThrower.dragHandler(e));
        this.placeToThrowBalls.setOnMouseReleased(e->this.connectFourBallsThrower.releaseHandler(e));
    }
    protected void passInstancesOfSpecificClassesToController(ConnectFourBallsThrower connectFourBallsThrower,Connect4RestartHandler connect4RestartHandler){
        this.connect4RestartHandler=connect4RestartHandler;
        this.connectFourBallsThrower = connectFourBallsThrower;
    }
}