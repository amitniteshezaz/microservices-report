package com.springrest.SpringCourse.Controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.SpringCourse.model.Course;
import com.springrest.SpringCourse.model.CourseNotFoundException;
import com.springrest.SpringCourse.service.CourseService;


@RestController
public class CourseController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private CourseService service;
	
	//Api Internationlization i18N
	@GetMapping("/hello")
	public String helloWorldInternalizatoiom(@RequestHeader(name="Accept-Language" , required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null,"Default Message",LocaleContextHolder.getLocale());
	}
	
	
	//Get Course
	@GetMapping("/courses")
	public List<Course> getCourse() {
		List<Course> c=service.getCourse();
		if(c==null) {
			throw new CourseNotFoundException("id" );
		}
		return c;
	}
	//Get Course By ID
	@GetMapping("/course/{courseId}")
	public EntityModel<Course> getCourse(@PathVariable String courseId) {
		Course c=this.service.getCourse(Integer.parseInt(courseId));
		EntityModel<Course> model=EntityModel.of(c);
		WebMvcLinkBuilder linkToCourse=linkTo(methodOn(this.getClass()).getCourse());
		model.add(linkToCourse.withRel("all-course"));
		return model;
		}
	//Add course
	@PostMapping("/course")
	public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course){
		Course c=null;
		try {
			c=this.service.addCourse(course);
			return ResponseEntity.of(Optional.of(c));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}
	
	//update Course
	@PutMapping("/course/{courseId}")
	public Course updateCourse(@RequestBody Course courseId) {
		return this.service.updateCourse(courseId);
	}
	
	//delete Course 
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.service.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
