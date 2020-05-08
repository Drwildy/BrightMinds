import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CoursesService } from 'src/app/services/courses.service';

@Component({
  selector: 'app-courseregistration',
  templateUrl: './courseregistration.component.html',
  styleUrls: ['./courseregistration.component.css']
})
export class CourseregistrationComponent implements OnInit {
  courseid:string
  coursename:string
  courseprice:string
  ispaied=false

  constructor(private activatedRoute: ActivatedRoute,private courseservice:CoursesService) { 
    this.activatedRoute.queryParams.subscribe(parms=>{
      console.log("test");
      this.courseid=parms.courseid
      this.coursename=parms.coursename
      this.courseprice=parms.courseprice
      console.log(parms);
      
    })
  }

  ngOnInit(): void {
  }
  // this.courseservice.getCourses().subscribe(
  //   result=>{
  //     console.log("result is",result);
      
  //   this.listofcourse=result
  // })
  payment(){
    this.courseservice.payment(this.courseid,1,this.courseprice).subscribe(result=>{
      console.log("saved")
      this.ispaied=true
    },
    error=>{
      console.log(error);
      
    })

  }

}
