package com.university.app.controller;

import com.university.app.view.StudentInformationView;
import com.university.app.model.CourseModel;
import com.university.app.model.StudentModel;
import com.university.app.util.StudentData;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.ArrayList;

/**
 * This class act a role as a data transporter & handling the.
 * interactions between Interfaces (UI view) and back end code.
 * @author 1.PhuHyPham
 * @author 2. Austin Jamieson
 * @version 1.2.1
 * @since 2025-11-26
 */
public class StudentInformationController {
    private StudentInformationView v_studentInfo;
    private Stage stg;
    private ArrayList<StudentModel> studentList; 

    
   
    public StudentInformationController(Stage stage, StudentModel student) {
        this.stg = stage;
        this.studentList = StudentData.getStudentList();

        v_studentInfo = new StudentInformationView();
        v_studentInfo.setControllerLink(this);

        Scene studInfoScene = v_studentInfo.createCourseListView();
        stg.setScene(studInfoScene);
        stg.show();

        updateStudentInfo(student);
        setupActions();
        v_studentInfo.displayStudentCurrentCourses(student.getCurrentCourses());
    }

    private void setupActions() {
    	v_studentInfo.getLogoutButton().setOnAction(e -> handleLogout());
    	v_studentInfo.getBackToStudentListButton().setOnAction(e -> toStudentList());
    	v_studentInfo.getSearchButton().setOnAction(e -> handleSearching());
    }
    
    public void toStudentList() {
    	System.out.println("Back to student List");
    	new AdminDashboardController(stg);
    }
    
    public void handleSearching() {

        String inputSearch = v_studentInfo.getSearchBar().getText().trim().toUpperCase();

        if (inputSearch.isEmpty()) {
            studentList = loadStudentData();
            return;
        }

        ArrayList<StudentModel> returnedList = new ArrayList<>();

        for (int i=0; i<studentList.size(); i++) {
        	
        	StudentModel s = studentList.get(i);
            String studentId = String.valueOf(s.getId()).toUpperCase();
            String studentName = s.getName().toUpperCase();

            String combined = (studentId + " " + studentName)
                    .replace(" ", "")
                    .toUpperCase();

            if (studentId.contains(inputSearch)
                    || studentName.contains(inputSearch)
                    || combined.contains(inputSearch)) {

                returnedList.add(s);
            }
        }

        this.studentList = returnedList;
        new AdminDashboardController(stg, returnedList);
    }

    public void handleLogout() {
        System.out.println("Logout successfully...");
        new LoginController(stg);
    }
    
    public void updateStudentInfo(StudentModel studentIn) {
        String text = "";
        
        ArrayList<CourseModel> completedCourse = studentIn.getCompletedCourses();

        text += "> Student name: " + studentIn.getName()  + "- Student ID:" + studentIn.getId() + "\n"
              + "> Student username: " + studentIn.getUsername() + "\n" 
              + "> Student passowrd: " + studentIn.getPassword() + "\n"
              + "> Student major: " + studentIn.getMajor() + "\n"
              + "> Credit Hours: " + studentIn.getCreditHours() + "\n"
              + "==========================================================================\n"
              + "(COMPLETED COURSES) \n";
        
       for(int i=0; i<completedCourse.size(); i++) {
           text += completedCourse.get(i).getName() + "-" + completedCourse.get(i).getId() + "\n";         	  
        }
        

    	v_studentInfo.getStudentInfoDisplay().setText(text);
    }

    public ArrayList<StudentModel> loadStudentData() {
        return StudentData.getStudentList();
    }

}
    
    

