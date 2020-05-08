import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

import { Instructor } from '../models/instructor';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {

  httpOptions = { 
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) { }

  newInstructor(instructor: Instructor){

    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: instructor.getId(),
      userid: instructor.getUserId(),
      firstName: instructor.getFirstName(),
      lastName: instructor.getLastName(),
      phoneNumber: instructor.getPhoneNumber(),
      address: instructor.getAddress(),
      degree: instructor.getDegree(),
      dateOfBirth: instructor.getDOB(),
      status: instructor.getStatus(),
      createdAt: instructor.getCreatedAt(),
      updatedAt: instructor.getUpdatedAt()
    }) 

    return this.http.post('http://localhost:8080/BrightMinds/admin/newInstructor', body, {headers: headers});
  
  }

}
