package com.Homail.Practice.ConsolePractice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<StringBuilder> arrayList=new ArrayList<>();
        for(int i=0;i<Integer.MAX_VALUE;i++){
            arrayList.add(new StringBuilder("Homail"));
        }
        System.out.println(arrayList);
    }
}
