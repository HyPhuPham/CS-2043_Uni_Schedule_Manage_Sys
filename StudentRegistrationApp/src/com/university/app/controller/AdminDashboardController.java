package com.university.app.controller;

import com.university.app.view.AdminDashboardView;

import com.university.app.model.StudentModel;
import com.university.app.util.StudentData;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.ArrayList;

/**
 * This class act a role as a data transporter & handling the.
 * interactions between Interfaces (UI view) and back end code.
 * 
 * @author 1.PhuHyPham
 * @author 2. Austin jamieson
 * @version 1.2.1
 * @since 2025-11-26
 */

public class AdminDashboardController {

    private AdminDashboardView v_adminboard;
    private Stage stg;
    private ArrayList<StudentModel> studentList;
    private int currentIndex = 0;

    public AdminDashboardController(Stage stage) {
        this(stage, StudentData.getStudentList());
    }

    public AdminDashboardController(Stage stage, ArrayList<StudentModel> searchedList) {
        this.stg = stage;
        this.studentList = searchedList;

        v_adminboard = new AdminDashboardView();
        v_adminboard.setControllerLink(this);

        Scene adminScene = v_adminboard.createAdminDashboard();
        stg.setScene(adminScene);
        stg.show();

        v_adminboard.displayStudents(studentList, 0);
        setupActions();
    }

    private void setupActions() {
        v_adminboard.getLogoutButton().setOnAction(e -> handleLogout());
        v_adminboard.getGoUpButton().setOnAction(e -> goUpPage());
        v_adminboard.getGoDownButton().setOnAction(e -> goDownPage());
        v_adminboard.getSearchButton().setOnAction(e -> handleSearching());
    }

    public void handleSearching() {

        String inputSearch = v_adminboard.getSearchBar().getText().trim().toUpperCase();

        if (inputSearch.isEmpty()) {
            studentList = loadStudentData();
            currentIndex = 0;
            v_adminboard.displayStudents(studentList, 0);
            return;
        }

        ArrayList<StudentModel> returnedList = new ArrayList<>();

        for (StudentModel s : studentList) {

            String studentId = String.valueOf(s.getId()).toUpperCase();
            String studentName = s.getName().toUpperCase();

            String combined = (studentId + "-" + studentName)
                    .replace("-", "")
                    .replace(" ", "")
                    .toUpperCase();

            if (studentId.contains(inputSearch)
                    || studentName.contains(inputSearch)
                    || combined.contains(inputSearch)) {

                returnedList.add(s);
            }
        }

        this.studentList = returnedList;
        currentIndex = 0;
        v_adminboard.displayStudents(studentList, 0);
    }
    
   public void viewStudentInfo(StudentModel studentIn) {
	   
	   new StudentInformationController(stg, studentIn);
   }
   
	public void handleLogout() {
	    System.out.println("Logout successfully...");
	    new LoginController(stg);
	}

    public ArrayList<StudentModel> loadStudentData() {
        return StudentData.getStudentList();
    }

    public void goDownPage() {
        if (currentIndex + 7 < studentList.size()) {
            currentIndex += 7;
            v_adminboard.displayStudents(studentList, currentIndex);
        }
    }

    public void goUpPage() {
        if (currentIndex - 7 >= 0) {
            currentIndex -= 7;
            v_adminboard.displayStudents(studentList, currentIndex);
        }
    }
}

