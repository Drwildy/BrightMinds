import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { CourselistComponent } from './components/courselist/courselist.component';
import { InstructorComponent } from './components/instructor/instructor.component';
import { StudentComponent } from './components/student/student.component';
import { FindClassesComponent } from './find-classes/find-classes.component';
import { CourseregistrationComponent } from './components/courseregistration/courseregistration.component';



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
    component: InstructorComponent,
    path: "instructor"
  },
  {
    component: StudentComponent,
    path: "student"
  },
  {
    component: FindClassesComponent,
    path: "find-classes"
  },
  {
    path: "courseregistration",
    component: CourseregistrationComponent
  }
]


@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
