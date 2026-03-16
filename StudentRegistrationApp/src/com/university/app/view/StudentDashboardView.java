package com.university.app.view;

import com.university.app.model.CourseModel;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import java.util.ArrayList;

/**
 * This class represent the STUDENT DASHBOARD GUI view.
 * Including:
 * 		-> Course schedule
 * 		-> Searching bar
 * 		-> Functional button
 * 		-> Dash board
 * 
 * @author Tariq Almadi 
 * @author PhuHyPham 
 * @version 1.3
 * @since 2025-11-15
 */
public class StudentDashboardView {
	private TextField searchBar;
	private Button searchButton;
	private Button toCourseList;
	private Button toCourseMatrix;
	private Button logout;
	private TextField announcementBoard;
	private GridPane courseSchedule;
	private Alert detailCourseInfo;
	
	public void createDetailInfoView(CourseModel courseIn) {
		Stage infoScene = new Stage();
		infoScene.setTitle("Course detail information");
		infoScene.setResizable(false);
		
		detailCourseInfo = new Alert(AlertType.CONFIRMATION);


		VBox disp = new VBox(5);
		disp.setAlignment(Pos.CENTER);
		
		Label courseID = new Label(courseIn.getName() + " " + courseIn.getId());
		courseID.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 20px ; -fx-font-weight: bold;");
		
		Label instructor = new Label("Instructor: " + courseIn.getProfessor());
		instructor.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16px ;");
		
		Label time = new Label("Time: " + courseIn.getTime());
		time.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16px ;");
		
		Label location = new Label("Location: " + courseIn.getLocation());
		location.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16px ;");
		
		Label creditHour = new Label("Credit Hours: " + courseIn.getCreditHour());
		creditHour.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16px ;");
		
		Button close = new Button("Close");

		close.setOnAction(e -> infoScene.close());
		disp.getChildren().addAll(courseID, instructor, time, location, creditHour, close);
		
		
		Scene scene = new Scene(disp, 350, 250);
		infoScene.setScene(scene);
		infoScene.showAndWait();
		
	}
	
	public StackPane createCourseCard(CourseModel courseIn) {

	    StackPane courseInfo = new StackPane();
	    courseInfo.setPrefSize(200, 70);
	    courseInfo.setStyle("-fx-border-color: #2F547A; -fx-border-width: 2;");

	    VBox infoDisplay = new VBox(5);
	    infoDisplay.setAlignment(Pos.CENTER);

	    Button viewCourseInfo = new Button(courseIn.getName() + "-" + courseIn.getId());

	    viewCourseInfo.setPrefSize(200, 100);
	    viewCourseInfo.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
	    viewCourseInfo.setMaxWidth(Double.MAX_VALUE);  

	    viewCourseInfo.setOnAction(e -> createDetailInfoView(courseIn));

	    infoDisplay.getChildren().add(viewCourseInfo);
	    courseInfo.getChildren().add(infoDisplay);

	    return courseInfo;
	}
	
	public ArrayList<Integer> extractDaysInCourse(CourseModel courseIn) {

	    String raw = courseIn.getTime().toUpperCase().split(" ")[0];

	    String[] parts = raw.split("/");

	    ArrayList<Integer> days = new ArrayList<>();

	    for (String p : parts) {
	        p = p.trim();

	        if (p.equals("M"))
	            days.add(0);
	        else if (p.equals("T"))
	            days.add(1);        
	        else if (p.equals("W"))
	            days.add(2);
	        else if (p.equals("TH"))
	            days.add(3);       
	        else if (p.equals("F"))
	            days.add(4);
	    }

	    return days;
	}
    
