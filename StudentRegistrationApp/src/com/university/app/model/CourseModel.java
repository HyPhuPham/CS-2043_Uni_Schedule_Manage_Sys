 
package com.university.app.model;
import java.util.Objects; 
import java.util.ArrayList;
/**
 * This class represent the Course model entities
 * 
 * @author Mariyah Antony
 * @verion 1.1
 * @since 2025-11-06
 */

public class CourseModel {
	    private long id; 
	    private String name; 
        private String professor; 
        private String time; 
        private String location; 
        private int creditHour; 
        private int totalSeats; 
        private int taken;
        private int available;


	    public CourseModel(long id, String name, String professor, String time, String location, int creditHour, int totalSeats, int taken) { 
            this.id = id; 
            this.name = name; 
            this.professor = professor; 
            this.time = time;
            this.location = location; 
            this.creditHour = creditHour; 
            this.totalSeats = totalSeats; 
            this.taken = taken;
            this.available = getAvailableSeats();

	    } 

	  
	    public long getId() { 
	    	return id; 
	    }
	    
        public String getName() { 
        	return name; 
        } 
        public String getProfessor() { 
        	return professor; 
        } 
        public String getTime() { 
        	return time; 
        } 
        public String getLocation() { 
        	return location; 
        } 
        public int getCreditHour() { 
        	return creditHour; 
        	} 
        public int getTotalSeats() { 
        	return totalSeats; 
        	} 
        public int getTaken() { 
        	return taken; 
        } 
        public int getAvailableSeats() { 
        	return totalSeats - taken; 
        } 

	  public boolean enroll() { 
             if (taken < totalSeats) { 
                    taken++; 
              return true; 
            } 
           return false; 
	  } 

	  public void drop() { 
         if (taken > 0) {
         	taken--;
         }
	  } 

	  
	  @Override 
      public String toString() { 
           return name + " (" + id + ") | " + professor + " | Seats: " + taken + "/" + totalSeats; 

	  } 

	  
	  @Override
      public boolean equals(Object o) { 
            if (this == o) return true; 
            if (!(o instanceof CourseModel)) {
            	return false; 
            } 

            CourseModel course = (CourseModel) o; 
            return id == course.id; 
      } 


	  @Override 
	  public int hashCode() { 
         return Objects.hash(id); 
	  } 

} 


