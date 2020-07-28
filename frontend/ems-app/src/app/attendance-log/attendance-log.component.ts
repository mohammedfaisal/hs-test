import { Component, OnInit } from '@angular/core';
import { AttendanceService } from '../attendance.service';
import { AttendanceLog } from '../attendance-log';

@Component({
  selector: 'app-attendance-log',
  templateUrl: './attendance-log.component.html',
  styleUrls: ['./attendance-log.component.css']
})
export class AttendanceLogComponent implements OnInit {

  logs: AttendanceLog[];

  constructor(
    private attendanceService: AttendanceService
  ) { }

  ngOnInit(): void {
    this.getLogs();
  }

  getLogs(): void {
    this.attendanceService.getLogs().subscribe(logs => this.logs = logs);
  }

}
