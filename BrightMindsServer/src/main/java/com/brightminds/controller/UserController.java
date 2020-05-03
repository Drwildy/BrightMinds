package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Type;
import com.brightminds.model.User;
import com.brightminds.service.TypeService;
import com.brightminds.service.UserService;

@CrossOrigin
@RestController("UserController")
@RequestMapping(path = "/user")
public class UserController {
	
	private UserService userService;
	private TypeService typeService;
	
	@Autowired
	public UserController(UserService userService, TypeService typeService) {
		this.userService = userService;
		this.typeService = typeService;
	}
	
	@PostMapping(path="/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void insertUser(@RequestBody User u) {

		int typeid = Integer.parseInt(u.getTypeid().getType());
		Type type = this.typeService.getById(typeid);
		u.setTypeid(type); //sets a Type Object
		this.userService.insertUser(u);
	}

}
