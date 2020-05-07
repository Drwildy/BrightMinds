import { Component, OnInit } from '@angular/core';

import { LoginService } from '../../services/login.service';
import { User } from '../../models/User';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username:string;
  public password:string;
  public succeeded:string;
  public bad:boolean = false;

  //public var:string;

  public user:User;

  constructor(private loginService: LoginService, private router:Router) { }

  ngOnInit(): void {

      //this.var = sessionStorage.getItem("id");
  }

  public login(): void{
    this.loginService.login(this.username, this.password)
      .subscribe(
        result => {
          if(result == null){
            this.bad = true;
          }else if( result.typeid.type == "Student"){
            
            this.getStudent(result);
          
          }else if( result.typeid.type == "Instructor"){
            
            this.getInstructor(result);
          
          }else if( result.typeid.type == "Admin"){
            
            this.getAdmin(result);

          }else{

            console.log("Just what the hell are you?");
            this.bad = true;

          }
        },
        error => {
          console.log(error);
          this.bad = true;
        }
      );
  }

  public getStudent(user: User){
    this.loginService.getStudent(user)
      .subscribe(
        result =>{
          //Add some sessionVariables
          sessionStorage.setItem("id", result.id.toString());
          sessionStorage.setItem("First Name", result.firstName.toString());
          sessionStorage.setItem("Last Name", result.lastName.toString());
          sessionStorage.setItem("Address", result.address.toString());
          sessionStorage.setItem("Phone Number", result.phoneNumber.toString());
          sessionStorage.setItem("Type", "Student");

          //this.var = sessionStorage.getItem("id");

          //Do some navigating to your Student page here.
          this.router.navigate(['/student']);
          
        },
        error =>{
          console.log(error);
          this.bad = true;
        }
      )
  }

  public getInstructor(user: User){
    this.loginService.getInstructor(user)
    .subscribe(
      result =>{

        //Add some sessionVariables
        sessionStorage.setItem("id", result.id.toString());
        sessionStorage.setItem("First Name", result.firstName.toString());
        sessionStorage.setItem("Last Name", result.lastName.toString());
        sessionStorage.setItem("Address", result.address.toString());
        sessionStorage.setItem("Phone Number", result.phoneNumber.toString());
        sessionStorage.setItem("DOB", new Date(result.DOB).toString());
        sessionStorage.setItem("Degree", result.degree);
        sessionStorage.setItem("Type", "Instructor");

        //Do some navigating to your Student page here.
        this.router.navigate(['instructor']);
      },
      error =>{
        console.log(error);
        this.bad = true;
      }
    )
  }

  public getAdmin(user: User){
    this.loginService.getAdmin(user)
    .subscribe(
      result =>{
         //Add some sessionVariables
         sessionStorage.setItem("id", result.id.toString());
         sessionStorage.setItem("First Name", result.firstName.toString());
         sessionStorage.setItem("Last Name", result.lastName.toString());
         sessionStorage.setItem("Type", "Admin");
 
         //Do some navigating to your Student page here.
         //this.router.navigate(['admin']);
      },
      error =>{
        console.log(error);
        this.bad = true;
      }
    )
  }

}
