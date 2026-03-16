 package com.university.app.model;

import java.util.ArrayList;

/**
 * @author Mariyah Antony
 * @verion 1.1
 * @since 2025-11-06
 */

public class StudentModel extends UserModel{
	private ArrayList<CourseModel> currentCourses;
	private ArrayList<CourseModel> completedCourses;
	private String major;
	private int totalCreditHour;
	private String name;
	
    public StudentModel(long id, String name, String username, String password, String major) { 
        super(id, username, password); 
        this.currentCourses = new ArrayList<>(); 
        this.completedCourses = new ArrayList<>(); 
        this.name = name;
        this.major = major;
        this.totalCreditHour = 0;
    } 
    
    public ArrayList<CourseModel> getCurrentCourses() { 
    	return currentCourses; 
    } 
    
    public ArrayList<CourseModel> getCompletedCourses() { 
    	return completedCourses; 
    } 
    
    public String getMajor() { 
    	return major;
    }
    
    public String getName() { 
    	return name;
    }
    
    
    public int getCreditHours() { 
    	return totalCreditHour;
    }
    
	@Override
    public String getUsername() {
    	return super.getUsername();
    }
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}
    
    public void addCourse(CourseModel courseIn) {
    	if(!currentCourses.contains(courseIn) && !completedCourses.contains(courseIn)) {
    		currentCourses.add(courseIn);
    		totalCreditHour += courseIn.getCreditHour();
    		System.out.println("Add course successfully");
    	} 
    }
    
    public void dropCourse(CourseModel courseIn) {
    	if(currentCourses.contains(courseIn)) {
    		currentCourses.remove(courseIn);
    		System.out.println("Drop course successfully");
    	} 
    }
    
    public void addCompletedCourse(CourseModel courseIn) {
    	if(!completedCourses.contains(courseIn)) {
    		completedCourses.add(courseIn);
    		totalCreditHour += courseIn.getCreditHour();
    		System.out.println("added completed course successfully");
    	} 
    }
    
    public void setCompletedCourse(CourseModel courseIn) { 
        if (currentCourses.contains(courseIn)) { 
             currentCourses.remove(courseIn); 
             completedCourses.add(courseIn); 
     		 totalCreditHour += courseIn.getCreditHour();
       } 
    } 
    
 
    
    @Override 
    public String toString() { 
           return super.toString() + " | Current: " + currentCourses.size() + " | Completed: " + completedCourses.size(); 
    } 

}


