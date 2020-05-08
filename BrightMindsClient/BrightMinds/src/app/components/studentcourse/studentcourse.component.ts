import { Component, OnInit, Input } from '@angular/core';
import { Course } from 'src/app/models/course';

@Component({
  selector: 'app-studentcourse',
  templateUrl: './studentcourse.component.html',
  styleUrls: ['./studentcourse.component.css']
})
export class StudentcourseComponent implements OnInit {

  @Input() courseinfo:Course
  constructor() { }

  ngOnInit(): void {
  }

}
