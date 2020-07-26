package com.app.ems.service;

import java.util.List;

import com.app.ems.model.Employee;

/**
 * Employee Service
 * 
 * @author Mohammed.Faisal
 */
public interface EmployeeService {
	
	/**
	 * Get Employee
	 * 
	 * @param id
	 * @return
	 */
	public Employee get(Integer id);
	
	/**
	 * Get all employees
	 * 
	 * @return
	 */
	public List<Employee> getAll();
	
	/**
	 * Save Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Integer save(Employee employee);
	
	/**
	 * Delete Employee
	 * 
	 * @param id
	 */
	public void delete(Integer id);
}
