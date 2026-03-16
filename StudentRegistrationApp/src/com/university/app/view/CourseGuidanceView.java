package com.university.app.view;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;

import javafx.geometry.Insets;

/**
	@author Tariq Almadi
	Ver 1.3
**/
public class CourseGuidanceView {
	private TextField searchBar;
	private Button searchButton;
	private TextArea courseGuideDisp;
	private TextArea personalInfo;
	private Button toCourseSchedule;
	private Button logout;
	private Button toCourseList;
	
	public Scene createCourseGuidanceView() {
		GridPane grp = new GridPane();
		grp.setHgap(10);
		grp.setVgap(15);
		grp.setPadding(new Insets(20, 20, 20, 20));
		
		
	/**
	 * =========================================
	 * Searching section					
	 * Including: 
	 * 		-> Searching bar (searching course)
	 * 		-> Searching button (action)
	 * =========================================
	 */
		
		searchBar = new TextField();
		searchBar.setPrefWidth(1000);
		grp.add(searchBar, 0, 0);
		
		searchButton = new Button("Search");
		searchButton.setPrefWidth(150);
		searchButton.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		
		grp.add(searchButton, 1, 0);	
		
	/**
	 * =========================================
	 * Student Course List Information Display and Register section
	 * Including: Displaying field
	 * =========================================
	 */
        VBox personalInfoDisp = new VBox(5);
        Label personalHeader = new Label("Student Information");
        personalHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        personalInfo = new TextArea();
        personalInfo.setEditable(false);
        personalInfo.setPrefSize(500, 650);
        personalInfo.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

        personalInfoDisp.getChildren().addAll(personalHeader, personalInfo);


        VBox guidanceDisp = new VBox(5);
        Label guidanceHeader = new Label("Course Guidance");
        guidanceHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        courseGuideDisp = new TextArea();
        courseGuideDisp.setEditable(false);
        courseGuideDisp.setPrefSize(500, 650);
        courseGuideDisp.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

        guidanceDisp.getChildren().addAll(guidanceHeader, courseGuideDisp);

        HBox infoBoxes = new HBox(25, personalInfoDisp, guidanceDisp);

        
        grp.add(infoBoxes, 0, 1);

	/**
	 * =========================================
	 * Functional Button section
	 * Including:
	 * 		-> Back To Schedule button
	 * 		-> To Course Matrix button
	 * 		-> Logout Button
	 * =========================================
	 */

	    VBox buttonSection = new VBox(10);
	    buttonSection.setAlignment(Pos.TOP_CENTER);
	    
	    toCourseSchedule = new Button("Back to schedule");
	    toCourseSchedule.setPrefWidth(150);
	    toCourseSchedule.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");

		
	    toCourseList = new Button("Courses List");
	    toCourseList.setPrefWidth(150);
	    toCourseList.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		
		logout = new Button("Log out");
		logout.setPrefWidth(150);
		logout.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		buttonSection.getChildren().addAll(toCourseSchedule, toCourseList, logout);
		grp.add(buttonSection, 1, 1);
		
	
	/**
	 * =========================================
	 * Finishing set up pane.
	 * =========================================
	 */
		
	
		Scene s4 = new Scene(grp, 1200, 700);
		return s4;
		
	}
	
	public TextField getSearchBar() {
		return searchBar;
	}
	
	public Button getSearchButton() {
		return searchButton;
	}

	
	public Button getToScheduleButton() {
		return toCourseSchedule;
	}
	
	public Button getToCourseListButton() {
		return toCourseList;
	}
	
	public Button getLogOutButton() {
		return logout;
	}
	
	public TextArea getCourseGuidance() {
		return courseGuideDisp;
	}
	
	public TextArea getPersonalInfo() {
		return personalInfo;
	}
	
}
