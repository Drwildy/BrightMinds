package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Student;
import com.brightminds.service.StudentService;

@CrossOrigin
@RestController("studentController")
@RequestMapping(path = "/student")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	@PostMapping(path = "/register", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void insertStudent(@RequestBody Student s) {
		System.out.println("OMG DID IT WORK?");
		this.studentService.insertStudent(s);
	}
	
	@GetMapping(path ="/test", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String test() {
		return "This is a test of my url";
	}

	
	
}
