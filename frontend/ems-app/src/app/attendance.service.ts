import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AttendanceLogEntry } from './attendance-log-entry';
import { AttendanceLog } from './attendance-log';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  private readonly getUrl: string = '/ems/attendance/';
  private readonly postUrl: string = '/ems/attendance/post/';
  private readonly reportUrl: string = '/ems/attendance/report';
  private readonly subReportUrl: string = '/ems/attendance/subreport';
  private readonly getEntriesUrl: string = '/ems/attendance/entries/';

  constructor(private http: HttpClient) { }

  post(employeeId: number): Observable<any> {
    return this.http.post(this.postUrl+employeeId, {});
  }

  getLog(attendanceId: number) : Observable<AttendanceLog> {
    return this.http.get<AttendanceLog>(this.getUrl+attendanceId);
  }

  getLogs(): Observable<AttendanceLog[]> {
    return this.http.get<AttendanceLog[]>(this.reportUrl);
  }

  getEntriesByEmployeeId(employeeId: number): Observable<AttendanceLogEntry[]> {
    return this.http.get<AttendanceLogEntry[]>(this.getEntriesUrl+employeeId);
  }

  getEntriesByAttendanceId(attendanceId: number): Observable<AttendanceLogEntry[]> {
    return this.http.get<AttendanceLogEntry[]>(this.subReportUrl+"?attendanceId="+attendanceId);
  }
}
