package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Instructor;
import com.brightminds.model.User;
import com.brightminds.service.InstructorService;

@CrossOrigin
@RestController("InstructorController")
@RequestMapping(path = "/instructor")
public class InstructorController {
	
	private InstructorService instructorService;
	
	@Autowired
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	@PostMapping(path="/getInstructor", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Instructor getInstructor(@RequestBody User u) {

		return this.instructorService.getByUserId(u);
	}

}
