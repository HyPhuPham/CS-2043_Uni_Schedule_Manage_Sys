package com.university.app.util;

import java.util.ArrayList;
import com.university.app.model.StudentModel;
import com.university.app.model.CourseModel;

public class StudentDriver {
    private static StudentModel student; 

    public static StudentModel studentObject() {
        if (student == null) {
            student = new StudentModel(3741975, "Phu Hy Pham", 
                                       "hy.pham1", "123456789", 
                                       "Computer Science");

            ArrayList<CourseModel> courseList = CoursesData.getCourseList();
           
            
            student.addCompletedCourse(courseList.get(0));
            student.addCompletedCourse(courseList.get(1));
            student.addCompletedCourse(courseList.get(2));
            student.addCompletedCourse(courseList.get(3));
            
            student.addCompletedCourse(courseList.get(4));
            student.addCompletedCourse(courseList.get(5));
            student.addCompletedCourse(courseList.get(6));
            student.addCompletedCourse(courseList.get(7));
        }

        return student; 
    }
}
