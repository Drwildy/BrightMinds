import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Course } from 'src/app/models/course';
import { CoursesService } from 'src/app/services/courses.service';

@Component({
  selector: 'app-courselist',
  templateUrl: './courselist.component.html',
  styleUrls: ['./courselist.component.css']
})
export class CourselistComponent implements OnInit {
  listofcourse:Course[]
  constructor(private courseservice:CoursesService) { }

  ngOnInit(): void {
    this.courseservice.getCourses().subscribe(
      result=>{
        //console.log("result is",result);
        
      this.listofcourse=result
    })
  }

}
