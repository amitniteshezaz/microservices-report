package com.springrest.SpringCourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.SpringCourse.model.Course;
import com.springrest.SpringCourse.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

@Autowired(required = false)
private CourseRepository repo;
	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return repo.save(course);
	}

	@Override
	public Course updateCourse(Course courseId) {
		return repo.save(courseId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		return repo.getOne(courseId);
	}

	@Override
	public void deleteCourse(int parseInt) {
		Course entity=repo.getOne(parseInt);
		repo.delete(entity);;
		
	}

	
	

}
