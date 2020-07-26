package com.app.ems.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ems.model.Employee;
import com.app.ems.repository.EmployeeRepository;

/**
 * Employee Service Implementation
 * 
 * @author Mohammed.Faisal
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee get(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.isPresent() ? employee.get() : null;
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Integer save(Employee employee) {
		logger.debug("Saving employee : {}", employee.toString()); 
		Integer pk = employeeRepository.save(employee).getId();
		logger.debug("Employee saved with ID : {}", pk);
		return pk;
	}

	@Override
	public void delete(Integer id) {
		logger.debug("Deleting employee : {}", id);
		employeeRepository.deleteById(id);
		logger.debug("Employee : {} deleted", id);
	}
}
