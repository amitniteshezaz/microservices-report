package com.springrest.SpringCourse.service;

import java.util.List;



import com.springrest.SpringCourse.model.Course;


public interface CourseService {
	public List<Course> getCourse();
	public Course addCourse(Course course);
	public Course getCourse(int courseId);
	public Course updateCourse(Course courseId);
	public void deleteCourse(int parseInt);
	

}
