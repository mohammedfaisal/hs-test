package com.app.ems.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.ems.model.AttendanceLog;
import com.app.ems.model.AttendanceLogDto;
import com.app.ems.model.AttendanceLogEntry;
import com.app.ems.model.AttendanceLogEntryStatus;
import com.app.ems.repository.AttendanceLogDtoRepository;
import com.app.ems.repository.AttendanceLogEntryRepository;
import com.app.ems.repository.AttendanceLogRepository;

/**
 * Attendance Service Implementation
 * 
 * @author Mohammed.Faisal
 */
@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);
	
	@Autowired
	private AttendanceLogRepository attendanceLogRepository;

	@Autowired
	private AttendanceLogDtoRepository attendanceLogDtoRepository;
	
	@Autowired
	private AttendanceLogEntryRepository attendanceLogEntryRepository;

	@Override
	public void postAttendance(Integer employeeId) {
		
		AttendanceLog log = new AttendanceLog();
		log.setAttendanceDate(LocalDate.now());
		log.setEmployeeId(employeeId);
		
		// find log for the employee for current date
		Optional<AttendanceLog> record = attendanceLogRepository.findOne(Example.of(log));
		
		// if no log exists for the employee for current date
		if(!record.isPresent()) {
			postLog(employeeId);
			return;
		}else {
			// when log exists for the employee for current date
			log = record.get();
			
			// find in-only entry
			AttendanceLogEntry inOnlyEntry = attendanceLogEntryRepository.findEntry(log.getId(), AttendanceLogEntryStatus.IN_ONLY.getValue());
			
			if(inOnlyEntry == null) {
				postInOnlyEntry(log.getId());
			}else {
				postInOutEntry(inOnlyEntry);
			}
		}
	}
	
	/**
	 * Post Attendance Log
	 * 
	 * @param employeeId
	 */
	private void postLog(Integer employeeId) {
		
		AttendanceLog attendance = new AttendanceLog();
		attendance.setAttendanceDate(LocalDate.now());
		attendance.setEmployeeId(employeeId);
		attendance.setDuration(0);
		
		//post attendance
		logger.info("Saving attendance : {}", attendance.toString());
		attendanceLogRepository.save(attendance);
		
		// post in-only entry
		postInOnlyEntry(attendance.getId());
	}
	
	/**
	 * Post In-Only Entry
	 * 
	 * @param attendanceId
	 */
	private void postInOnlyEntry(Integer attendanceId) {
		
		AttendanceLogEntry inOnlyEntry = new AttendanceLogEntry();
		inOnlyEntry.setAttendanceId(attendanceId);
		inOnlyEntry.setDuration(0);
		inOnlyEntry.setPunchIn(LocalDateTime.now());
		inOnlyEntry.setStatus(AttendanceLogEntryStatus.IN_ONLY.getValue());
		
		//post in-only entry
		logger.info("Saving in-only attendance entry : {}", inOnlyEntry.toString());
		attendanceLogEntryRepository.save(inOnlyEntry);
	}
	
	/**
	 * Post In-Out Entry
	 * 
	 * @param inOnlyEntry
	 */
	private void postInOutEntry(AttendanceLogEntry inOnlyEntry) {
		
		inOnlyEntry.setPunchOut(LocalDateTime.now());
		inOnlyEntry.setDuration(computeDuration(inOnlyEntry.getPunchIn(), inOnlyEntry.getPunchOut()));
		inOnlyEntry.setStatus(AttendanceLogEntryStatus.IN_OUT.getValue());
		
		//post in-out entry
		logger.info("Saving in-out attendance entry : {}", inOnlyEntry.toString());
		attendanceLogEntryRepository.save(inOnlyEntry);
		
		// compute attendance total duration
		attendanceLogRepository.computeDuration(inOnlyEntry.getAttendanceId());
		
	}
	
	/**
	 * Compute Punch Duration
	 * 
	 * @param punchIn
	 * @param punchOut
	 * @return
	 */
	private int computeDuration(LocalDateTime punchIn, LocalDateTime punchOut) {
		Duration duration = Duration.between(punchIn, punchOut);
		return (int) duration.getSeconds();
				
	}

	@Override
	public List<AttendanceLogEntry> getAttendanceEntries(Integer employeeId, LocalDate date) {
		AttendanceLog attendance = attendanceLogRepository.findOneByEmployeeIdAndAttendanceDate(employeeId, date);
		if(attendance != null) {
			return attendanceLogEntryRepository.findByAttendanceId(attendance.getId());
		}else {
			return Collections.emptyList();
		}
	}

	@Override
	public List<AttendanceLogDto> getAllAttendanceLogs() {
		return attendanceLogDtoRepository.findAll();
	}

	@Override
	public List<AttendanceLogEntry> getAttendanceEntries(Integer attendanceId) {
		return attendanceLogEntryRepository.findByAttendanceId(attendanceId);
	}

	@Override
	public AttendanceLogDto get(Integer attendanceId) {
		Optional<AttendanceLogDto> record = attendanceLogDtoRepository.findById(attendanceId);
		return record.isPresent() ? record.get() : null;
	}
}
