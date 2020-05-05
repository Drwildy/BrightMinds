package com.brightminds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightminds.model.Instructor;
import com.brightminds.model.User;
import com.brightminds.repository.InstructorRepository;

@Service("instructorService")
public class InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
			// used for constructor injection
	public  InstructorService() {
		
		
	}
	

	// used for setter injection
	public void setInstructorRepository(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	public Instructor getByUserId(User userId) {
		return this.instructorRepository.getByUserId(userId);
	}

}
