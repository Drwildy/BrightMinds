import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

import { Course } from '../models/course';
import { NodeWithI18n } from '@angular/compiler';


@Injectable({
  providedIn: 'root'
})

export class CoursesService {

  constructor(private http:HttpClient) { }

  getCourses():Observable<Course[]>{    
    return this.http.get('http://localhost:8080/BrightMinds/course/listOfCourse') as Observable<Course[]>;
  }

  manageCourse(course:Course, nStatus: number){
    course.status = nStatus;
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: course.id,
      instructorId: course.instructorId,
      hours: course.hours,
      price: course.price,
      title: course.title,
      description: course.description,
      status: course.status,
      createdAt: course.createdAt,
      updatedAt: course.createdAt
    })    

    return this.http.post('http://localhost:8080/BrightMinds/course/manageCourse', body, {headers:headers});
  
  }

}
