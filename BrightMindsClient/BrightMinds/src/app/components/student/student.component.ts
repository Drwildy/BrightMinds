import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';
import { User } from 'src/app/models/User';
import { Student } from 'src/app/models/Student';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  viewMode=true;
  //student info
  public lastName:string;
  public firstName:string;
  public address:string;
  public phoneNumber:string;
  public DOB:string;
  public  id:number;

  //edit info
  public editlastName:string;
  public editfirstName:string;
  public editaddress:string;
  public editphoneNumber:string;
  public editDOB:Date;
  public editid:number;
 

  constructor(private studentService:StudentService,private router:Router)  { }
  ngOnInit(): void {
    debugger
    this.firstName = sessionStorage.getItem("First Name");
    this.lastName = sessionStorage.getItem("Last Name");
    this.phoneNumber = sessionStorage.getItem("Phone Number");
    this.address = sessionStorage.getItem("Address");
    this.id =Number(sessionStorage.getItem("id"));

  }

  update(): void{
      let date = new Date(this.editDOB).getTime();
      let student= new Student(this.editid, null, this.editlastName, this.editfirstName, this.editaddress, this.editphoneNumber, null, null, null, null)
      console.log(student);
 this.studentService.update(student).subscribe(result => {
   this.populateSessionStorage();
 },
 error =>{

 }
 );
}


populateSessionStorage(): void{
debugger
  //sessionStorage.setItem("id", this.editid);
  sessionStorage.setItem("First Name", this.editfirstName);
  sessionStorage.setItem("Last Name", this.editlastName);
  sessionStorage.setItem("Address", this.editaddress);
  sessionStorage.setItem("Phone Number", this.editphoneNumber);
 
     //reinitialize
     this.firstName = sessionStorage.getItem("First Name");
     this.lastName = sessionStorage.getItem("Last Name");
     this.phoneNumber = sessionStorage.getItem("Phone Number");
     this.address = sessionStorage.getItem("Address");
     //this.id = Number(sessionStorage.getItem("id"));
    
}
}