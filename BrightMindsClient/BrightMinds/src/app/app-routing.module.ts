import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { CourselistComponent } from './components/courselist/courselist.component';
import { InstructorComponent } from './components/instructor/instructor.component';
import { StudentComponent } from './components/student/student.component';
//import { FindClassesComponent } from './components/find-classes.component';
import { CourseregistrationComponent } from './components/courseregistration/courseregistration.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { StudentcourseComponent } from './components/studentcourse/studentcourse.component';

import { CourseComponent } from './components/course/course.component';



const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    component: LoginComponent,
    path: "login"
  },
  {
    component: RegisterComponent,
    path: "register"
  },
  {
    component: ForgotPasswordComponent,
    path: "forgotPassword"
  },
  {
    component: CourselistComponent,
    path: "courses"
  },
  {
    component: CourseComponent,
    path: "course"
  },
  {
    component: InstructorComponent,
    path: "instructor"
  },
  {
    component: StudentComponent,
    path: "student"
  },
  // {
  //   component: FindClassesComponent,
  //   path: "find-classes"
  // },
  {
    path: "courseregistration",
    component: CourseregistrationComponent
  },
  {
    path:"dashboard",
    component: DashboardComponent
  },
  {
    path:"studentcourse",
    component: StudentcourseComponent
  }

]


@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
