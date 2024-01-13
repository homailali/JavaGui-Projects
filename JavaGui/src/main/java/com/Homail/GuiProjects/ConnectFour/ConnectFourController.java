package com.Homail.GuiProjects.ConnectFour;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
    // Normal Fields
    private ConnectFourBallsThrower connectFourBallsThrower;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.eventSettings();

    }
    private void eventSettings(){
        this.placeToThrowBalls.setOnMousePressed(e->this.connectFourBallsThrower.pressHandler(e));
        this.placeToThrowBalls.setOnMouseDragged(e->this.connectFourBallsThrower.dragHandler(e));
        this.placeToThrowBalls.setOnMouseReleased(e->this.connectFourBallsThrower.releaseHandler(e));
    }
    protected void passConnectFourLogicInstance(ConnectFourBallsThrower connectFourBallsThrower){
        this.connectFourBallsThrower = connectFourBallsThrower;
    }
}