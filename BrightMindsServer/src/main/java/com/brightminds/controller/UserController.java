package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.User;
import com.brightminds.service.UserService;

@CrossOrigin
@RestController("UserController")
@RequestMapping(path = "/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(path="/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void insertUser(@RequestBody User u) {
		System.out.println(u);
		this.userService.insertUser(u);
	}

}
