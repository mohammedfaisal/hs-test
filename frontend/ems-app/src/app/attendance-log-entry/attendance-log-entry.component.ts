import { Component, OnInit } from '@angular/core';
import { AttendanceLogEntry } from '../attendance-log-entry';
import { AttendanceService } from '../attendance.service';
import { ActivatedRoute } from '@angular/router';
import { AttendanceLog } from '../attendance-log';

@Component({
  selector: 'app-attendance-log-entry',
  templateUrl: './attendance-log-entry.component.html',
  styleUrls: ['./attendance-log-entry.component.css']
})
export class AttendanceLogEntryComponent implements OnInit {

  attendanceEntries: AttendanceLogEntry[];
  attendance: AttendanceLog;

  constructor(
    private route: ActivatedRoute,
    private attendanceService: AttendanceService
  ) { }

  ngOnInit(): void {
    this.getAttendance();
    this.getEntries();
  }

  getAttendance(): void {
    let attendanceId = this.route.snapshot.paramMap.get("id");
    this.attendanceService.getLog(+attendanceId).subscribe(attendance => this.attendance = attendance);
  }

  getEntries() : void {
    let attendanceId = this.route.snapshot.paramMap.get("id");
    this.attendanceService.getEntriesByAttendanceId(+attendanceId).subscribe(entries => this.attendanceEntries = entries);
  }

}
