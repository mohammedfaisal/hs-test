package com.app.ems.service;

import java.time.LocalDate;
import java.util.List;

import com.app.ems.model.AttendanceLogDto;
import com.app.ems.model.AttendanceLogEntry;

/**
 * AttendanceService
 * 
 * @author Mohammed.Faisal
 */
public interface AttendanceService {
	
	/**
	 * Post Attendance
	 * 
	 * @param employeeId
	 */
	public void postAttendance(Integer employeeId);
	
	/**
	 * Get all attendance logs
	 * 
	 * @return
	 */
	public List<AttendanceLogDto> getAllAttendanceLogs();
	
	/**
	 * Get Attendance
	 * 
	 * @param attendanceId
	 * @return
	 */
	public AttendanceLogDto get(Integer attendanceId);
	
	/**
	 * Get Attendance Entries
	 * 
	 * @param employeeId
	 * @param date
	 * @return
	 */
	public List<AttendanceLogEntry> getAttendanceEntries(Integer employeeId, LocalDate date);
	
	/**
	 * Get Attendance Entries
	 * 
	 * @param attendanceId
	 * @return
	 */
	public List<AttendanceLogEntry> getAttendanceEntries(Integer attendanceId);
}
