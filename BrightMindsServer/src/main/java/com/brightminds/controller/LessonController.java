package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("LessonController")
@RequestMapping(path = "/lesson")
public class LessonController {
	
	//private LessonService lessonService;
	
//	@Autowired
//	public LessonController(LessonService lessonService) {
//		this.lessonService = lessonService;
//	}

}
