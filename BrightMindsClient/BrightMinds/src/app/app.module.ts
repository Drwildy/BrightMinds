import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { TbarComponent } from './components/tbar/tbar.component';
import { IndexComponent } from './components/index/index.component';
import { InstructorComponent } from './components/instructor/instructor.component';
import { CourselistComponent } from './components/courselist/courselist.component';
import { CourseComponent } from './components/course/course.component';
import { AdminCourseManageComponent } from './components/admin-course-manage/admin-course-manage.component';
import { IndexFooterComponent } from './components/index-footer/index-footer.component';
import { IndexInstructorComponent } from './components/index-instructor/index-instructor.component';
import { AdminInstructorComponent } from './components/admin-instructor/admin-instructor.component';


@NgModule({
  declarations: [
    AppComponent,
    TbarComponent,
    IndexComponent,
    InstructorComponent,
    CourselistComponent,
    CourseComponent,
    AdminCourseManageComponent,
    IndexFooterComponent,
    IndexInstructorComponent,
    AdminInstructorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
