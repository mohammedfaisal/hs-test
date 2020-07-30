package com.app.ems.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.app.ems.model.Employee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGetEmployees() {
		String url = "http://localhost:" + port + "/ems/employee/list";
		ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity(url, Employee[].class);
		List<Employee> employees = Arrays.asList(responseEntity.getBody());
		assertFalse(employees.isEmpty(), "No employees found");
	}

}
