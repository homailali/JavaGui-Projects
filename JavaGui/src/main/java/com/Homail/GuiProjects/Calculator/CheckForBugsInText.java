package com.Homail.GuiProjects.Calculator;

public class CheckForBugsInText {
    private final PerformCalculations PERFORM_CALCULATIONS=new PerformCalculations();
    protected void main(){
        boolean bool=true;
        String screenText = CalculatorNodes.SCREEN.getText();
        if (screenText.isEmpty()) bool=false;
        bool=checkForDuplicateOperator(bool,screenText);
        bool=checkIfExpressionIsCorrect(bool,screenText);
        if (bool) PERFORM_CALCULATIONS.main();
        else showErrorOnScreen();
    }
    private boolean checkIfExpressionIsCorrect(boolean bool,String screenText){
        if (bool) {
            StringBuilder stringBuilder=new StringBuilder(screenText);
            if (stringBuilder.charAt(0)=='/' || stringBuilder.charAt(0)=='%' || stringBuilder.charAt(0)=='*') return false;
            if (stringBuilder.charAt(0)<48) stringBuilder.deleteCharAt(0);
            int symbolCount = 0;
            int numberCount = 0;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) < 48 && stringBuilder.charAt(i)!=46){
                    symbolCount++;
                } else numberCount++;
            }
            return symbolCount>=1 && numberCount>=2;
        }
        return bool;
    }
    private boolean checkForDuplicateOperator(boolean bool1,String screenText){
        if (bool1) {
            boolean bool = true;
            char[] symbols = {'+', '-', 'x', '/', '%', '.'};

            bool = checkingForDuplicateOperator(screenText, symbols[0], bool);
            bool = checkingForDuplicateOperator(screenText, symbols[1], bool);
            bool = checkingForDuplicateOperator(screenText, symbols[2], bool);
            bool = checkingForDuplicateOperator(screenText, symbols[3], bool);
            bool = checkingForDuplicateOperator(screenText, symbols[4], bool);
            bool = checkingForDuplicateOperator(screenText, symbols[5], bool);
            return bool;
        }
        return bool1;
    }
    private boolean checkingForDuplicateOperator(String screenText,char symbol,boolean bool) {
        if (bool) {
            try {
                for (int i = 0; i < screenText.length(); i++) {
                    if (screenText.charAt(i) == symbol && (screenText.charAt(i + 1) < 48))
                        return false;
                }
            } catch (IndexOutOfBoundsException exception) {
                return false;
            }
            return true;
        }
        return bool;
    }
    private void showErrorOnScreen(){
        CalculatorNodes.SCREEN.setText("");
        CalculatorNodes.SCREEN.setPromptText("Wrong Expression");
    }
}