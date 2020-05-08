import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { NodeWithI18n } from '@angular/compiler'; //What is this david lol

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


  getCourseById(courseId: number): Observable<Course>{ 
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: courseId
    })   

    return this.http.post('http://localhost:8080/BrightMinds/course/getCourseById/', body, {headers:headers})as Observable<Course>;
  }

  editCourseInfo(course: Course){
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const body = JSON.stringify({
      id: course.id,
      instructorid: course.instructorId,
      title: course.title,
      hours: course.hours,
      price: course.price,
      description: course.description,
      status: course.status,
      createdAt: course.createdAt,
      updatedAt: course.createdAt
    })   

    return this.http.post('http://localhost:8080/BrightMinds/course/editInfo', body, {headers:headers});
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
