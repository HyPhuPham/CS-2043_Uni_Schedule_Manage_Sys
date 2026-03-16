package com.university.app.view;

import com.university.app.model.CourseModel;
import com.university.app.controller.CourseListController;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.ArrayList;




/**
* This class represent the COURSE LIST GUI view.
* Including:
* 		-> Course schedule
* 		-> Searching bar
* 		-> Functional button
* 		-> Dash board to display List of all courses
* 
* @author Tariq Almadi 
* @author  PhuHyPham
* @version 1.3
* @since 2025-11-17
*/
public class CourseListView {
	private TextField searchBar;
	private Button searchButton;
	private VBox courseListDisp;
	private Button toCourseSchedule;
	private Button toCourseMatrix;
	private Button logout;
	private Button goUp;
	private Button goDown;
	private TextField notification;
	private CourseListController controllerLink;

	
	/**
	 * Create a link to the CourseListController
	 * @param controller the courseListController object
	 */
	public void setControllerLink(CourseListController controller) {
		this.controllerLink = controller;
	}
	
	public Pane displayCourseCard(CourseModel courseIn) {	
				
		BorderPane card = new BorderPane();
		card.setPadding(new Insets(15));
		
	    card.setStyle("-fx-font-family: 'Times New Roman'; -fx-border-color: #2F547A; -fx-border-width: 2; -fx-background-color: white; ");
	    
		VBox leftSideDisp = new VBox(5);
		Label courseID = new Label(courseIn.getName() + " " + courseIn.getId());
		Label instructor = new Label("Instructor: " + courseIn.getProfessor());
		Label time = new Label("Time: " + courseIn.getTime());
		Label location = new Label("Location: " + courseIn.getLocation());
		Label creditHour = new Label("Credit Hours: " + courseIn.getCreditHour());
		Label seats = new Label("(available/taken/capacity)" + " (" + courseIn.getAvailableSeats() + "/" + courseIn.getTaken() + "/" + courseIn.getTotalSeats() +")");
				
		leftSideDisp.getChildren().addAll(courseID, instructor, time, location, creditHour, seats);
		
		VBox rightSideDisp = new VBox(5);
		Button addCourse = new Button("Add to Section");
		addCourse.setPrefWidth(150);
		addCourse.setOnAction(e -> controllerLink.addCourseToSchedule(courseIn)); // -- set up the button action for each course card
		
		Button dropCourse = new Button("Drop Course");
		dropCourse.setPrefWidth(150);
		dropCourse.setOnAction(e -> controllerLink.dropCourseFromSchedule(courseIn)); // -- set up the button action for each course card
		
		rightSideDisp.getChildren().addAll(addCourse, dropCourse);
		
		card.setLeft(leftSideDisp);
		card.setRight(rightSideDisp);
		return card;
	}
	
	public void displayCourses(ArrayList<CourseModel> courseList, int startIndex) {
		courseListDisp.getChildren().clear();
		
		int fullDisplay = Math.min(startIndex+3, courseList.size());
		
		for(int i=startIndex; i<fullDisplay; i++) {
			Pane courseCard = displayCourseCard(courseList.get(i));
			courseListDisp.getChildren().add(courseCard);
		}
	}
	
	public Scene createCourseListView() {
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
		courseListDisp = new VBox(20);
		courseListDisp.setPrefSize(1000, 500);
	    grp.add(courseListDisp, 0, 1);

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

		
		toCourseMatrix = new Button("Courses Guidance");
		toCourseMatrix.setPrefWidth(150);
		toCourseMatrix.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		
		logout = new Button("Log out");
		logout.setPrefWidth(150);
		logout.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		buttonSection.getChildren().addAll(toCourseSchedule, toCourseMatrix, logout);
		grp.add(buttonSection, 1, 1);
		
	/**
	 * =========================================
	 * Go Up and Go Down buttons.
	 * =========================================
	 */
		HBox toggleButtons = new HBox(15);
		
		goUp = new Button("Go Up");
		goUp.setPrefWidth(500);
		goUp.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");
		
		goDown = new Button("Go Down");		
		goDown.setPrefWidth(500);
		goDown.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");
		

		toggleButtons.getChildren().addAll(goUp, goDown);
		
		grp.add(toggleButtons, 0, 2);
		
		
		notification = new TextField();
		notification.setPrefSize(1000, 100);
		notification.setEditable(false);
		notification.setStyle("-fx-font-family: 'Consolas'; -fx-font-weight: bold;");
		grp.add(notification, 0, 3);
	
	/**
	 * =========================================
	 * Finishing set up pane.
	 * =========================================
	 */
		
		Scene s3 = new Scene(grp, 1200, 700);
		return s3;
		
	}
	
	
	/**
	 * This function retrieve the data in the search TextField.
	 */
	public TextField getSearchBar( ) {
		return searchBar;
	}
	
	/**
	 * This function retrieve the search button.
	 */
	public Button getSearchButton() {
		return searchButton;
	}
	
	/**
	 * This function retrieve the toCourseList button.
	 */
	public Button getCourseScheduleButton() {
		return toCourseSchedule;
	}
	
	/**
	 * This function retrieve the toCourseMatrix button.
	 */
	public Button getCourseMatrixButton() {
		return toCourseMatrix;
	}
	
	/**
	 * This function retrieve the logout button.
	 */
	public Button getLogoutButton() {
		return logout;
	}
	
	/**
	 * This function retrieve the go Up button
	 */
	public Button getGoUpButton() {
		return goUp;
	}
	
	/**
	 * This function retrieve the go Up button
	 */
	public Button getGoDownButton() {
		return goDown;
	}
	
	/**
	 * This function retrieve the notification bar
	 */
	public TextField getNotificationBar() {
		return notification;
	}
	

}
