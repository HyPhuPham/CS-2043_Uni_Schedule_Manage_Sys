package com.university.app.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 * This class represents the login GUI view.
 * Including the user's name and password input field for user input
 * and a login button for the final stage of the login protocol (verified in the  controller)
 * 
 * @author 1. Tariq Almadi 
 * @author 2. Phu Hy Pham
 * @version 1.3
 * @since 2025-11-01
 */
public class LoginView {

    private Label login;
    private Label userName;
    private Label password;
    private TextField usernameIn;
    private PasswordField passwordIn;
    private Button logInButton;

    public Scene createLoginView(Stage primaryStage) {

        GridPane grp = new GridPane();
        grp.setAlignment(Pos.CENTER); // Set the Alignment into center
        grp.setHgap(10); // Set the Horizontal gap between elements
        grp.setVgap(15); // Set the Vertical gap between elements
        grp.setPadding(new Insets(20, 20, 20, 20));


        login = new Label("Login"); // create a label name login for tagging
        login.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;"); // set the font size and weight for login label.
        grp.add(login, 0, 0, 2, 1); 

    /**
     * ===================================================
     * User's name input space.
     * -> create label and input field for user's name.
     * -> set prefer size for the input field.
     * -> set the alignment for the label and input field.
     * ===================================================
     */
        userName = new Label("Username:"); 
        grp.add(userName, 0, 1);

        usernameIn = new TextField();
        usernameIn.setMaxWidth(180);
        grp.add(usernameIn, 1, 1); // Positioning the column in row 1 - column 1 of the pane

    /**
     * ===================================================
     * Password input space.
     * -> create label and input field for password.
     * -> set prefer size for the input field.
     * -> set the alignment for the label and input field.

     * ===================================================
     */
        password = new Label("Password:");
        grp.add(password, 0, 2);

        passwordIn = new PasswordField();
        passwordIn.setMaxWidth(180);
        grp.add(passwordIn, 1, 2);

    /**
     * ===================================================
     * Login button space.
     * -> create a button for login protocol finals.
     * -> set prefer size for the button.
     * -> set the alignment for button.
     * -> set the font size and color (Blue) for login label.
     * ===================================================
     */
        logInButton = new Button("Log In");
        logInButton.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;");
        grp.add(logInButton, 1, 3); 


        Scene s1 = new Scene(grp, 350, 300); // set the size of loginView GUI
        primaryStage.setScene(s1);
        primaryStage.show();

        return s1;
    }
    
    
   public Button getLoginButton() {
	   return logInButton;
   }
   
   public TextField getUsernameInput() {
	   return usernameIn;
   }
   
   public TextField getPasswordInput() {
	   return passwordIn;
   }
}
