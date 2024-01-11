package com.Homail.GuiProjects.ConnectFour;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;
public class ConnectFourController implements Initializable {
    @FXML
    protected GridPane gridPane;
    private Circle[][] CIRCLE_ARR=new Circle[6][6];
    public void initialize(URL url, ResourceBundle resourceBundle){
        int row;
        int column;
        for (Node circle : this.gridPane.getChildren()){
            try {
                row = GridPane.getRowIndex(circle);
            } catch (NullPointerException nullPointerException){
                row=0;
            }
            try {
                column = GridPane.getColumnIndex(circle);
            } catch (NullPointerException nullPointerException){
                column=0;
            }
            this.CIRCLE_ARR[row][column]=(Circle)circle;
        }
    }
}
