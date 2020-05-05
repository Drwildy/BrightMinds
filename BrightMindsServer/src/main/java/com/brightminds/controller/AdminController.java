package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Admin;
import com.brightminds.model.User;
import com.brightminds.service.AdminService;

@CrossOrigin
@RestController("AdminController")
@RequestMapping(path = "/admin")
public class AdminController {
	
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@PostMapping(path="/getAdmin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Admin getAdmin(@RequestBody User u) {
		
		//Returns a student to the Angular
		return this.adminService.getByUserId(u);
	}

}
