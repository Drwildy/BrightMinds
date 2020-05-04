package com.brightminds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Course;
import com.brightminds.service.CourseService;

@RestController("courseController")
@RequestMapping(path = "/course")
public class CourseController {

private CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping("/test")
	public String testing() {
		return "it is working";
	}
	

	@RequestMapping(path = "/listOfCourse",method = RequestMethod.GET)
	public List<Course> getAllCourses(){
		List<Course> listOfCourse = courseService.getListOfCourse();
		return listOfCourse;
	}
	@RequestMapping(path= "/insertCourse", method = RequestMethod.POST )
	public String insertCourse(@RequestBody Course c) {
		courseService.save(c);
		
		return null;
	}
	
}
