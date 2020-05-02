package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("InstructorController")
@RequestMapping(path = "/instructor")
public class InstructorController {
	
	//private InstructorService instructorService;
	
//	@Autowired
//	public InstructorController(InstructorService instructorService) {
//		this.instructorService = instructorService;
//	}

}
