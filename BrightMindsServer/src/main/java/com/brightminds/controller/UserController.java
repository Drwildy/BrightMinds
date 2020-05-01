package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("UserController")
@RequestMapping(path = "/user")
public class UserController {
	
	//private UserService userService;
	
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}

}
