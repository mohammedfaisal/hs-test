import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { from } from 'rxjs';
import { EmployeeRegistrationComponent } from './employee-registration/employee-registration.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { AttendanceLogComponent } from './attendance-log/attendance-log.component';
import { AttendanceStatusPipe } from './attendance-status.pipe';
import { AttendanceDurationPipe } from './attendance-duration.pipe';
import { AttendanceLogEntryComponent } from './attendance-log-entry/attendance-log-entry.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeRegistrationComponent,
    EmployeeDashboardComponent,
    AttendanceLogComponent,
    AttendanceStatusPipe,
    AttendanceDurationPipe,
    AttendanceLogEntryComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
