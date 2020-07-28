package com.app.ems.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Attendance Log Entry
 * 
 * @author Mohammed.Faisal
 */
@Entity
@Table(name = "attendance_log_entry")
public class AttendanceLogEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer attendanceId;
	private LocalDateTime punchIn;
	private LocalDateTime punchOut;
	private Integer duration;
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}
	public LocalDateTime getPunchIn() {
		return punchIn;
	}
	public void setPunchIn(LocalDateTime punchIn) {
		this.punchIn = punchIn;
	}
	public LocalDateTime getPunchOut() {
		return punchOut;
	}
	public void setPunchOut(LocalDateTime punchOut) {
		this.punchOut = punchOut;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AttendanceLogEntry [id=" + id + ", attendanceId=" + attendanceId + ", punchIn=" + punchIn
				+ ", punchOut=" + punchOut + ", duration=" + duration + ", status=" + status + "]";
	}
}
