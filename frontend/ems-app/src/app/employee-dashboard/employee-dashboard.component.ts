import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute } from '@angular/router';
import { AttendanceService} from './../attendance.service';
import { AttendanceLogEntry} from './../attendance-log-entry';

@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {
 
  today: Date;
  totalDuration: number;
  employee: Employee;
  attendanceEntries: AttendanceLogEntry[];

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private attendanceService: AttendanceService
    ) {
      this.totalDuration = 0;
     }

  ngOnInit(): void {
    this.today = new Date();
    this.get();
    this.getAttendanceEntries();
  }

  get(): void{
    let employeeId = this.route.snapshot.paramMap.get("id");
    this.employeeService.get(+employeeId).subscribe(employee => this.employee = employee);
  }

  getAttendanceEntries(): void {
    let employeeId = this.route.snapshot.paramMap.get("id");
    this.attendanceService.getEntriesByEmployeeId(+employeeId).subscribe(entries => {
      this.attendanceEntries = entries;
      this.attendanceEntries.forEach(entry => this.totalDuration += entry.duration);
    });
  }

  postAttendance(): void{
    this.attendanceService.post(this.employee.id).subscribe(result => window.location.reload());
  }
}
