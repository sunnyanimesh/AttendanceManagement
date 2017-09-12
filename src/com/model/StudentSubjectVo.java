package com.model;

public class StudentSubjectVo {
	private String studentAdmno=new String();
	private int subjectId;
	private String facultyId=new String();
	private int attendance;
	private int totalattendance;
	
	public int getTotalattendance() {
		return totalattendance;
	}
	public void setTotalattendance(int totalattendance) {
		this.totalattendance = totalattendance;
	}
	public String getStudentAdmno() {
		return studentAdmno;
	}
	public void setStudentAdmno(String studentAdmno) {
		this.studentAdmno = studentAdmno;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
	

}
