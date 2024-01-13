package com.Homail.Practice.ConsolePractice;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        passColor(Color.RED);
    }
    private static void passColor(Color color){
        Circle circle=new Circle();
        circle.setFill(color);
    }
}
