import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent} from './employee-list/employee-list.component';
import { EmployeeRegistrationComponent} from './employee-registration/employee-registration.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { AttendanceLogComponent } from './attendance-log/attendance-log.component';
import { AttendanceLogEntryComponent } from './attendance-log-entry/attendance-log-entry.component';

const routes: Routes = [
  {path: '', component:EmployeeListComponent},
  {path: 'employee/list', component:EmployeeListComponent},
  {path: 'employee/dashboard/:id', component: EmployeeDashboardComponent},
  {path: 'employee/view', component:EmployeeRegistrationComponent},
  {path: 'employee/view/:id', component:EmployeeRegistrationComponent},
  {path: 'attendance/report', component:AttendanceLogComponent},
  {path: 'attendance/report/:id', component:AttendanceLogComponent},
  {path: 'attendance/subreport/:id', component:AttendanceLogEntryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
