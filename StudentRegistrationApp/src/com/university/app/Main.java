package com.university.app;

import javafx.application.Application;
import javafx.stage.Stage;
import com.university.app.controller.LoginController;

/**
 * This class is used to run the Application from the whole system
 * @author Phu Hy Pham
 * @version 1.3
 * @since 2025-11-01
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Registration System");

        new LoginController(primaryStage);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
