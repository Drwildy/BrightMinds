package com.brightminds.repository;

import com.brightminds.model.Instructor;
import com.brightminds.model.User;

public interface InstructorRepository extends Base<Instructor> {

	public Instructor getByUserId(User userId);

}
