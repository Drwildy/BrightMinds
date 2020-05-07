import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DashboardService } from 'src/app/services/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  courseid:string
  
  constructor(private activatedRoute: ActivatedRoute, private dashboardservice:DashboardService) { 
    this.activatedRoute.queryParams.subscribe(parms=>{
     
      this.courseid=parms.courseid
      
      console.log(parms);
      
    })
  }
  ngOnInit(): void {
  }

  getStudentInfo(courseid){
    this.dashboardservice.getStudentInfo(this.courseid).subscribe(result=>{
      console.log("xyz:",result)
  })

}
}