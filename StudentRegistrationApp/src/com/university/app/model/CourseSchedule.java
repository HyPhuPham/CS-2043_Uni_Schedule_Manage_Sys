 package com.university.app.model;

import java.util.ArrayList; 
import java.util.List; 

/**
 * This class represent the user model entities
 * 
 * @author Mariyah Antony
 * @verion 1.1
 * @since 2025-11-06
 */

public class CourseSchedule {
	
	  
       private StudentModel student; 
       private List<CourseModel> registeredCourses; 

	  
     public CourseSchedule(StudentModel student) { 
          this.student = student; 
          this.registeredCourses = new ArrayList<>(); 
   } 

	  

	    public StudentModel getStudent() { return student; } 
	    public List<CourseModel> getRegisteredCourses() { return registeredCourses; } 

	  

	    public boolean registerCourse(CourseModel course) { 
              if (!registeredCourses.contains(course) && course.enroll()) { 
                   registeredCourses.add(course); 
                   student.addCourse(course); 
                     return true; 
             } 
                return false; 
          } 

	  

	    public boolean dropCourse(CourseModel course) { 
             if (registeredCourses.remove(course)) { 
                  course.drop(); 
                  student.dropCourse(course); 
                    return true; 
             } 
            return false; 

	    } 

	  

	    public int getTotalCredits() { 
             return registeredCourses.stream().mapToInt(CourseModel::getCreditHour).sum(); 

	    } 

	  

	    @Override 

	    public String toString() { 
             return "Schedule for " + student.getName() + ": " + registeredCourses.size() + " courses"; 
         } 

	} 
