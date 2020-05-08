import { Injectable } from '@angular/core';
import { User } from '../models/User';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  update(student:Student){

    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: student.id,
      userid: student.userId,
      firstName: student.firstName,
      lastName: student.lastName,
      address: student.address,
      phoneNumber: student.phoneNumber,
      dateOfBirth: student.DOB,
      status: student.status,
      createdAt: student.createdAt,
      updatedAt: student.createdAt
    })   

    return this.http.post('http://localhost:8080/BrightMinds/student/update', body, {headers:headers});

  }




}
