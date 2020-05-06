import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';
import { InstructorService } from 'src/app/services/instructor.service';
import { Router } from '@angular/router';
import { Instructor } from 'src/app/models/Instructor';

@Component({
  selector: 'app-instructor',
  templateUrl: './instructor.component.html',
  styleUrls: ['./instructor.component.css']
})
export class InstructorComponent implements OnInit {

    //Display and change your own information
    public instid:number;
    public firstName:string;
    public lastName:string;
    public phoneNumber:string;
    public address:string;
    public DOB:number;
    public degree:string;

    //For adding courses
    public id:number
    public instructorId:number
    public hours:number
    public price:number
    public title:string
    public description:string
    public status:number
    public createdAt:string
    public updatedAt:string
    
    //For form error
    public bad:boolean = false;


  constructor(private instructorService:InstructorService, private router:Router) { }

  ngOnInit(): void {

    //Perform auth check first?

    this.instid = Number(sessionStorage.getItem("id"));
    this.firstName = sessionStorage.getItem("First Name");
    this.lastName = sessionStorage.getItem("Last Name");
    this.phoneNumber = sessionStorage.getItem("Phone Number");
    this.address = sessionStorage.getItem("Address");
    this.DOB = Number(sessionStorage.getItem("DOB"));
    this.degree = sessionStorage.getItem("Degree");


  }

  registerCourse(): void{

    this.instructorId = this.instid;
    let instructor = new Instructor(this.instructorId, null, null, null, null, null, null, null, null, null, null);
    let course = new Course(0, instructor, this.hours, this.price, this.title, this.description, 1, null, null);

    this.instructorService.registerCourse(course)
    .subscribe(
      result =>{

      },
      error =>{

      }
    );

    console.log("Course: ", course);
  }

}
