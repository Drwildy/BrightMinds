import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { CoursesService } from '../../services/courses.service';
import { Course } from '../../models/course';

@Component({
  selector: 'app-courselist',
  templateUrl: './courselist.component.html',
  styleUrls: ['./courselist.component.css']
})

export class CourselistComponent implements OnInit {

  coursesList:Course[];
  constructor(private coursesService: CoursesService) { }

  ngOnInit(): void {
    this.coursesService.getCourses().subscribe(
      result=>{
        console.log("result is",result);
        
      this.coursesList=result
    })
  }

}
