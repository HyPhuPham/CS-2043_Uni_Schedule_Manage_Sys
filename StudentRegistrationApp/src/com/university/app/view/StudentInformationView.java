package com.university.app.view;

import com.university.app.controller.StudentInformationController;
import com.university.app.model.CourseModel;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.ArrayList;

/**
 @author Tariq Almadi
 Ver 1.3
**/

public class StudentInformationView {

    private StudentInformationController controllerLink;

    private TextField searchBar;
    private Button searchButton;

    private TextArea studentInfoDisplay;
    private VBox studentCurrentCourseDisplay;

    private Button logout;
    private Button backToStudentList;

    public void setControllerLink(StudentInformationController controller) {
        this.controllerLink = controller;
    }

    /**
     * Create a simple card for one current course (left column).
     */
    public Pane displayCurrentCourseCard(CourseModel courseIn) {

        BorderPane courseCard = new BorderPane();
        courseCard.setPadding(new Insets(10));
        courseCard.setStyle(
                "-fx-font-family: 'Times New Roman';" +
                "-fx-border-color: #2F547A;" +
                "-fx-border-width: 2;" +
                "-fx-background-color: white;"
        );

        Label courseName = new Label(courseIn.getName() + "-" + courseIn.getId());
        courseName.setStyle("-fx-font-weight: bold;");

        VBox leftSide = new VBox(courseName);
        leftSide.setPadding(new Insets(5, 0, 5, 10));

        courseCard.setCenter(leftSide);
        return courseCard;
    }

    /**
     * Display all current courses for the selected student on the left side.
     */
    public void displayStudentCurrentCourses(ArrayList<CourseModel> currCourseList) {
        studentCurrentCourseDisplay.getChildren().clear();

        if (currCourseList == null || currCourseList.isEmpty()) {
            Label noCourses = new Label("No current courses.");
            studentCurrentCourseDisplay.getChildren().add(noCourses);
            return;
        }

        for (CourseModel course : currCourseList) {
            Pane currCourseCard = displayCurrentCourseCard(course);
            studentCurrentCourseDisplay.getChildren().add(currCourseCard);
        }
    }

    /**
     * Build the whole scene (matches your sketch).
     */
    public Scene createCourseListView() {

        BorderPane bdp = new BorderPane();
        bdp.setPadding(new Insets(20));

        // ===== TOP: search bar + search button =====
        HBox topBar = new HBox(10);
        topBar.setAlignment(Pos.CENTER_LEFT);

        searchBar = new TextField();
        searchBar.setPrefWidth(980);

        searchButton = new Button("Search");
        searchButton.setPrefWidth(150);
        searchButton.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        topBar.getChildren().addAll(searchBar, searchButton);
        bdp.setTop(topBar);


        studentCurrentCourseDisplay = new VBox(10);
        studentCurrentCourseDisplay.setPadding(new Insets(0, 10, 0, 0));


        studentCurrentCourseDisplay = new VBox(10);
        studentCurrentCourseDisplay.setPadding(new Insets(0, 10, 0, 0));
        studentCurrentCourseDisplay.setPrefWidth(300);
        studentCurrentCourseDisplay.setPrefHeight(500); 

        bdp.setLeft(studentCurrentCourseDisplay);



        studentInfoDisplay = new TextArea();
        studentInfoDisplay.setPrefSize(600, 500);
        studentInfoDisplay.setWrapText(true);
        studentInfoDisplay.setEditable(false);
        studentInfoDisplay.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 13;");

        bdp.setCenter(studentInfoDisplay);


        VBox buttonSection = new VBox(10);
        buttonSection.setAlignment(Pos.TOP_CENTER);

        backToStudentList = new Button("Student List");
        backToStudentList.setPrefWidth(150);
        backToStudentList.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        logout = new Button("Log out");
        logout.setPrefWidth(150);
        logout.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        buttonSection.getChildren().addAll(backToStudentList, logout);
        bdp.setRight(buttonSection);
        
        BorderPane.setMargin(studentCurrentCourseDisplay, new Insets(10, 10, 0, 0));
        BorderPane.setMargin(studentInfoDisplay, new Insets(10, 10, 0, 0));
        BorderPane.setMargin(buttonSection, new Insets(10, 20, 0, 10));
        
        Scene scene = new Scene(bdp, 1200, 700);
        return scene;
    }

    public TextField getSearchBar() {
        return searchBar;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getBackToStudentListButton() {
        return backToStudentList;
    }

    public Button getLogoutButton() {
        return logout;
    }

    public TextArea getStudentInfoDisplay() {
        return studentInfoDisplay;
    }
}
