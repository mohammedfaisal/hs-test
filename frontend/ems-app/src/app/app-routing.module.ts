import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent} from './employee-list/employee-list.component';
import { EmployeeRegistrationComponent} from './employee-registration/employee-registration.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';

const routes: Routes = [
  {path: 'employee/list', component:EmployeeListComponent},
  {path: 'employee/dashboard/:id', component: EmployeeDashboardComponent},
  {path: 'employee/view', component:EmployeeRegistrationComponent},
  {path: 'employee/view/:id', component:EmployeeRegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
