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

    //Display your own info
    public instid:number;
    public firstName:string;
    public lastName:string;
    public phoneNumber:string;
    public address:string;
    public DOB:string;
    public degree:string;

    //Edit your info
    public editinstid:number;
    public editfirstName:string;
    public editlastName:string;
    public editphoneNumber:string;
    public editaddress:string;
    public editDOB:Date;
    public editdegree:string;

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

    //List of Approved courses
    courseList:Course[];


  constructor(private instructorService:InstructorService, private router:Router) { }

  ngOnInit(): void {

    //Perform auth check first?

    this.instid = Number(sessionStorage.getItem("id"));
    this.firstName = sessionStorage.getItem("First Name");
    this.lastName = sessionStorage.getItem("Last Name");
    this.phoneNumber = sessionStorage.getItem("Phone Number");
    this.address = sessionStorage.getItem("Address");
    this.DOB = sessionStorage.getItem("DOB");
    this.degree = sessionStorage.getItem("Degree");

    this.getMyActiveCourses();

  }

  registerCourse(): void{

    this.instructorId = this.instid;
    let instructor = new Instructor(this.instid, null, null, null, null, null, null, null, null, null, null);
    let course = new Course(0, instructor, this.hours, this.price, this.title, this.description, 1, null, null);


    this.instructorService.registerCourse(course)
    .subscribe(
      result =>{

      },
      error =>{

      }
    );
  }

  editInfo(): void{

    let date = new Date(this.editDOB).getTime();
    let instructor = new Instructor(this.instid, null, this.editfirstName, this.editlastName, this.editphoneNumber, 
      this.editaddress, date, this.editdegree, null, null, null);

    this.instructorService.editInfo(instructor)
    .subscribe(
      result =>{

        this.populateSessionStorage();

      },
      error =>{

      }
    );

  }

  populateSessionStorage():void{

        //sessionStorage.setItem("id", this.editid);
        sessionStorage.setItem("First Name", this.editfirstName);
        sessionStorage.setItem("Last Name", this.editlastName);
        sessionStorage.setItem("Address", this.editaddress);
        sessionStorage.setItem("Phone Number", this.editphoneNumber);
        sessionStorage.setItem("DOB", new Date(this.editDOB).toString());
        sessionStorage.setItem("Degree", this.editdegree);
        //sessionStorage.setItem("Type", "Instructor");

        //reinitialize
        this.instid = Number(sessionStorage.getItem("id"));
        this.firstName = sessionStorage.getItem("First Name");
        this.lastName = sessionStorage.getItem("Last Name");
        this.phoneNumber = sessionStorage.getItem("Phone Number");
        this.address = sessionStorage.getItem("Address");
        this.DOB = sessionStorage.getItem("DOB");
        this.degree = sessionStorage.getItem("Degree");
  }

  getMyActiveCourses():void{

    let date = new Date(this.DOB).getTime();
    let instructor = new Instructor(this.instid, null, this.firstName, this.lastName, this.phoneNumber, 
      this.address, date, this.degree, null, null, null);

    this.instructorService.getMyActiveCourses(instructor)
      .subscribe(
        result =>{
          this.courseList = result;
          console.log(this.courseList);
        },
        error =>{

        }
      )
  }

}
