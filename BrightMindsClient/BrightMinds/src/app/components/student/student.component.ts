import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';
import { User } from 'src/app/models/User';
import { Student } from 'src/app/models/Student';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  lastName:string;
  firstName:string;
  address:string;
  phoneNumber:string;
  id:number;

 // user=new User(1,null,"zulikha","Password123",1,1588786085912,1588786085912);
  student:Student
  constructor(private studentService:StudentService) { }

  ngOnInit(): void {
    this.lastName=sessionStorage.getItem('Last Name')
    this.firstName=sessionStorage.getItem('First Name')
    this.address=sessionStorage.getItem('Address')
    this.phoneNumber=sessionStorage.getItem('Phone Number')
    this.id=Number.parseInt(sessionStorage.getItem('id'))
    
   // this.studentService.getStudent(this.user).subscribe(result=>this.student=result)
    console.log("studnent",this.student);
    

  }

}
