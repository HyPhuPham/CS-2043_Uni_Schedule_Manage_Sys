
import org.junit.jupiter.api.Test;

import com.university.app.model.CourseModel;
import com.university.app.model.StudentModel;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 @author Tariq Almadi
 @author Phu Hy Pham
 @version 2.1
**/
public class StudentTest {

    @Test
    void testAddAvoidDuplicates() {
        StudentModel student1 = new StudentModel(1L, "Tariq Almadi", "tariq-almadi", "123141", "Computer Science");
        CourseModel course1 = new CourseModel(2043, "CS", "Francis Palma", "T/Th 10:00-11:20", "Head Hall C10", 4, 120, 120);

        student1.addCourse(course1);
        student1.addCourse(course1); 

        var courses = student1.getCurrentCourses();

        assertEquals(1, courses.size());
        assertTrue(courses.contains(course1));
    }

    @Test
    void testDropCourse() {
    	StudentModel student1 = new StudentModel(1L, "Tariq Almadi", "tariq-almadi", "123141", "Computer Science");
        CourseModel course1 = new CourseModel(2383, "CS", "Andrew McAlister", "M/W/F 9:30-10:20", "bailey Hall 146", 4, 120, 120);
        CourseModel course2 = new CourseModel(2253, "CS", "Zeshan Alam", "T/Th 8:30-9:50", "Head Hall C127", 4, 120, 120);


        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.dropCourse(course1);

        ArrayList<CourseModel> remaining = new ArrayList<CourseModel>();
        for (CourseModel x : student1.getCurrentCourses()) {
            remaining.add(x);
        }

        assertEquals(1, remaining.size());
        assertFalse(remaining.contains(course1));
        assertTrue(remaining.contains(course2));
    }

}
