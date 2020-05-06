package com.brightminds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Course;
import com.brightminds.model.Instructor;
import com.brightminds.service.CourseService;
import com.brightminds.service.InstructorService;

@CrossOrigin
@RestController("courseController")
@RequestMapping(path = "/course")
public class CourseController {

	private CourseService courseService;
	private InstructorService instructorService;

	@Autowired
	public CourseController(CourseService courseService, InstructorService instructorService) {
		this.courseService = courseService;
		this.instructorService = instructorService;
	}

	@RequestMapping("/test")
	public String testing() {
		return "it is working";
	}

//	@RequestMapping(path = "/listOfCourse",method = RequestMethod.GET)
	@GetMapping(path = "/listOfCourse")
	public List<Course> getAllCourses() {
		System.out.println();
		List<Course> listOfCourse = courseService.getListOfCourse();
		return listOfCourse;
	}

	@RequestMapping(path = "/insertCourse", method = RequestMethod.POST)
	public String insertCourse(@RequestBody Course c) {
		courseService.save(c);

		return null;
	}
	
	@PostMapping(path="/registerCourse", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addCourse(@RequestBody Course c) {
		
		Instructor instructor = this.instructorService.getById(c.getInstructorId().getId());
		c.setInstructorId(instructor);
		
		this.courseService.addCourse(c);
	}

}
