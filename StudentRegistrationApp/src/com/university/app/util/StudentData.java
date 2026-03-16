package com.university.app.util;

import com.university.app.model.StudentModel;
import com.university.app.model.CourseModel;
import java.util.ArrayList;

public class StudentData {
	
	public static ArrayList<StudentModel>getStudentList() {
		ArrayList<StudentModel> studentList = new ArrayList<StudentModel>();
		
		ArrayList<CourseModel> courseList = CoursesData.getCourseList();
		
		StudentModel student1  = new StudentModel(3741001, "Alice Johnson", "alice01",  "pass01", "Computer Science");
		student1.addCourse(courseList.get(4));
		student1.addCourse(courseList.get(5));
		student1.addCourse(courseList.get(6));
		student1.addCourse(courseList.get(7));
		
		student1.addCompletedCourse(courseList.get(0));
		student1.addCompletedCourse(courseList.get(1));
		student1.addCompletedCourse(courseList.get(2));
		student1.addCompletedCourse(courseList.get(3));
		
		StudentModel student2  = new StudentModel(3741002, "Bob Smith", "bob02",    "pass02", "Mathematics");
		student2.addCourse(courseList.get(12));
		student2.addCourse(courseList.get(13));
		student2.addCourse(courseList.get(14));
		student2.addCourse(courseList.get(15));
		
		student2.addCompletedCourse(courseList.get(5));
		student2.addCompletedCourse(courseList.get(6));
		student2.addCompletedCourse(courseList.get(7));
		student2.addCompletedCourse(courseList.get(8));
		
		StudentModel student3  = new StudentModel(3741003, "Charlie Brown", "charlie03","pass03", "Biology");

		
		StudentModel student4  = new StudentModel(3741004, "David Wilson", "david04",  "pass04", "Physics");

		
		StudentModel student5  = new StudentModel(3741005, "Emma Davis", "emma05",   "pass05", "Chemistry");

		StudentModel student6  = new StudentModel(3741006, "Fiona Harris", "fiona06",  "pass06", "Software Engineering");
		
		StudentModel student7  = new StudentModel(3741007, "George Carter", "george07", "pass07", "Computer Science");
		
		student7.addCourse(courseList.get(8));
		student7.addCourse(courseList.get(9));
		student7.addCourse(courseList.get(10));
		student7.addCourse(courseList.get(11));
		student7.addCourse(courseList.get(12));
		
		student7.addCompletedCourse(courseList.get(0));
		student7.addCompletedCourse(courseList.get(1));
		student7.addCompletedCourse(courseList.get(2));
		student7.addCompletedCourse(courseList.get(3));
		
		student7.addCompletedCourse(courseList.get(4));
		student7.addCompletedCourse(courseList.get(5));
		student7.addCompletedCourse(courseList.get(6));
		student7.addCompletedCourse(courseList.get(7));
		
		StudentModel student8  = new StudentModel(3741008, "Hannah Moore", "hannah08", "pass08", "Mathematics");
		
		StudentModel student9  = new StudentModel(3741009, "Ian Murphy", "ian09",    "pass09", "Computer Science");
		
		StudentModel student10 = new StudentModel(3741010, "Julia Scott", "julia10",  "pass10", "Physics");

		StudentModel student11 = new StudentModel(3741011, "Kevin Adams", "kevin11",  "pass11", "Biology");
		
		StudentModel student12 = new StudentModel(3741012, "Lily Turner", "lily12",   "pass12", "Computer Science");
		
		StudentModel student13 = new StudentModel(3741013, "Mason Clark", "mason13",  "pass13", "Math");
		
		StudentModel student14 = new StudentModel(3741014, "Nora Allen", "nora14",   "pass14", "Chemistry");
		
		StudentModel student15 = new StudentModel(3741015, "Oscar Wright", "oscar15",  "pass15", "Software Engineering");

		StudentModel student16 = new StudentModel(3741016, "Paula King", "paula16",  "pass16", "Computer Science");
		
		StudentModel student17 = new StudentModel(3741017, "Quinn Lewis", "quinn17",  "pass17", "Math");
		
		StudentModel student18 = new StudentModel(3741018, "Ryan Walker", "ryan18",   "pass18", "Physics");
		
		StudentModel student19 = new StudentModel(3741019, "Sophia Young", "sophia19", "pass19", "Biology");
		
		StudentModel student20 = new StudentModel(3741020, "Tyler Hill", "tyler20",  "pass20", "Computer Science");
		
		StudentModel student21 = new StudentModel(3741975, "Phu Hy Pham", "hy.pham1", "pass21", "Computer Science");
		student21.addCourse(courseList.get(4));
		student21.addCourse(courseList.get(5));
		student21.addCourse(courseList.get(6));
		student21.addCourse(courseList.get(7));
		
		student21.addCompletedCourse(courseList.get(0));
		student21.addCompletedCourse(courseList.get(1));
		student21.addCompletedCourse(courseList.get(2));
		student21.addCompletedCourse(courseList.get(3));
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		
		studentList.add(student5);
		studentList.add(student6);
		studentList.add(student7);
		studentList.add(student8);
		
		studentList.add(student9);
		studentList.add(student10);
		studentList.add(student11);
		studentList.add(student12);
		
		studentList.add(student13);
		studentList.add(student14);
		studentList.add(student15);
		studentList.add(student16);
		
		studentList.add(student17);
		studentList.add(student18);
		studentList.add(student19);
		studentList.add(student20);
		
		studentList.add(student21);
		
		return studentList;
	}
}
