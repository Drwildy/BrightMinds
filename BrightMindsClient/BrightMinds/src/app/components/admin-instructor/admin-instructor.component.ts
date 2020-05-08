import { Component, OnInit } from '@angular/core';
import { Instructor } from '../../models/instructor';
import { InstructorService } from '../../services/instructor.service';

@Component({
  selector: 'app-admin-instructor',
  templateUrl: './admin-instructor.component.html',
  styleUrls: ['./admin-instructor.component.css']
})
export class AdminInstructorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  newInstructor(): void{
    
  }

}
