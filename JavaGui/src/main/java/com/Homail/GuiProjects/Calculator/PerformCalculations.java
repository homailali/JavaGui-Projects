package com.Homail.GuiProjects.Calculator;
public class PerformCalculations {
    protected void main() {
        String screenText = CalculatorNodes.SCREEN.getText();
        boolean bool;
        bool = checkTheNumberOfSymbols(screenText);
        if (bool) calculationsForOneSymbol(screenText);
        else calculationsForMultipleSymbols(screenText);
    }
    // Calculations for Multiple symbols
    private void calculationsForMultipleSymbols(String screenText12){
          double ans=separatingNumberAndSymbols2(screenText12);
          CalculatorNodes.SCREEN.setText(String.valueOf(ans));
    }
    private double separatingNumberAndSymbols2(String screenText){
        StringBuilder screenTextStr=new StringBuilder(screenText);
        StringBuilder num1Str=new StringBuilder();
        StringBuilder num2Str=new StringBuilder();
        double num1;
        double num2;
        double answer;
        char symbol;
        checkingIfFirstNumberIsNegative(screenTextStr,num1Str);
        findingNum1(screenTextStr,num1Str);
        num1=Double.parseDouble(String.valueOf(num1Str));
        answer=num1;
        while (!screenTextStr.isEmpty()){
            symbol=findSymbol(screenTextStr);
            findingNum2(screenTextStr,num2Str);
            num2=Double.parseDouble(String.valueOf(num2Str));
            answer=performingCalculations(answer,num2,symbol);
        }
        return answer;
    }
    private char findSymbol(StringBuilder screenText){
        char symbol=screenText.charAt(0);
        screenText.deleteCharAt(0);
        return symbol;
    }
    private void findingNum2(StringBuilder screenText,StringBuilder num2Str){
        for (int i=0;i<num2Str.length();i++){
            num2Str.deleteCharAt(i);
        }
        for (int i=0;i<screenText.length();i++){
            if (screenText.charAt(i)<48 && screenText.charAt(i)!=46){
                break;
            } else {
                num2Str.append(screenText.charAt(i));
                screenText.deleteCharAt(i);
                i=-1;
            }
        }
    }
    private void findingNum1(StringBuilder screenText,StringBuilder num1Str){
        for (int i=0;i<screenText.length();i++){
            if (screenText.charAt(i)<48 && screenText.charAt(i)!=46){
                break;
            } else {
                num1Str.append(screenText.charAt(i));
                screenText.deleteCharAt(i);
                i=-1;
            }
        }
    }
    private void checkingIfFirstNumberIsNegative(StringBuilder screenTextStr,StringBuilder num1Str){
        if (screenTextStr.charAt(0)<48) {
            num1Str.append(screenTextStr.charAt(0));
            screenTextStr.deleteCharAt(0);
        }
    }
    // Calculation For One Symbol
    private void calculationsForOneSymbol(String screenText){
        try {
            double ans = separatingTheNumbersAndSymbol1(screenText);
            CalculatorNodes.SCREEN.setText(String.valueOf(ans));
        } catch (NumberFormatException exception){}
    }
    private double separatingTheNumbersAndSymbol1(String screenText) throws NumberFormatException{
        StringBuilder stringBuilder=new StringBuilder(screenText);
        double num1=0;
        double num2=0;
        String stringNum1="";
        String stringNum2="";
        char symbol=' ';
        int countForNum1Store=0;
        if (stringBuilder.charAt(0)<48){
            stringNum1+=stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            screenText=String.valueOf(stringBuilder);
        }
        for (int i=0;i<screenText.length();i++){
            if (screenText.charAt(i)<48 && screenText.charAt(i)!=46) {
                symbol = screenText.charAt(i);
                countForNum1Store++;
            } else if (countForNum1Store==0) stringNum1+=screenText.charAt(i);
            else stringNum2+=screenText.charAt(i);
        }
        try {
            num1 = Double.parseDouble(stringNum1);
            num2 = Double.parseDouble(stringNum2);
        } catch (NumberFormatException exception){
            System.out.println("Number format exception");
            CalculatorNodes.SCREEN.setText("");
            CalculatorNodes.SCREEN.setPromptText("Wrong Expression");
            throw new NumberFormatException();
        }
        double answer=performingCalculations(num1,num2,symbol);
        return answer;
    }
    // No Of Symbols
    private boolean checkTheNumberOfSymbols(String screenText){
        StringBuilder stringBuilder=new StringBuilder(screenText);
        if (stringBuilder.charAt(0)<48) stringBuilder.deleteCharAt(0);
        int count=0;
        for (int i=0;i<stringBuilder.length();i++){
            if (stringBuilder.charAt(i)<48 && stringBuilder.charAt(i)!=46) count++;
        }
        return count==1;
    }
    // Common
    private double performingCalculations(double num1,double num2,char symbol){
        switch (symbol){
            case '+'->{
                return num1+num2;
            }
            case '-'->{
                return num1-num2;
            }
            case '%'->{
                return num1%num2;
            }
            case '*'->{
                return num1*num2;
            }
            case '/'->{
                return num1/num2;
            }
        }
        return 0;
    }
}