package com.app.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ems.model.Employee;

/**
 * Employee Repository
 * 
 * @author Mohammed.Faisal
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
