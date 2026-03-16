package com.university.app.controller;

import java.util.ArrayList;

import com.university.app.model.CourseModel;
import com.university.app.model.StudentModel;
import com.university.app.util.CoursesData;
import com.university.app.util.StudentDriver;
import com.university.app.view.StudentDashboardView;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * This class act a role as a data transporter & handling the.
 * interactions between Interfaces (UI view) and back end code.
 * 
 * @author 1.PhuHyPham
 * @author 2. Austin Jamieson
 * @version 1.3.1
 * @since 2025-11-26
 */

public class StudentDashBoardController {
    private StudentModel student = StudentDriver.studentObject();
    private StudentDashboardView v_studDashboard;
    private Stage stg;
    private int currentIndex;
    
    public StudentDashBoardController(Stage stage) {
        this.stg = stage;

        v_studDashboard = new StudentDashboardView();
        Scene studDashboardScene = v_studDashboard.crateStudentDashBoard();
        v_studDashboard.displaySchedule(student.getCurrentCourses());
        
        stg.setScene(studDashboardScene);
        stg.show();

        SetUpAction();

    }
    

    /**
     * ===================================================================================
     * This section is a process of pressing logout button.
     * Including:
     * 	-> LogoutAction() - set up an action to the logout button.
     * 	-> handleLogout() - create a process to log out by switching back to login view.
     * =================================================================================== 
     */
    public void SetUpAction() {
        v_studDashboard.getLogoutButton().setOnAction(e -> handleLogout());
    	v_studDashboard.getCourseListButton().setOnAction(e -> toCourseList());
    	v_studDashboard.getCourseListButton().setOnAction(e -> toCourseList());
    	v_studDashboard.getCourseMatrixButton().setOnAction(e -> toCourseGuidance());
    	v_studDashboard.getSearchButton().setOnAction(e -> handleSearching());
    	
    }

    public void handleLogout() {
    	System.out.println("Logot out successfully...");
    	new LoginController(stg);
    }
    
    /**
     * Function to return course search result.
     */
    public void handleSearching() {

        String inputSearch = v_studDashboard.getSearchBar().getText()
                .trim()
                .toUpperCase()
                .replace("-", "")
                .replace(" ", "");

        if (inputSearch.isEmpty()) {
            currentIndex = 0;
            new CourseListController(stg, CoursesData.getCourseList());
            return;
        }

        ArrayList<CourseModel> returnedList = new ArrayList<>();

        for (int i=0; i < CoursesData.getCourseList().size(); i++) {
        	
        	CourseModel c_forSearch = CoursesData.getCourseList().get(i);
            String courseId = String.valueOf(c_forSearch.getId()).toUpperCase();
            String courseName = c_forSearch.getName().toUpperCase();

            
            String cleanedId = courseId.replace("-", "").replace(" ", "");
            String cleanedName = courseName.replace("-", "").replace(" ", "");
            String cleanedCombined = (cleanedName + cleanedId);

            if (cleanedId.contains(inputSearch)
                || cleanedName.contains(inputSearch)
                || cleanedCombined.contains(inputSearch)) {

                returnedList.add(c_forSearch);
            }
        }
        
        v_studDashboard.getSearchBar().clear();

        new CourseListController(stg, returnedList);
    }
    
    public void toCourseList() {
    	System.out.println("Moving to Courses List");
    	new CourseListController(stg);
    }
    
    public void toCourseGuidance() {
    	System.out.println("Moving to Course Matrix");
    	new CourseGuidanceController(stg);
    }
}
    

