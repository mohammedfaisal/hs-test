package com.app.ems.model;

/**
 * AttendanceLogEntryStatus
 * 
 * @author Mohammed.Faisal
 */
public enum AttendanceLogEntryStatus {
	
	IN_ONLY(1),
	IN_OUT(2);
	
	private AttendanceLogEntryStatus(int value) {
		this.value = value;
	}
	
	private int value;

	public int getValue() {
		return value;
	}
	
}
