package com.Homail.GuiProjects.ToDoApp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ToDoFxmlControl {
    // FXML
    @FXML
    private Button addButton;
    @FXML
    private TextField mainTextField;
    @FXML
    protected ListView<HBox> list;
    @FXML
    public Text totalText;
    @FXML
    public Text doneText;
    @FXML
    protected Text listViewText;
    @FXML
    private void addButtonEventHandler(){


        this.mainTextField.setPromptText("Add Your Task");
        if (!this.mainTextField.getText().isEmpty()){
            HBox hBox=hBoxSettings();
            this.list.getItems().add(hBox);
            this.mainTextField.clear();
            listViewText.setVisible(false);
        } else this.mainTextField.setPromptText("Enter something!");
        totalText.setText("Total:"+hBoxesArr.size());
    }


    // Others
    ArrayList<Text> textArr=new ArrayList<>();
    ArrayList<HBox> hBoxesArr=new ArrayList<>();
    ArrayList<RadioButton> radioButtonArr=new ArrayList<>();
    ArrayList<Button> buttonsArr=new ArrayList<>();
    ToDoAppEventHandler toDoAppEventHandler=new ToDoAppEventHandler(this,buttonsArr,radioButtonArr,textArr,hBoxesArr);

    private HBox hBoxSettings(){
        HBox hBox=new HBox(10);
        RadioButton radioButton=new RadioButton();
        Text text=new Text(this.mainTextField.getText());
        Button button=new Button("X");

        text.setTranslateY(2);
        text.setFill(Color.WHITE);
        text.setFont(Font.font(20));

        hBox.getChildren().add(radioButton);
        hBox.getChildren().add(text);
        hBox.getChildren().add(button);

        button.getStylesheets().add(getClass().getResource("/com/Homail/GuiProjects/ToDoApp/Style.css").toExternalForm());
        button.setOnAction(this.toDoAppEventHandler);
        button.setId("crossButton");


        radioButton.setId("todoRadioButton");
        radioButton.setOnAction(this.toDoAppEventHandler);

        hBoxesArr.add(hBox);
        buttonsArr.add(button);
        textArr.add(text);
        radioButtonArr.add(radioButton);

        return hBox;
    }
}