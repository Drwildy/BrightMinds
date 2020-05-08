import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http:HttpClient) {


  }
  getStudentInfo(id):Observable<any>{
    // return this.coursesList
    return this.http.get('http://localhost:8080/BrightMinds/student/getStudent?id='+ id)as Observable<any>;
   
  
 }
}


