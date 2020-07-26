package com.app.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ems.model.Employee;
import com.app.ems.service.EmployeeService;

/**
 * Employee Controller
 * 
 * @author Mohammed.Faisal
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public String home() {
		return "EMS APP";
	}
	
	/**
	 * Get Employee
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Employee get(@PathVariable Integer id) {
		return employeeService.get(id);
	}
	
	/**
	 * Get all Employees
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Employee> getAll(){
		return employeeService.getAll(); 
	}
	
	/**
	 * Save Employee
	 * @param employee
	 * @return
	 */
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	/**
	 * Delete Employee
	 * 
	 * @param id
	 */
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		employeeService.delete(id);
	}
}
