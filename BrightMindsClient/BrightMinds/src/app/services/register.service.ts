import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

import { Student } from '../models/Student';
import { User } from '../models/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  httpOptions = { 
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) { }

  registerStudent(student: Student){

    let headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'); //This constructs a new HTTP header
    let body = new HttpParams()
    .append('id', student.getId().toString())
    .append('userId', student.getUserId().toString())
    .append('firstName', student.getFirstName())
    .append('lastName', student.getLastName())
    .append('phoneNumber', student.getPhoneNumber())
    .append('address', student.getAddress())
    .append('DOB', student.getDOB().toString())
    .append('status', student.getStatus().toString())
    .append('createdAt', student.getCreatedAt().toString())
    .append('updatedAt', student.getUpdatedAt().toString());
    console.log(body);

    return this.http.post('http://localhost:8080/BrightMinds/student/register', body, {headers: headers});
  }

  register(user: User){

    console.log(user);
    
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    // let body = new HttpParams()
    // .append('id', user.getId().toString())
    // .set('typeId', user.getTypeId().toString())
    // .set('username', user.getUsername())
    // .set('password', user.getPassword())
    // .set('status', user.getStatus().toString())
    // .set('createdAt', user.getCreatedAt().toString())
    // .set('updatedAt', user.getUpdatedAt().toString());

    const body = JSON.stringify({
      id: user.getId(),
      typeId: user.getTypeId(),
      username: user.getUsername(),
      password: user.getPassword(),
      status: user.getStatus(),
      createdAt: user.getCreatedAt(),
      updatedAt: user.getUpdatedAt()
    })

    console.log(body);

    return this.http.post('http://localhost:8080/BrightMinds/user/register', body, {headers: headers});
  }

  // register(user : User): Observable<User> {
  //   return this.http.post<User>('http://localhost:8080/BrightMinds/user/register', user, this.httpOptions);
  // }


}
