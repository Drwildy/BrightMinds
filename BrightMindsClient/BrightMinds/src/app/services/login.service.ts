import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

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

    let user = new User(0, null, username, password, 0, 1, 1);

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

    return this.http.post<User>('http://localhost:8080/BrightMinds/user/login', body, {headers: headers});
  }

  getStudent(user:User): Observable<Student>{
   
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: user.id,
      typeid: user.typeid,
      username: user.username,
      password: user.password,
      status: user.status,
      createdAt: user.createdAt,
      updatedAt: user.updatedAt
    })
    return this.http.post<Student>('http://localhost:8080/BrightMinds/student/getStudent', body, {headers: headers});
  }

  getInstructor(user:User) :Observable<Instructor>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: user.id,
      typeid: user.typeid,
      username: user.username,
      password: user.password,
      status: user.status,
      createdAt: user.createdAt,
      updatedAt: user.updatedAt
    })

    return this.http.post<Instructor>('http://localhost:8080/BrightMinds/instructor/getInstructor', body, {headers: headers});
  }

  getAdmin(user:User) :Observable<Admin>{

    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: user.id,
      typeid: user.typeid,
      username: user.username,
      password: user.password,
      status: user.status,
      createdAt: user.createdAt,
      updatedAt: user.updatedAt
    })

    return this.http.post<Admin>('http://localhost:8080/BrightMinds/admin/getAdmin', body, {headers: headers});
  }


}
