package com.brightminds.repository;

import com.brightminds.model.User;

public interface UserRepository extends Base<User> {

	public User getByUsername(String username);
	
}
