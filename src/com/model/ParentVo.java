package com.model;

import java.util.Date;

public class ParentVo extends UserVo{
	int	parentId;
	private String	parentName = new String();
	private String	parentAddress = new String();
	Date parentDob = new Date();	
	long parentMobile;
	String parentOccupation = new String();
   long parentSalary;
public int getParentId() {
	return parentId;
}
public void setParentId(int parentId) {
	this.parentId = parentId;
}
public String getParentName() {
	return parentName;
}
public void setParentName(String parentName) {
	this.parentName = parentName;
}
public String getParentAddress() {
	return parentAddress;
}
public void setParentAddress(String parentAddress) {
	this.parentAddress = parentAddress;
}
public Date getParentDob() {
	return parentDob;
}
public void setParentDob(Date parentDob) {
	this.parentDob = parentDob;
}
public long getParentMobile() {
	return parentMobile;
}
public void setParentMobile(long parentMobile) {
	this.parentMobile = parentMobile;
}
public String getParentOccupation() {
	return parentOccupation;
}
public void setParentOccupation(String parentOccupation) {
	this.parentOccupation = parentOccupation;
}
public long getParentSalary() {
	return parentSalary;
}
public void setParentSalary(long parentSalary) {
	this.parentSalary = parentSalary;
}
   
   
}
