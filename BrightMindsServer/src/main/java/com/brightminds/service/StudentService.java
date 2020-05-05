package com.brightminds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightminds.model.Student;
import com.brightminds.model.User;
import com.brightminds.repository.StudentRepository;

@Service("studentService")
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	//used for constructor injection
	public  StudentService() {}
	

	//used for setter injection
	public void setStudentRepository( StudentRepository  studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public void insertStudent(Student s) {
		this.studentRepository.insert(s);
	}
	
	public Student getByUserId(User userId) {
		return this.studentRepository.getByUserId(userId);
	}
	
	

}

