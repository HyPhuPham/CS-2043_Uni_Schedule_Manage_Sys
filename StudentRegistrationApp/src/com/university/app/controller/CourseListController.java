package com.university.app.controller;


import com.university.app.view.CourseListView;
import com.university.app.model.CourseModel;
import com.university.app.model.StudentModel;
import com.university.app.util.CoursesData;
import com.university.app.util.StudentDriver;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.ArrayList;

/**
 * Handles the backend of the courselist 
 * 
 * @author 1.PhuHyPham
 * @author 2. Austin jamieson
 * @version 1.2
 * @since 2025-11-24
 */

public class CourseListController {
    private StudentModel student = StudentDriver.studentObject();
    private CourseListView v_courseList;
    private Stage stg;
    private int currentIndex = 0;
    private ArrayList<CourseModel> courseList;

    
    
    public CourseListController(Stage stage) {
        this(stage, CoursesData.getCourseList());  
    }
    
    public CourseListController(Stage stage, ArrayList<CourseModel> searchedList) {
        this.stg = stage;
        this.courseList = searchedList;

        v_courseList = new CourseListView();
        v_courseList.setControllerLink(this);

        Scene courseListScene = v_courseList.createCourseListView();
        stg.setScene(courseListScene);
        stg.show();

        v_courseList.displayCourses(courseList, 0);
        setupActions();
    }
    
/**
 * This function set up all actions for button on the CourseListView scene
 * Including:
 * 	-> logout
 *  -> search
 *  -> Back To Course Schedule
 *  -> Move To Course Matrix
 */
    private void setupActions() {
        v_courseList.getLogoutButton().setOnAction(e -> handleLogout());
        v_courseList.getCourseScheduleButton().setOnAction(e -> toCourseSchedule());
        v_courseList.getGoUpButton().setOnAction(e -> goUpPage());
        v_courseList.getGoDownButton().setOnAction(e -> goDownPage());
        v_courseList.getCourseMatrixButton().setOnAction(e -> toCourseGuidance());
        v_courseList.getSearchButton().setOnAction(e -> handleSearching());
    }
    
    /**
     * Function to return course search result.
     */
    public void handleSearching() {

        String inputSearch = v_courseList.getSearchBar().getText()
            .trim()
            .toUpperCase()
            .replace("-", "")
            .replace(" ", "");

        if (inputSearch.isEmpty()) {
            currentIndex = 0;
            v_courseList.displayCourses(loadCourseData(), 0);
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
        
        v_courseList.getSearchBar().clear();
        currentIndex = 0;
        v_courseList.displayCourses(returnedList, 0);
    }
    
    /**
     * Add Course To Schedule
     * @param courseIn
     */
    public void addCourseToSchedule(CourseModel courseIn) {
        if(student.getCurrentCourses().contains(courseIn)) {

            v_courseList.getNotificationBar().setText("The course is already in the schedule");
            return;
        }
        if(student.getCompletedCourses().contains(courseIn)) {
            v_courseList.getNotificationBar().setText("The course is already completed");
            return;
        }

        student.addCourse(courseIn);

        v_courseList.getNotificationBar().setText("Added " + courseIn.getName() + courseIn.getId());
        
    }
    
    /**
     * Drop Course From Schedule
     * @param courseIn
     */    
    public void dropCourseFromSchedule(CourseModel courseIn) {
        if(student.getCurrentCourses().contains(courseIn)) {
            student.dropCourse(courseIn);
            v_courseList.getNotificationBar().setText("Dropped " + courseIn.getName() + courseIn.getId());
            return;
        }

        v_courseList.getNotificationBar().setText("Cannot drop: Not in current schedule");
    }
   
    /**
     * Function to move to course guidance
     */
    public void toCourseGuidance() {
    	System.out.println("Moving to Course Matrix");
    	new CourseGuidanceController(stg);
    }
    
    /**
     * Function to handle log out process.
     */
    public void handleLogout() {
        System.out.println("Logout out successfully...");
        new LoginController(stg);
    }

    /**
     * Function to move back to dash board.
     */
    public void toCourseSchedule() {
        System.out.println("Move back to Course Schedule...");
        new StudentDashBoardController(stg);
    }
    
    /**
     * Function to load and store courses data
     */
    public ArrayList<CourseModel> loadCourseData() {
    	return CoursesData.getCourseList();
    }
    
    
    /**
     * Function to page down on course display list
     */
    public void goDownPage() {
    	v_courseList.displayCourses(courseList, currentIndex);
    	
    	if(currentIndex + 3 < courseList.size()) {
    		currentIndex += 3;
            v_courseList.displayCourses(courseList, currentIndex);
    	}
    }
    
    /**
     * Function to page up on course display list
     */
    public void goUpPage() {
    	v_courseList.displayCourses(courseList, currentIndex);
    	
    	if(currentIndex - 3 >= 0) {
    		currentIndex -= 3;
            v_courseList.displayCourses(courseList, currentIndex);
    	}
    }
   
}

    
    

