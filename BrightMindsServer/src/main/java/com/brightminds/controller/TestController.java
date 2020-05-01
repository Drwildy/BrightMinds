package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("TestController")
@RequestMapping(path = "/test")
public class TestController {
	
	//private TestService testService;
	
//	@Autowired
//	public TestController(TestService testService) {
//		this.testService = testService;
//	}

}
