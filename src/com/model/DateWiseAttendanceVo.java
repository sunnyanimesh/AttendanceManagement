package com.model;

import java.util.Date;

public class DateWiseAttendanceVo {
int attendanceId;
String studentAdmno;
String facultyId;
int subjectId;
Date adate;
char attendance;
String day;


public int getAttendanceId() {
	return attendanceId;
}
public void setAttendanceId(int attendanceId) {
	this.attendanceId = attendanceId;
}
public String getStudentAdmno() {
	return studentAdmno;
}
public void setStudentAdmno(String studentAdmno) {
	this.studentAdmno = studentAdmno;
}
public String getFacultyId() {
	return facultyId;
}
public void setFacultyId(String facultyId) {
	this.facultyId = facultyId;
}
public int getSubjectId() {
	return subjectId;
}
public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
}
public Date getAdate() {
	return adate;
}
public void setAdate(Date adate) {
	this.adate = adate;
}
public char getAttendance() {
	return attendance;
}
public void setAttendance(char attendance) {
	this.attendance = attendance;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}

	
}
