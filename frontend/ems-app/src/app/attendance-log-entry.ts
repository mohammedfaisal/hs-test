export interface AttendanceLogEntry {
    id: number;
	attendanceId: number;
	punchIn: Date;
	punchOut: Date;
	duration: number;
    status: number;
}
