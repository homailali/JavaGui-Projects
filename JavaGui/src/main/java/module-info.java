module org.example.javafx {
    requires javafx.fxml;
    requires javafx.controls;



    opens com.Homail.GuiProjects.ToDoApp to javafx.fxml;
    opens com.Homail.GuiProjects.PxToRem to javafx.fxml;
    opens com.Homail.GuiProjects.SnakeGame to javafx.fxml;
    opens com.Homail.GuiProjects.HangManGame to javafx.fxml;
    opens com.Homail.GuiProjects.RockPaperScissors to javafx.fxml;

    exports com.Homail.GuiPractice;
    exports com.Homail.GuiProjects.ToDoApp;
    exports com.Homail.GuiProjects.PxToRem;
    exports com.Homail.GuiProjects.TicTacToe;
    exports com.Homail.GuiProjects.SnakeGame;
    exports com.Homail.GuiProjects.Calculator;
    exports com.Homail.GuiProjects.HangManGame;
    exports com.Homail.GuiProjects.RockPaperScissors;

}