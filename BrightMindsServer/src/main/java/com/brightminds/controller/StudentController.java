package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("StudentController")
@RequestMapping(path = "/student")
public class StudentController {
	
	//private StudentService studentService;
	
//	@Autowired
//	public StudentController(StudentService studentService) {
//		this.studentService = studentService;
//	}

}