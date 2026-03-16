package com.university.app.controller;

import com.university.app.view.LoginView;

import javafx.stage.Stage;

/**
 * This class act a role as a data transporter & handling the.
 * interactions between Interfaces (UI view) and back end code.
 * -> Retrieves the text string from login input field.
 * -> Verify with available login data in the system.
 * -> Once verify -> swith to main pane
 * 
 * @author 1.Phu Hy Pham
 * @author 2. Austin Jamieson
 * @version 1.4.1
 * @since 2025-11-26
 */

public class LoginController {

    private LoginView v_login;
    private Stage stg;

    public LoginController(Stage stage) {
        this.stg = stage;
        v_login = new LoginView();
        v_login.createLoginView(stg);
        
        setupActions();
    }

    private void setupActions() {
    	v_login.getLoginButton().setOnAction(e -> handleLogin());
    }

    private void handleLogin() {
        String username = v_login.getUsernameInput().getText();
        String password = v_login.getPasswordInput().getText();

        if (username.equals("user") && password.equals("123")) {
            System.out.println("Login student successful!");

            new StudentDashBoardController(stg);
            	
        } 
        if (username.equals("admin") && password.equals("123")) {
            System.out.println("Login admin successful!");

            new AdminDashboardController(stg);
            	
        }
        else {
            System.out.println("Invalid credentials");
        }
    }
    public LoginView getLoginView() {
        return v_login;
    }
}

