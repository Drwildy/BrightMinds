import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../../services/courses.service';
import { Course } from '../../models/course';

@Component({
  selector: 'app-admin-course-manage',
  templateUrl: './admin-course-manage.component.html',
  styleUrls: ['./admin-course-manage.component.css']
})
export class AdminCourseManageComponent implements OnInit {

  approve(course:Course, nStatus:number){
    alert('this is the course id : '+course.id+" en the new status is : "+nStatus);
    this.coursesService.manageCourse(course, nStatus).subscribe(
      result=>{
        console.log("result is",result);  
        this.refreshList();      
      //this.coursesList=result
    }, 
      error=>{ console.log(error)}
    );
  }

  coursesList:Course[];
  constructor(private coursesService: CoursesService) { }

  ngOnInit(): void {
    this.refreshList();
  }

  refreshList(){
    this.coursesService.getCourses().subscribe(
      result=>{
        console.log("result is",result);
        
      this.coursesList=result
    })
  }
}
