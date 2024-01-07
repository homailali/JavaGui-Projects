package com.Homail.GuiProjects.StopWatch;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StopWatchLogic {
    // Fields
    private int hoursCount;
    private int minutesCount;
    private int secondsCount;
    private boolean boolForAnimationController;
    private StopWatchMain stopWatchMain;
    private StopWatchController stopWatchController;
    // Constructor
    protected StopWatchLogic(StopWatchMain stopWatchMain,StopWatchController stopWatchController){
        this.stopWatchMain=stopWatchMain;
        this.stopWatchController=stopWatchController;
        this.makeAnimation();
    }
    // Methods
    protected void alwaysOnTopController(){
        if (this.stopWatchMain.stage.isAlwaysOnTop()){
            this.stopWatchMain.stage.setAlwaysOnTop(false);
            this.stopWatchController.alwaysOnTopButton.setText("Always on top:Off");
        } else {
            this.stopWatchMain.stage.setAlwaysOnTop(true);
            this.stopWatchController.alwaysOnTopButton.setText("Always on top:On");
        }
    }
    protected void startAndPauseButtonController(){
         if (this.stopWatchController.startAndPauseButtons.getText().equalsIgnoreCase("Start") && !this.boolForAnimationController){
             this.boolForAnimationController=true;
             this.stopWatchController.startAndPauseButtons.setText("Pause");
         } else if (this.boolForAnimationController) {
             boolForAnimationController=false;
             this.stopWatchController.startAndPauseButtons.setText("Start");
         }
    }
    protected void resetButtonController(){
         this.secondsCount=0;
         this.minutesCount=0;
         this.hoursCount=0;
         this.stopWatchController.limitReachedText.setVisible(false);
         this.stopWatchController.secondsText.setText("0"+this.secondsCount);
         this.stopWatchController.minutesText.setText("0"+this.minutesCount);
         this.stopWatchController.hoursText.setText("0"+this.hoursCount);
         this.stopWatchController.startAndPauseButtons.setText("Start");
         this.boolForAnimationController=false;
    }
    private void makeAnimation(){
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(1),e->this.handleAnimation());
        Timeline timeline=new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    private void handleAnimation(){
       if (this.boolForAnimationController){
           this.secondsCount++;
           this.setTimeOnScreen();
           this.checkIfSecondsAre60();
       }
       this.setCurrentDateAndTime();
    }
    private void setTimeOnScreen(){
        if (this.secondsCount<10){
            this.stopWatchController.secondsText.setText("0"+this.secondsCount);
        } else this.stopWatchController.secondsText.setText(String.valueOf(this.secondsCount));
        if (this.minutesCount<10){
            this.stopWatchController.minutesText.setText("0"+this.minutesCount);
        } else this.stopWatchController.minutesText.setText(String.valueOf(this.minutesCount));
        if (this.hoursCount<10){
            this.stopWatchController.hoursText.setText("0"+this.hoursCount);
        } else this.stopWatchController.hoursText.setText(String.valueOf(this.hoursCount));
    }
    private void checkIfSecondsAre60(){
        if (this.secondsCount==59){
            this.secondsCount=-1;
            this.checkIfMinutesAre60();
            this.minutesCount++;
        }
    }
    private void checkIfMinutesAre60(){
        if(this.minutesCount==59){
            this.minutesCount=-1;
            this.checkIfHoursAre99();
            this.hoursCount++;
        }
    }
    private void checkIfHoursAre99(){
        if (this.hoursCount>=99){
             this.hoursCount=-1;
             this.stopWatchController.limitReachedText.setVisible(true);
             this.boolForAnimationController=false;
        }
    }
    protected void setCurrentDateAndTime(){
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter dateTimeFormatterDate=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatterTime=DateTimeFormatter.ofPattern("hh:mm:ss a");
        String date=localDateTime.format(dateTimeFormatterDate);
        String time=localDateTime.format(dateTimeFormatterTime);
        this.stopWatchController.dayMonthYear.setText(date);
        this.stopWatchController.currentTime.setText(time);
    }
}