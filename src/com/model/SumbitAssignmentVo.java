package com.model;

public class SumbitAssignmentVo {
 String studentAdmno;
 int assigmentid;
 String[] answeres = new String[5];
public String getStudentAdmno() {
	return studentAdmno;
}
public void setStudentAdmno(String studentAdmno) {
	this.studentAdmno = studentAdmno;
}
public int getAssigmentid() {
	return assigmentid;
}
public void setAssigmentid(int assigmentid) {
	this.assigmentid = assigmentid;
}
public String[] getAnsweres() {
	return answeres;
}
public void setAnsweres(String[] answeres) {
	this.answeres = answeres;
}
	
}
