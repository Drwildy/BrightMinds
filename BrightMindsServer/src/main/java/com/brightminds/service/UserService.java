package com.brightminds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightminds.model.User;
import com.brightminds.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
			// used for constructor injection
	public  UserService() {
		
		
	}
	

	 //used for setter injection
	public void setUserRepository( UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void insertUser(User u) {
		this.userRepository.insert(u);
	}
	
	public User getByName(String name) {
		return this.userRepository.getByName(name);
	}
	
	public User getByUsername(String username) {
		return this.userRepository.getByUsername(username);
	}
	
	public User login(String username, String password) {
		return this.userRepository.login(username, password);
	}

}