package com.springrest.SpringCourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springrest.SpringCourse.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	
	

}
