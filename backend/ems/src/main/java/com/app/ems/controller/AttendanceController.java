package com.app.ems.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ems.model.AttendanceLogDto;
import com.app.ems.model.AttendanceLogEntry;
import com.app.ems.service.AttendanceService;

/**
 * AttendanceController
 * 
 * @author Mohammed.Faisal
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	/**
	 * Get Report
	 * @return
	 */
	@GetMapping("/report")
	public List<AttendanceLogDto> getAll(){
		return attendanceService.getAllAttendanceLogs();
	}
	
	/**
	 * Get Sub Report
	 * @param attendanceId
	 * @return
	 */
	@GetMapping("/subreport")
	public List<AttendanceLogEntry> getEntriesByAttendanceId(@RequestParam("attendanceId") Integer attendanceId){
		return attendanceService.getAttendanceEntries(attendanceId);
	}
	
	/**
	 * Get Attendance
	 * @param attendanceId
	 * @return
	 */
	@GetMapping("/{attendanceId}")
	public AttendanceLogDto get(@PathVariable Integer attendanceId){
		return attendanceService.get(attendanceId);
	}
	
	/**
	 * Get Entries by employeeId
	 * @param employeeId
	 * @return
	 */
	@GetMapping("/entries/{employeeId}")
	public List<AttendanceLogEntry> getEntries(@PathVariable Integer employeeId){
		return attendanceService.getAttendanceEntries(employeeId, LocalDate.now());
	}
	
	/**
	 * Post Attendance
	 * @param employeeId
	 */
	@PostMapping("/post/{employeeId}")
	public void postAttendance(@PathVariable Integer employeeId) {
		attendanceService.postAttendance(employeeId);
	}
	
}
