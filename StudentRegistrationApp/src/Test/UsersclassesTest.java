
import static org.junit.jupiter.api.Assertions.*;
/**
 * 	@author Mariya Antony
 *  @version 2.1
 */

import org.junit.jupiter.api.Test;

import com.university.app.model.CourseModel;
import com.university.app.model.StudentModel;

import java.util.ArrayList; 

public class UsersclassesTest {
	
	@Test
	void testGetid() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		long result = student1.getId();
		long expected = 3741001;
		assertEquals(expected,result);
	}
	
	@Test
	void testUser_name() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		String result = student1.getUsername();
		String expected = "alice01";
		assertEquals(expected,result);
	}
	
	@Test
	void testGetPassword() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		String result = student1.getPassword();
		String expected = "pass01";
		assertEquals(expected,result);
	}
	
	@Test
	void testCheckLogin() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		boolean result = student1.CheckLogin("alice01", "pass01");
		boolean expected = true;
		assertEquals(expected,result);
	}
	
	@Test
	void testChangePassword() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		boolean result = student1.ChangePassword("alice01", "pass01", "pass02");
		boolean expected = true;
		assertEquals(expected,result);
	}
	
	@Test
	void testGetname() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		String result = student1.getName();
		String expected = "Alice Johnson";
		assertEquals(expected,result);
	}
	
	@Test
	void testGetmajor() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		String result = student1.getMajor();
		String expected = "Computer Science";
		assertEquals(expected,result);
	}
	
	@Test
	void testGetCreditHours() {
		StudentModel student1  = new StudentModel(3741003, "Charlie Brown", "charlie03","pass03", "Biology");
		int result = student1.getCreditHours();
		int expected = 0;
		assertEquals(expected,result);
	}
	
	@Test
	void getCurrentCourses() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		CourseModel course1 = new CourseModel(1073, "CS", "Natalie Webber", "M/W/F 8:30-9:20", "Head Hall C122", 4, 120, 120);
		student1.addCourse(course1);
		ArrayList<CourseModel> result = student1.getCurrentCourses();
		ArrayList<CourseModel> expected = new ArrayList<>();
		expected.add(course1);
		assertEquals(expected,result);
	}
	
	
	@Test
	void testGetCreditHoursv2() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		CourseModel course1 = new CourseModel(1073, "CS", "Natalie Webber", "M/W/F 8:30-9:20", "Head Hall C122", 4, 120, 120);
		student1.addCourse(course1);
		int result = student1.getCreditHours();
		int expected = 4;
		assertEquals(expected,result);
	}
	
	@Test
	void getCompletedCourses() {
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		CourseModel course1 = new CourseModel(1073, "CS", "Natalie Webber", "M/W/F 8:30-9:20", "Head Hall C122", 4, 120, 120);
		student1.addCompletedCourse(course1);
		
		ArrayList<CourseModel> result = student1.getCompletedCourses();
		
		ArrayList<CourseModel> expected = new ArrayList<>();
		expected.add(course1);
		
		assertEquals(expected,result);
	}
	
}
