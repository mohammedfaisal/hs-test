package com.app.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.ems.model.AttendanceLogEntry;

/**
 * AttendanceLogEntryRepository
 * 
 * @author Mohammed.Faisal
 */
@Repository
public interface AttendanceLogEntryRepository extends JpaRepository<AttendanceLogEntry, Integer>{
	
	/**
	 * Find by attendanceId
	 * 
	 * @param attendanceId
	 * @return
	 */
	public List<AttendanceLogEntry> findByAttendanceId(Integer attendanceId);
	
	/**
	 * Find AttendanceLogEntry
	 * 
	 * @param attendanceId
	 * @param status
	 * @return
	 */
	@Query(
		value = "select * from attendance_log_entry where attendance_id = :attendanceId and status = :status order by punch_in desc limit 1",
		nativeQuery = true)
	public AttendanceLogEntry findEntry(@Param("attendanceId") Integer attendanceId, @Param("status") Integer status);	
	
	/**
	 * Delete Entries
	 * 
	 * @param employeeId
	 */
	@Modifying
	@Query(
		value = "delete from attendance_log_entry where attendance_id = (select id from attendance_log where employee_id = :employeeId)",
		nativeQuery = true)
	public void deleteByEmployeeId(@Param("employeeId") Integer employeeId);
}
