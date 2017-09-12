package com.model;

import java.util.Date;

public class FacultyVo extends UserVo{

	private String	facultyId = new String();
	private String	facultyName = new String();
	private String	facultyAddress = new String();
	Date facultyDob = new Date();	
	long facultyMobile;
	char facultyGender;
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyAddress() {
		return facultyAddress;
	}
	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}
	public Date getFacultyDob() {
		return facultyDob;
	}
	public void setFacultyDob(Date facultyDob) {
		this.facultyDob = facultyDob;
	}
	public long getFacultyMobile() {
		return facultyMobile;
	}
	public void setFacultyMobile(long facultyMobile) {
		this.facultyMobile = facultyMobile;
	}
	public char getFacultyGender() {
		return facultyGender;
	}
	public void setFacultyGender(char facultyGender) {
		this.facultyGender = facultyGender;
	}
	
	
}
