import { Component, OnInit, Input } from '@angular/core';
import { Course } from 'src/app/models/course';
import { Router, ActivatedRoute } from '@angular/router';
import { Instructor } from 'src/app/models/Instructor';
import { CoursesService } from 'src/app/services/courses.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  @Input() courseinfo:Course

  //display validation
  public type: string;
  public edit: boolean = false;
  
  public id: number;
  public instructorid: Instructor;
  public title: string;
  public hours: number;
  public price: number;
  public description: string;

  public editid: number;
  public editinstructorid: Instructor;
  public edittitle: string;
  public edithours: number;
  public editprice: number;
  public editdescription: string;

  public course: Course;

  constructor(private acRouter: ActivatedRoute, private courseService:CoursesService, private router: Router) {

    this.acRouter.queryParams.subscribe( 
      params =>{
        this.id = params["id"];

      }
    )
   }

  ngOnInit(): void {

    this.type = sessionStorage.getItem("Type");

    if(this.type === "Student" || this.type === "Instructor"){
      this.getCourseById(this.id);
    }else{
      this.router.navigate([""]);
    }

  }

  getCourseById(id:number){

    this.courseService.getCourseById(id).subscribe(
      result =>{
        this.instructorid = result.instructorId;
        this.title = result.title;
        this.hours = result.hours;
        this.description = result.description;
        this.price = result.price;
      },
      error =>{

      }
    )
  }

  editInfo():void{
    if(this.edit == true){
      this.edit = false;
    } else {
      this.edit = true;
    }
  }

  editCourseInfo():void{
   // console.log("update course info");

    let course = new Course(this.id, this.instructorid, this.edithours, this.editprice, this.edittitle, this.editdescription, 2, null, null);

    this.courseService.editCourseInfo(course).subscribe(
      result =>{

        this.title = this.edittitle;
        this.hours = this.edithours;
        this.price = this.editprice;
        this.description = this.editdescription;

        this.edit=false;
      },
      error =>{

      }
    )
  }

  addUnit():void {

  }

}
