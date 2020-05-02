import { Component, OnInit } from '@angular/core';

import { RegisterService } from '../../services/register.service';
import { CustomValidators } from './custom-validators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Student } from 'src/app/models/Student';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public formRegister:FormGroup;
  public username:string;
  public password:string;
  public firstName:string;
  public lastName:string;
  public phoneNumber:string;
  public address:string;
  public DOB:Date;


  public length:boolean = false;
  public upper:boolean = false;
  public lower:boolean = false;
  public number:boolean = false;
  public duplicate:boolean = false;

  constructor(private registerService:RegisterService, private fb:FormBuilder, private router:Router) {
    this.formRegister = this.createRegisterForm();
   }

  ngOnInit(): void {}

  createRegisterForm(): FormGroup {
    return this.fb.group(
      {
        password: [
          null,
          Validators.compose([
            Validators.required,
            // check whether the entered password has a number
            CustomValidators.patternValidator(/\d/, {
              hasNumber: true
            }),
            // check whether the entered password has upper case letter
            CustomValidators.patternValidator(/[A-Z]/, {
              hasCapitalCase: true
            }),
            // check whether the entered password has a lower case letter
            CustomValidators.patternValidator(/[a-z]/, {
              hasSmallCase: true
            }),
            // check whether the entered password has a special character

            //Add if you want special character check
            /*CustomValidators.patternValidator(
              /[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/,
              {
                hasSpecialCharacters: true
              }
            ),
            */
            Validators.minLength(8)
          ])
        ],
        confirmPassword: [null, Validators.compose([Validators.required])]
      },
      {
        // check whether our password and confirm password match
        validator: CustomValidators.passwordMatchValidator
      }
    );
  }

  register(){
    let student:Student = {};
    //Do Registering stuff here
  }

}
