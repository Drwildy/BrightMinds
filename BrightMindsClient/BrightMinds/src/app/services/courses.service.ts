import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  

coursesList:Course[]=[
  {
      "id": 1,
      "instructorId": null,
      "hours": 2,
      "price": 22.0,
      "description": "something",
      "status": 1,
      "createdAt": null,
      "updatedAt": null
  },
  {
      "id": 2,
      "instructorId": null,
      "hours": 1,
      "price": 122.0,
      "description": "Java programming language",
      "status": 1,
      "createdAt": null,
      "updatedAt": null
  },
  {
      "id": 3,
      "instructorId": null,
      "hours": 1,
      "price": 122.0,
      "description": "Advanced Java programming language",
      "status": 1,
      "createdAt": null,
      "updatedAt": null
  }
]

  constructor(private http:HttpClient) { }

  getCourses():Course[]{
    // return this.coursesList
    this.getCoursesFromServer().subscribe((courses)=>{this.coursesList=courses})
    return this.coursesList
  }
  getCoursesFromServer():Observable<Course[]>{
    return this.http.get<Course[]>("http://localhost:8080/BrightMinds/course/listOfCourse")
  }
}
