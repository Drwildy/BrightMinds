package com.brightminds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightminds.model.Course;
import com.brightminds.repository.CourseRepository;

@Service("courseService")
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
//	
//			// used for constructor injection
//	public  CourseService() {
//		
//		
//	}
//	

	// used for setter injection
	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> getListOfCourse() {

		List<Course> getAllCourses = courseRepository.getAll();
		return getAllCourses;

	}

	public void save(Course c) {
		courseRepository.insert(c);
	}
}