	public void updateSchedule(ArrayList<CourseModel> currCourseIn) {
		int mondayRowStart = 1;
		int tuesdayRowStart = 1;
		int wednesdayRowStart = 1;
		int thursdayRowStart = 1;
		int fridayRowStart = 1;
		
		for(int i=0; i<currCourseIn.size(); i++) {
			CourseModel courseIn = currCourseIn.get(i);
			
			ArrayList<Integer> dayList = extractDaysInCourse(courseIn);
			
			for(int j=0; j<dayList.size(); j++) {
				
				int dayIndex = dayList.get(j);
				
				StackPane courseCard = createCourseCard(courseIn);
				
				if(dayIndex == 0) {
					courseSchedule.add(courseCard, 0, mondayRowStart);
					mondayRowStart++;
				}
				else if(dayIndex == 1) {
					courseSchedule.add(courseCard, 1, tuesdayRowStart);
					tuesdayRowStart++;
				}
				else if(dayIndex == 2) {
					courseSchedule.add(courseCard, 2, wednesdayRowStart);
					wednesdayRowStart++;
				}
				else if(dayIndex == 3) {
					courseSchedule.add(courseCard, 3, thursdayRowStart);
					thursdayRowStart++;
				}
				else if(dayIndex == 4) {
					courseSchedule.add(courseCard, 4, fridayRowStart);
					fridayRowStart++;
				}
			}
		}
	}
	
	public void clearSchedule() {
		courseSchedule.getChildren().removeIf(node -> {
			Integer row = GridPane.getRowIndex(node);
			return row != null && row > 0;
		});
	}
	
    
    public void displaySchedule(ArrayList<CourseModel> courseList) {
        clearSchedule();
        updateSchedule(courseList);
    }
    
	/**
	 * Big method to create the student dash board.
	 * @return a student dash board scene.
	 */
	public Scene crateStudentDashBoard() {
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
	 * Student Course Schedule section
	 * Including: Displaying field
	 * =========================================
	 */
		courseSchedule = new GridPane(5, 5);
		courseSchedule.setMaxSize(1000, 600);
		courseSchedule.setStyle("-fx-font-family: 'Times New Roman'; -fx-border-color: #2F547A; -fx-border-width: 2; -fx-background-color: white; ");
		
		String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		
		/**
		 * Section to create day of week display in the schedule.
		 */
		for(int column = 0; column < 5; column++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPrefWidth(200);                
			col.setHalignment(HPos.CENTER);       
			courseSchedule.getColumnConstraints().add(col);
			   
		    StackPane scheduleCell = new StackPane();
		    scheduleCell.setPrefSize(200, 40);
		    scheduleCell.setStyle("-fx-border-color: #2F547A; -fx-border-width: 1;");
		    Label dayDisp = new Label(daysOfWeek[column]);
		    dayDisp.setStyle("-fx-font-weight: bold;");
		    scheduleCell.getChildren().add(dayDisp);
		    courseSchedule.add(scheduleCell, column, 0);
			
		}
		
		grp.add(courseSchedule, 0, 1);
		    
	/**
	 * =========================================
	 * Functional Button section
	 * Including:
	 * 		-> Course List button button
	 * 		-> Course matrix guidance button
	 * 		-> Announcement Dash board
	 * 		-> Logout button
	 * =========================================
	 */
	    VBox buttonSection = new VBox(10);
	    buttonSection.setAlignment(Pos.TOP_CENTER);
	    
		toCourseList = new Button("Courses List");
		toCourseList.setPrefWidth(150);
		toCourseList.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");

		
		toCourseMatrix = new Button("Courses Guidance");
		toCourseMatrix.setPrefWidth(150);
		toCourseMatrix.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		announcementBoard = new TextField();
		announcementBoard.setPrefSize(150, 490);
		announcementBoard.setEditable(false);
		
		logout = new Button("Log out");
		logout.setPrefWidth(150);
		logout.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white;-fx-font-weight: bold;");
		
		buttonSection.getChildren().addAll(toCourseList, toCourseMatrix, announcementBoard, logout);
		grp.add(buttonSection, 1, 1);
		
	/**
	 * =========================================
	 * Finishing set up pane.
	 * =========================================
	 */
		
		Scene s2 = new Scene(grp, 1200, 700);
		return s2;		
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
	public Button getCourseListButton() {
		return toCourseList;
	}
	
	/**
	 * This function retrieve the toCourseMatrix button.
	 */
	public Button getCourseMatrixButton() {
		return toCourseMatrix;
	}
	
	/**
	 * This function retrieve the announcement board text field.
	 */
	public TextField getAnnouncementBoard() {
		return announcementBoard;
	}
	
	/**
	 * This function retrieve the logout button.
	 */
	public Button getLogoutButton() {
		return logout;
	}
	
	/**
	 *  This function retrieve the schedule gridpane
	 */
	public GridPane getCourseSchedule() {
		return courseSchedule;
	}
}

