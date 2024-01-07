package com.Homail.GuiProjects.PxToRem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
public class PxToRemController implements Initializable {
    // Fxml fields
    @FXML
    private TextField pxTextField;
    @FXML
    private TextField remTextField;
    @FXML
    private Text mainText;
    @FXML
    private Button stayOnTopBtn;
    //Normal fields
    private String on="ON";
    private String off="OFF";
    private Double pxValue;
    private Double remValue;
    private PxToRemMain pxToRemMain;
    // Constructors
    public PxToRemController(){}
    // PIXEL
    @FXML
    void performCalculationPx(KeyEvent event) {
        boolean bool=checkIfInputCorrectPx();
        performCalForPx(bool);
    }
    private void performCalForPx(boolean bool){
        if (bool){
            mainText.setText("Enter Values");
            double answer=pxValue/16.0;
            remTextField.setText(String.valueOf(answer));
        }
    }
    private boolean checkIfInputCorrectPx(){
        try {
            if (pxTextField.getText().isBlank()) {
                mainText.setText("Enter Values");
                remTextField.clear();
                return false;
            } else {
                if (pxTextField.getText().toLowerCase().contains("d") || pxTextField.getText().toLowerCase().contains("f")) throw new NumberFormatException();
                pxValue = Double.parseDouble(String.valueOf(pxTextField.getText()));
                return true;
            }
        } catch (NumberFormatException exception){
            if (!pxTextField.getText().isBlank()) mainText.setText("Wrong values in PixelField");
            return false;
        }
    }
    // REM
    @FXML
    void performCalculationRem(KeyEvent event) {
        boolean bool=checkIfInputIsCorrectRem();
        performCalcForRem(bool);
    }
    private void performCalcForRem(boolean bool){
        if (bool){
            mainText.setText("Enter Values");
            double answer=remValue*16;
            pxTextField.setText(String.valueOf(answer));
        }
    }
    private boolean checkIfInputIsCorrectRem(){
        try{
            if (remTextField.getText().isBlank()) {
                mainText.setText("Enter Values");
                pxTextField.clear();
                return false;
            }
            else {
                if (remTextField.getText().toLowerCase().contains("d") || remTextField.getText().toLowerCase().contains("f")) throw new NumberFormatException();
                remValue = Double.parseDouble(String.valueOf(remTextField.getText()));
                return true;
            }
        } catch (NumberFormatException exception){
            if (!remTextField.getText().isBlank()) mainText.setText("Wrong value in RemField");
            return false;
        }
    }
    // initialize
    public void initialize(URL url, ResourceBundle resourceBundle){

         this.stayOnTopBtn.setOnMouseClicked(this::stayOnTopBtnHandler);
    }
    // Others
    public void stayOnTopBtnHandler(MouseEvent mouseEvent){
        if (this.pxToRemMain.stage.isAlwaysOnTop()){
            this.pxToRemMain.stage.setAlwaysOnTop(false);
            this.stayOnTopBtn.setText("Always stay on top:"+this.off);
        } else {
            this.pxToRemMain.stage.setAlwaysOnTop(true);
            this.stayOnTopBtn.setText("Always stay on top:"+this.on);
        }
    }
    public void getPxToRemMain(PxToRemMain pxToRemMain){

        this.pxToRemMain=pxToRemMain;
    }
}