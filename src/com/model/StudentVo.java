package com.model;

import java.util.Date;

public class StudentVo extends UserVo{

	private String	studentAdmno ;
	private String	studentName ;
	private String	studentAddress ;
	Date studentDob = new Date();	
	long studentMobile;
	char studentGender;
	
	public String getStudentAdmno() {
		return studentAdmno;
	}
	public void setStudentAdmno(String studentAdmno) {
		this.studentAdmno = studentAdmno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Date getStudentDob() {
		return studentDob;
	}
	public void setStudentDob(Date studentDob) {
	this.studentDob = studentDob;
	}
	public long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public char getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(char studentGender) {
		this.studentGender = studentGender;
	}

	
}
