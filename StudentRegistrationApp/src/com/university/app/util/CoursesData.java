package com.university.app.util;

import com.university.app.model.CourseModel;
import java.util.ArrayList;

public class CoursesData {
	
	
	public static ArrayList<CourseModel>getCourseList() {
		ArrayList<CourseModel> courseList = new ArrayList<CourseModel>();
		
		CourseModel course1 = new CourseModel(1073, "CS", "Natalie Webber", "M/W/F 8:30-9:20", "Head Hall C122", 4, 120, 120);
		CourseModel course2 = new CourseModel(1083, "CS", "Connor Wilson", "M/W/F 1:30-2:20", "ITC 317", 4, 50, 26);
		CourseModel course3 = new CourseModel(2333, "CS", "Michael Fleming", "M/W/F 10:30-11:20", "Head Hall 211", 4, 120, 120);
		CourseModel course4 = new CourseModel(2613, "CS", "David Bremner", "M/W/F 18:30-19:50", "Gillin Hall ITC112", 4, 120, 120);
		CourseModel course5 = new CourseModel(2253, "CS", "Zeshan Alam", "T/Th 8:30-9:50", "Head Hall C127", 4, 120, 120);
		CourseModel course6 = new CourseModel(2263, "CS", "Connor Wilson", "M/W/F 12:30-1:20", "Head Hall D124", 4, 120, 120);
		CourseModel course7 = new CourseModel(3413, "CS", " Georgiy Krylov", "M/W/F 12:30-1:20", "Carleton Hall 105", 4, 120, 120);
		CourseModel course8 = new CourseModel(2383, "CS", "Andrew McAlister", "M/W/F 9:30-10:20", "bailey Hall 146", 4, 120, 120);
		CourseModel course9 = new CourseModel(3997, "CS", "Aljendi Shadi", "M/W/F 4:30-5:20", "Head Hall C11", 4, 120, 120);
		CourseModel course10 = new CourseModel(1003, "MATH", "Vladimir Tasic", "M/W/F 11:30-12:20", "Toole Hall 3", 4, 120, 120);
		CourseModel course11 = new CourseModel(3113, "CS", "Kalinkar Mandal", "M/W/F 8:30-9:20", "Bailey Hall 146", 4, 120, 120);
		CourseModel course12 = new CourseModel(1503, "MATH", "Salmani Mahin", "M/W/F 11:30-12:20", "Tilley Hall 102", 4, 120, 120);
		CourseModel course13 = new CourseModel(2043, "CS", "Francis Palma", "T/Th 10:00-11:20", "Head Hall C10", 4, 120, 120);
		CourseModel course14 = new CourseModel(1513, "HIST", "David Bent", "T/Th 1:00-1:20", "Tilley Hall 104", 3, 30, 22);
		CourseModel course15 = new CourseModel(1303, "CS", "Michael Flemming", "T/Th 11:30-12:20", "Tilley Hall 105", 3, 30, 30);
		CourseModel course16 = new CourseModel(2593, "STAT", "Rejun Ma", "T/Th 10:00-11:20", "Tilley Hall 307", 3, 40, 40);
		
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		courseList.add(course4);
		courseList.add(course5);
		courseList.add(course6);
		courseList.add(course7);
		courseList.add(course8);
		courseList.add(course9);
		courseList.add(course10);
		courseList.add(course11);
		courseList.add(course12);
		courseList.add(course13);
		courseList.add(course14);
		courseList.add(course15);
		courseList.add(course16);
		
		return courseList;
		
	}
}
