import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Course } from 'src/app/models/course';
import { CoursesService } from 'src/app/services/courses.service';
import { Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-courselist',
  templateUrl: './courselist.component.html',
  styleUrls: ['./courselist.component.css']
})
export class CourselistComponent implements OnInit {
  listofcourse:Course[]
  constructor(private courseservice:CoursesService, private router:Router) { }

  ngOnInit(): void {
    this.courseservice.getCourses().subscribe(
      result=>{
        //console.log("result is",result);
        
      this.listofcourse=result
    })
  }

  logout():void{
    sessionStorage.clear();
    this.router.navigate[('')];
  }

  courseRegistration(course:Course){

    let courseDetails: NavigationExtras = {
      queryParams: {
        "courseid": course.id,
        "coursename": course.title,
        "courseprice": course.price
      }
    }

      this.router.navigate(['courseregistration'], courseDetails);
  }

}
