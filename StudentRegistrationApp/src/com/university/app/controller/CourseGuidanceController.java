package com.university.app.controller;

import com.university.app.view.CourseGuidanceView;
import com.university.app.model.CourseModel;
import com.university.app.model.StudentModel;
import com.university.app.util.CoursesData;
import com.university.app.util.StudentDriver;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * This class act a role as a data transporter & handling the.
 * interactions between Interfaces (UI view) and back end code.
 * 
 * @author 1. PhuHyPham
 * @author 2. Austin jamieson
 * @version 1.3
 * @since 2025-11-24
 */

public class CourseGuidanceController {
	
    private CourseGuidanceView v_courseGuide;
    private Stage stg;
    private int currentIndex;
    private StudentModel accountIn = StudentDriver.studentObject();

    public CourseGuidanceController(Stage stage) {
        this.stg = stage;

        v_courseGuide = new CourseGuidanceView();
        Scene studDashboardScene = v_courseGuide.createCourseGuidanceView();        
        stg.setScene(studDashboardScene);
        stg.show();
        
        displayPersonalInfo();
        displayCourseGuidance();
        setUpAction();
    }
    
    public void setUpAction() {
    	v_courseGuide.getToCourseListButton().setOnAction(e -> toCourseList());
    	v_courseGuide.getToScheduleButton().setOnAction(e -> toCourseSchedule());
    	v_courseGuide.getLogOutButton().setOnAction(e -> handleLogout());
    	v_courseGuide.getSearchButton().setOnAction(e -> handleSearching());
    }
    
    public void toCourseList() {
    	System.out.println("Moving to course list");
    	new CourseListController(stg);
    }
    
    public void toCourseSchedule() {
    	System.out.println("moving to course schedule");
    	new StudentDashBoardController(stg);
    }
    
    public void handleLogout() {
    	System.out.println("Logout successfully");
    	new LoginController(stg);
    }
    
    
    /**
     * Function to return course search result.
     */
    public void handleSearching() {

        String inputSearch = v_courseGuide.getSearchBar().getText()
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

            // Normalized (clean) versions
            String cleanedId = courseId.replace("-", "").replace(" ", "");
            String cleanedName = courseName.replace("-", "").replace(" ", "");
            String cleanedCombined = (cleanedName + cleanedId);

            if (cleanedId.contains(inputSearch)
                || cleanedName.contains(inputSearch)
                || cleanedCombined.contains(inputSearch)) {

                returnedList.add(c_forSearch);
            }
        }
        
        v_courseGuide.getSearchBar().clear();
        new CourseListController(stg, returnedList);
    }
    

    /**
     * Function to edit and display the student account personal information
     */
    public void displayPersonalInfo() {

        TextArea infoArea = v_courseGuide.getPersonalInfo();
        
        StringBuilder text = new StringBuilder();

        ArrayList<CourseModel> completedList = accountIn.getCompletedCourses();


        text.append("===================================================\n");
        text.append(" STUDENT (" + accountIn.getUsername() + ") PERSONAL INFORMATION\n");
        text.append("===================================================\n\n");


        text.append("> Student Name: ").append(accountIn.getName()).append("\n");
        text.append("> Student ID: ").append(accountIn.getId()).append("\n");
        text.append("> Major: ").append(accountIn.getMajor()).append("\n");
        text.append("> Total Credit Hours: ").append(accountIn.getCreditHours())
            .append(" (CH) / 133 (CH) - Remaining: ")
            .append(133 - accountIn.getCreditHours()).append("\n\n");

        text.append("===================================================\n");
        text.append(" COURSES COMPLETED\n");
        text.append("===================================================\n\n");

        if (completedList.isEmpty()) {
            text.append("No completed courses found.\n");
        } else {
            for (int i=0; i<completedList.size(); i++) {
            	
            	CourseModel c = completedList.get(i);
                text.append("- ")
                    .append(c.getName())
                    .append("-")
                    .append(c.getId())
                    .append("\n");

            }
        }

        infoArea.setText(text.toString());
    }
    
    public void displayCourseGuidance() {

        TextArea infoArea = v_courseGuide.getCourseGuidance();
        
        StringBuilder text = new StringBuilder();

        ArrayList<CourseModel> completedList = accountIn.getCompletedCourses();


        text.append("===================================================\n");
        text.append(" CS ACADEMIC WORK SHEET \n");
        text.append("===================================================\n\n");


        text.append("1. [COMPUTER SCIENCE Core Courses] \n"); 
        text.append("\t > CS-1073 (4 CH)  \n"); 
        text.append("\t > CS-1083 (4 CH)  \n"); 
        text.append("\t > CS-1103 (4 CH)  \n"); 
        text.append("\t > CS-2043 (4 CH)  \n"); 
        text.append("\t > CS-2253 (4 CH)  \n"); 
        text.append("\t > CS-2263 (4 CH)  \n");
        text.append("\t > CS-2333 (3 CH)  \n");
        text.append("\t > CS-2383 (3 CH)  \n"); 
        text.append("\t > CS-3383 (3 CH)  \n"); 
        text.append("\t > CS-3413 (4 CH)  \n");
        text.append("\t > CS-3853 (4 CH)  \n"); 
        text.append("\t > CS-3873 (4 CH)  \n"); 
        text.append("\t > CS-3997 (3 CH) & (Writing CH) \n"); 
        
        text.append("\n 2. [MATH and STATISTIC Core Courses] \n"); 
        text.append("\t > MATH-1003 (3 CH)  \n"); 
        text.append("\t > MATH-1003 (3 CH)  \n"); 
        text.append("\t > MATH-1003 (3 CH)  \n"); 
        text.append("\t > STAT-2593 or 3083 (3 CH) \n"); 
        text.append("\t > STAT-3093 or MATH/STAT xxxx (3 CH)\n"); 
        
        text.append("\n 3. [Breath Core: 10 Courses (min. 30 CH.)] \n"); 
        
        text.append("\n 4. [Technical Electives: 7 Courses (min. 3 CH. each)] \n (Note: 3 courses require programming credit ([P] notation) \n"); 
        
        text.append("\n 5. [Free Electives; 4 Courses (min. 12 CH.)] \n");
        
        text.append("\n 5. [Free Electives; 4 Courses (min. 12 CH.)] \n");
        
        text.append("\n 6. [Courses with Writing CH ([W] Notation (min. 12 CH.)]");
        
        infoArea.setText(text.toString());
    }


}

