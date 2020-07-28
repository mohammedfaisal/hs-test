package com.app.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ems.model.AttendanceLogDto;

/**
 * AttendanceLogDtoRepository
 * 
 * @author Mohammed.Faisal
 */
@Repository
public interface AttendanceLogDtoRepository extends JpaRepository<AttendanceLogDto, Integer> {

}
