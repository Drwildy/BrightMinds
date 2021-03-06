package com.brightminds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightminds.model.Course;
import com.brightminds.model.Instructor;
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
	
	public void addCourse(Course c) {
		this.courseRepository.insert(c);
	}
	
	public List<Course> getMyCoursesById(Instructor i){
		return this.courseRepository.getMyCoursesById(i);
	}
	
	public Course getCourseById(int id) {
		return this.courseRepository.getById(id);
	}
	
	public void editInfo(Course c) {
		this.courseRepository.editInfo(c);
	}

}
