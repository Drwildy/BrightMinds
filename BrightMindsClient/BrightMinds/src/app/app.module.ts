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
import { FindClassesComponent } from './find-classes/find-classes.component';
import { CourseregistrationComponent } from './components/courseregistration/courseregistration.component';

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
    FindClassesComponent,
    CourseregistrationComponent
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
