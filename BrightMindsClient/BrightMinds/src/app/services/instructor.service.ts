import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';


import { Course } from '../models/Course';
import { Instructor } from '../models/Instructor';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {

  constructor(private http:HttpClient) { }

  httpOptions = { 
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  registerCourse(course:Course){

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

    return this.http.post('http://localhost:8080/BrightMinds/course/registerCourse', body, {headers:headers});

  }


  editInfo(instructor: Instructor){

    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: instructor.id,
      userid: instructor.userId,
      firstName: instructor.firstName,
      lastName: instructor.lastName,
      address: instructor.address,
      phoneNumber: instructor.phoneNumber,
      dateOfBirth: instructor.DOB,
      degree: instructor.degree,
      status: instructor.status,
      createdAt: instructor.createdAt,
      updatedAt: instructor.createdAt
    })   

    return this.http.post('http://localhost:8080/BrightMinds/instructor/editInfo', body, {headers:headers});

  }
}
