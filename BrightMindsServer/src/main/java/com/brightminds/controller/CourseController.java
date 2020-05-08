package com.brightminds.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brightminds.model.Course;
import com.brightminds.model.Instructor;
import com.brightminds.model.Student;
import com.brightminds.service.CourseService;
import com.brightminds.service.InstructorService;
import com.brightminds.service.StudentService;

@CrossOrigin
@RestController("courseController")
@RequestMapping(path = "/course")
public class CourseController {

	private CourseService courseService;
	private StudentService studentService;
	private InstructorService instructorService;

	@Autowired
	public CourseController(CourseService courseService, InstructorService instructorService,
			StudentService studentService) {
		this.courseService = courseService;
		this.instructorService = instructorService;
		this.studentService = studentService;
	}

	@RequestMapping("/test")
	public String testing() {
		return "it is working";
	}

	@RequestMapping(path = "/listOfCourse", method = RequestMethod.GET)

	public List<Course> getAllCourses() {
		System.out.println();
		List<Course> listOfCourse = courseService.getListOfCourse();
		return listOfCourse;
	}

	@RequestMapping(path = "/insertCourse", method = RequestMethod.POST)
	public String insertCourse(@RequestBody Course c) {
		courseService.save(c);

		return null;
	}
  
  @GetMapping(path = "/pay")
	public void payment(@RequestParam(name = "courseid") String courseId,
			@RequestParam(name = "studentid") String studentid, @RequestParam(name = "price") String price) {
		
//	  int sid = Integer.parseInt(studentid);
//		Student student = studentService.getStudentById(sid);
//		Course course = courseService.getCourseById(Integer.parseInt(courseId));
//		if (student.getCourse() != null) {
//			student.getCourse().add(course);
//		} else {
//			HashSet<Course> courses = new HashSet<>();
//			courses.add(course);
//			student.setCourse(courses);
//		}
		System.out.println("commented out due to a bug");
		//studentService.updateStudent(student);
	}

	@PostMapping(path = "/registerCourse", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addCourse(@RequestBody Course c) {
    
		Instructor instructor = this.instructorService.getById(c.getInstructorId().getId());
		c.setInstructorId(instructor);
		
		this.courseService.addCourse(c);
	}

	//getMyActiveCourses
	@PostMapping(path="/getMyActiveCourses", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Course> getActiveCoursesById(@RequestBody Instructor i) {
		
		Instructor instructor = this.instructorService.getById(i.getId());
		
		return this.courseService.getMyCoursesById(instructor);
		
	}
	
	
	@PostMapping(path="/getCourseById", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Course getCourseById(@RequestBody Course c) {
		
		return this.courseService.getCourseById(c.getId());
	}
	
	@PostMapping(path="/editInfo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void editInfo(@RequestBody Course c) {
		
		//System.out.println(c);
		this.courseService.editInfo(c);
	}
		
}
