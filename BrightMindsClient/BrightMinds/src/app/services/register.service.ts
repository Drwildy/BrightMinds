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

    //console.log(student);

    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: student.getId(),
      userid: student.getUserId(),
      firstName: student.getFirstName(),
      lastName: student.getLastName(),
      phoneNumber: student.getPhoneNumber(),
      address: student.getAddress(),
      dateOfBirth: student.getDOB(),
      status: student.getStatus(),
      createdAt: student.getCreatedAt(),
      updatedAt: student.getUpdatedAt()
    })   

    //console.log(body);

    return this.http.post('http://localhost:8080/BrightMinds/student/register', body, {headers: headers});
  }

  //Add Observable
  register(user: User): Observable<User>{    
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: user.getId(),
      typeid: user.getTypeId(),
      username: user.getUsername(),
      password: user.getPassword(),
      status: user.getStatus(),
      createdAt: user.getCreatedAt(),
      updatedAt: user.getUpdatedAt()
    })

    //console.log(body);

    return this.http.post<User>('http://localhost:8080/BrightMinds/user/register', body, {headers: headers});
  }
}
