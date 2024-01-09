module org.example.javafx {
    requires javafx.fxml;
    requires javafx.controls;



    opens com.Homail.GuiProjects.ToDoApp to javafx.fxml;
    opens com.Homail.GuiProjects.StopWatch to javafx.fxml;
    opens com.Homail.GuiProjects.PxToRem to javafx.fxml;
    opens com.Homail.GuiProjects.RockPaperScissors to javafx.fxml;
    opens com.Homail.GuiProjects.SnakeGame.EasyVersion to javafx.fxml;
    opens com.Homail.GuiProjects.SnakeGame.MediumVersion to javafx.fxml;

    exports com.Homail.GuiPractice;
    exports com.Homail.GuiProjects.ToDoApp;
    exports com.Homail.GuiProjects.PxToRem;
    exports com.Homail.GuiProjects.StopWatch;
    exports com.Homail.GuiProjects.RockPaperScissors;
    exports com.Homail.GuiProjects.SnakeGame.EasyVersion;
    exports com.Homail.GuiProjects.SnakeGame.MediumVersion;
}