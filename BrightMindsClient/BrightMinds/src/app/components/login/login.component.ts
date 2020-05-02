import { Component, OnInit } from '@angular/core';

import { LoginService } from '../../services/login.service';

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

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  public login(): void{
    //let myUser = {userName: this.userName, password: this.password};
    this.loginService.login(this.username, this.password)
      .subscribe(
        result =>{
          if (1 == 1){

          }
          else if(2 == 2){

          }
          else if(3 == 3){

          }
          else{
            //Do nothing
          }
        },
        error => {
          console.log(error);
          this.bad = true;
        }
      );
  }

}
