import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './components/index/index.component';
import { CourselistComponent } from './components/courselist/courselist.component';
import { AdminCourseManageComponent } from './components/admin-course-manage/admin-course-manage.component';
import { AdminInstructorComponent } from './components/admin-instructor/admin-instructor.component';

const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full' },
  { path: 'index', component: IndexComponent },
  { path: 'instructor', component: AdminInstructorComponent },
  { path: 'courses', component: CourselistComponent },
  { path: 'coursesmanage', component: AdminCourseManageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
