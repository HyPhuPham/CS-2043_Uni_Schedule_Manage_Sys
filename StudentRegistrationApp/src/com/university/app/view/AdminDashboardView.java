package com.university.app.view;

import com.university.app.controller.AdminDashboardController;
import com.university.app.model.StudentModel;
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
 @author Tariq Almadi 3786455
 Version 1.3
**/

public class AdminDashboardView {
	
	private AdminDashboardController controllerLink;
	private TextField searchBar;
	private Button searchButton;
	private VBox studentListDisp;
	private Button logout;
	private Button goUp;
	private Button goDown;

	public void setControllerLink(AdminDashboardController controller) {
		this.controllerLink = controller;
	}
	
	public Pane displayStudentCard(StudentModel studentIn) {	
		
		BorderPane card = new BorderPane();
		card.setPadding(new Insets(15));
		
	    card.setStyle("-fx-font-family: 'Times New Roman'; -fx-border-color: #2F547A; -fx-border-width: 2; -fx-background-color: white; ");
	    
		VBox leftSideDisp = new VBox(5);
		Label StudentName = new Label(studentIn.getName() + "-" + studentIn.getId());

		leftSideDisp.getChildren().addAll(StudentName);
		
		VBox rightSideDisp = new VBox(5);
		Button viewInfo = new Button("View student informationn");
		viewInfo.setPrefWidth(150);
		viewInfo.setOnAction(e -> controllerLink.viewStudentInfo(studentIn)); 
		
		
		rightSideDisp.getChildren().addAll(viewInfo);
		
		card.setLeft(leftSideDisp);
		card.setRight(rightSideDisp);
		return card;
	}
	
	/**
	 * ===========================================================
	 * Function to Display the student Information Card
	 * @param studentList a List of Student in the System
	 * @param startIndex the index to start in display iteration
	 * ===========================================================
	 */
	public void displayStudents(ArrayList<StudentModel> studentList, int startIndex) {
		studentListDisp.getChildren().clear();
		
		int fullDisplay = Math.min(startIndex+7, studentList.size());
		
		for(int i=startIndex; i<fullDisplay; i++) {
			Pane courseCard = displayStudentCard(studentList.get(i));
			studentListDisp.getChildren().add(courseCard);
		}
	}
	
	public Scene createAdminDashboard() {
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
	 * ===============================================================
	 * Student Course List Information Display and Register section
	 * Including: Displaying field
	 * ===============================================================
	 */
		studentListDisp = new VBox(20);
		studentListDisp.setPrefSize(1000, 500);
	    grp.add(studentListDisp, 0, 1);

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
	    
		logout = new Button("Log out");
		logout.setPrefWidth(150);
		logout.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		buttonSection.getChildren().addAll(logout);
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
}
