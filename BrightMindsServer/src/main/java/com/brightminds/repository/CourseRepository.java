package com.brightminds.repository;

import java.util.List;

import com.brightminds.model.Course;
import com.brightminds.model.Instructor;

public interface CourseRepository extends Base<Course> {
	
	public List<Course> getMyCoursesById(Instructor i);
	public void editInfo(Course c);

}
