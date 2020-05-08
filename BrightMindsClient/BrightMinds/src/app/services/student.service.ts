import { Injectable } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';
import { Student } from '../models/Student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http:HttpClient) { }

  getStudent(user:User):Observable<Student>{
   return this.http.post('http://localhost:8080/BrightMinds/student/getStudent', user)as Observable<Student>;
    
  }


}
