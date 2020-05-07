import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  

coursesList

  constructor(private http:HttpClient) { }

  getCourses():Observable<Course[]>{
    // return this.coursesList
    return this.http.get('http://localhost:8080/BrightMinds/course/listOfCourse')as Observable<Course[]>;
  }

  payment(courseid,studentid,price):Observable<any>{
    // return this.coursesList
    return this.http.get('http://localhost:8080/BrightMinds/course/pay?courseid='+courseid+"&&studentid="+studentid+"&&price="+price)as Observable<any>;
  }

   
  
}
