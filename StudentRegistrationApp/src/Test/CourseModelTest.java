

import com.university.app.model.CourseModel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 @author Mariya Antony
 @author Phu Hy Pham
 @version 2.1
**/

public class CourseModelTest {

    @Test
    void incrementsUntilFull() {
        CourseModel course1 = new CourseModel(2593, "STAT", "Rejun Ma", "T/Th 10:00-11:20", "Tilley Hall 307", 3, 40, 40);
        assertEquals(40, course1.getTaken());

        assertFalse(course1.enroll());
        assertEquals(40, course1.getTaken());

        assertEquals(0, course1.getAvailableSeats());
    }

    @Test
    void DecrementsUntilTakenButNotZero() {
    	CourseModel course2 = new CourseModel(1073, "CS", "Natalie Webber", "M/W/F 8:30-9:20", "Head Hall C122", 4, 120, 120);
        assertEquals(120, course2.getTaken());
        course2.drop(); 
        
        assertEquals(119, course2.getTaken());
        assertTrue(course2.enroll());
        
        assertEquals(120, course2.getTaken());
        course2.drop();
        
        assertEquals(119, course2.getTaken());
    }

}
