package com.Homail.GuiProjects.ToDoApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ToDoAppEventHandler implements EventHandler<ActionEvent>{
    // Fields
    private final ToDoFxmlControl toDoFxmlControl;
    private final ArrayList<Button> BUTTON_CAL;
    private final ArrayList<RadioButton> RadioButton_CAL;
    private final ArrayList<HBox> HBOXES_CAL;
    private final ArrayList<Text> TEXT_CAL;
    // Constructor
    public ToDoAppEventHandler(ToDoFxmlControl toDoFxmlControl, ArrayList<Button> BUTTON_CAL, ArrayList<RadioButton> RadioButton_CAL,ArrayList<Text> TEXT_CAL,ArrayList<HBox> HBOXES_CAL){
        this.toDoFxmlControl=toDoFxmlControl;
        this.BUTTON_CAL=BUTTON_CAL;
        this.RadioButton_CAL= RadioButton_CAL;
        this.TEXT_CAL=TEXT_CAL;
        this.HBOXES_CAL=HBOXES_CAL;
    }
    // Main
    public void handle(ActionEvent actionEvent) {
        int indexToRemove=gettingButtonClicked(actionEvent);
        int indexToUnderLineText=gettingRadioButtonClicked(actionEvent);
        if (indexToRemove!=-1) this.toDoFxmlControl.list.getItems().remove(indexToRemove);
        else {
            if (this.RadioButton_CAL.get(indexToUnderLineText).isSelected())this.TEXT_CAL.get(indexToUnderLineText).setStrikethrough(true);
            else this.TEXT_CAL.get(indexToUnderLineText).setStrikethrough(false);
        }
        listViewTextSettings();
        checkingTotalAndDone();
    }
    // Other
    private void listViewTextSettings(){
        if (this.HBOXES_CAL.isEmpty()) toDoFxmlControl.listViewText.setVisible(true);
    }
    private void checkingTotalAndDone(){
        int localCount=0;
        for (int i=0;i<RadioButton_CAL.size();i++){
            if (this.RadioButton_CAL.get(i).isSelected()) localCount++;
        }
        toDoFxmlControl.doneText.setText("Done:"+localCount);
        toDoFxmlControl.totalText.setText("Total:"+this.BUTTON_CAL.size());
    }
    private int gettingRadioButtonClicked(ActionEvent actionEvent){
        for (int i=0;i<this.HBOXES_CAL.size();i++){
            if (actionEvent.getSource()==RadioButton_CAL.get(i)) return i;
        }
        return -1;
    }
    private int gettingButtonClicked(ActionEvent actionEvent){
        for (int i=0;i<this.BUTTON_CAL.size();i++){
            if (actionEvent.getSource()==this.BUTTON_CAL.get(i)) {
                this.BUTTON_CAL.remove(i);
                this.RadioButton_CAL.remove(i);
                this.TEXT_CAL.remove(i);
                this.HBOXES_CAL.remove(i);
                return i;
            }
        }
        return -1;
    }
}