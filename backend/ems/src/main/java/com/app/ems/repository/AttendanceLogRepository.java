package com.app.ems.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.ems.model.AttendanceLog;

/**
 * AttendanceLogRepository
 * 
 * @author Mohammed.Faisal
 *
 */
@Repository
public interface AttendanceLogRepository extends JpaRepository<AttendanceLog, Integer> {
	
	/**
	 * Find Log
	 * 
	 * @param employeeId
	 * @param attendanceDate
	 * @return
	 */
	public AttendanceLog findOneByEmployeeIdAndAttendanceDate(Integer employeeId, LocalDate attendanceDate);
	
	/**
	 * Update total duration
	 * 
	 * @param attendanceId
	 */
	@Modifying
	@Query(
		value = "update attendance_log set duration = (select sum(duration) from attendance_log_entry where attendance_id = :attendanceId) where id = :attendanceId",
		nativeQuery = true)
	public void computeDuration(@Param("attendanceId") Integer attendanceId);
	
	/**
	 * Delete by employeeId
	 * 
	 * @param employeeId
	 */
	@Modifying
	@Query(
		value = "delete from attendance_log where employee_id = :employeeId",
		nativeQuery = true)
	public void deleteByEmployeeId(@Param("employeeId") Integer employeeId);
	
}
