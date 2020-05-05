package com.brightminds.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Course;
import com.brightminds.model.Lesson;
import com.brightminds.model.Student;
import com.brightminds.model.Test;
import com.brightminds.model.User;
import com.brightminds.service.StudentService;
import com.brightminds.service.UserService;

@CrossOrigin
@RestController("studentController")
@RequestMapping(path = "/student")
public class StudentController {
	
	private StudentService studentService;
	private UserService userService;
	
	@Autowired
	public StudentController(StudentService studentService, UserService userService) {
		this.userService = userService;
		this.studentService = studentService;
	}
	
	
	@PostMapping(path = "/register", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void insertStudent(@RequestBody Student s) {
		
		//Initialize our Student with empty Sets
		Set<Course> courses = new HashSet<>();
		Set<Lesson> lessons = new HashSet<>();
		Set<Test> tests = new HashSet<>();
		s.setCourse(courses);
		s.setLesson(lessons);
		s.setTest(tests);
		
		String username = s.getUserid().getUsername();
		User user = this.userService.getByUsername(username);
		s.setUserid(user);

		this.studentService.insertStudent(s);
	}
	
	@PostMapping(path="/getStudent", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Student getStudent(@RequestBody User u) {
		
		//Returns a student to the Angular
		return this.studentService.getByUserId(u);
	}
		
}
