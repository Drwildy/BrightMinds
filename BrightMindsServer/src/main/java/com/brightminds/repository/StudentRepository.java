package com.brightminds.repository;

import com.brightminds.model.Student;
import com.brightminds.model.User;

public interface StudentRepository extends Base<Student> {
	
	public Student getByUserId(User userId);

}
