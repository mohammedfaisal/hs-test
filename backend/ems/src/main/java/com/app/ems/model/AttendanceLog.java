package com.app.ems.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Attendance Log
 * 
 * @author Mohammed.Faisal
 */
@Entity
@Table(name = "attendance_log")
public class AttendanceLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer employeeId;
	private LocalDate attendanceDate;
	private Integer duration;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(LocalDate date) {
		this.attendanceDate = date;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "AttendanceLog [id=" + id + ", employeeId=" + employeeId + ", attendanceDate=" + attendanceDate + ", duration=" + duration
				+ "]";
	}
}
