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

import com.app.ems.model.AttendanceLogDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AttendanceControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGetReport() {
		String url = "http://localhost:" + port + "/ems/attendance/report";
		ResponseEntity<AttendanceLogDto[]> responseEntity = restTemplate.getForEntity(url, AttendanceLogDto[].class);
		List<AttendanceLogDto> report = Arrays.asList(responseEntity.getBody());
		assertFalse(report.isEmpty(), "No attendance logs found");
	}
}
