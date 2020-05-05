package com.brightminds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightminds.model.Admin;
import com.brightminds.model.User;
import com.brightminds.repository.AdminRepository;

@Service("adminService")
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	// used for constructor injection
	public AdminService() {}
	
	//used for setter injection
	public void setAdminRepository(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public Admin getByUserId(User userId) {
		return this.adminRepository.getByUserId(userId);
	}

}
