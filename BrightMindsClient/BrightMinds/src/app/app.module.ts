import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';

import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { RegisterComponent } from './components/register/register.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { CourseComponent } from './components/course/course.component';
import { CourselistComponent } from './components/courselist/courselist.component';
import { InstructorComponent } from './components/instructor/instructor.component';
import { StudentComponent } from './components/student/student.component';
import { CourseregistrationComponent } from './components/courseregistration/courseregistration.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { StudentcourseComponent } from './components/studentcourse/studentcourse.component';
import { IndexComponent } from './components/index/index.component';
import { AdminCourseManageComponent } from './components/admin-course-manage/admin-course-manage.component';
import { AdminInstructorComponent } from './components/admin-instructor/admin-instructor.component';
import { TbarComponent } from './components/tbar/tbar.component';
import { IndexFooterComponent } from './components/index-footer/index-footer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ForgotPasswordComponent,
    CourseComponent,
    CourselistComponent,
    InstructorComponent,
    StudentComponent,
    CourseregistrationComponent,
    DashboardComponent,
    StudentcourseComponent,
    IndexComponent,
    AdminCourseManageComponent,
    AdminInstructorComponent,
    TbarComponent,
    IndexFooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
