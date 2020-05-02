import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { User } from '../models/User';
import { Student } from '../models/Student';
import { Instructor } from '../models/Instructor';
import { Admin } from '../models/Admin';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(username:string, password:string): Observable<User>{
    return this.http.get('http://localhost:8080/Brightminds/loginorsomethingwhoknows') as Observable<User>
  }

  getStudent() :Observable<Student>{
    return this.http.get('somethingInHere') as Observable<Student>
  }

  getInstructor() :Observable<Instructor>{
    return this.http.get('somethingInHere') as Observable<Student>
  }

  getAdmin() :Observable<Admin>{
    return this.http.get('somethingInHere') as Observable<Admin>
  }


}
