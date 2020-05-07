import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { CourselistComponent } from './components/courselist/courselist.component';
import { InstructorComponent } from './components/instructor/instructor.component';
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
  }
]


@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
