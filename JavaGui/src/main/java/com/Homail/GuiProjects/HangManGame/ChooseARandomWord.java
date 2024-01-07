package com.Homail.GuiProjects.HangManGame;
import java.util.Random;
public class ChooseARandomWord {
    private String[] fruits={"Apple","Orange","mango","banana"};
    private String[] animals={"Lion","Tiger","Zebra","Dog"};
    protected String selectAWord(){
        Random random=new Random();
        int fruitOrAnimal= random.nextInt(2);
        int withinFruitOrAnimal=random.nextInt(4);
        if (fruitOrAnimal==0) return fruits[withinFruitOrAnimal];
        else return animals[withinFruitOrAnimal];
    }
}
