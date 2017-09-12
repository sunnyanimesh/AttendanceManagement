package com.model;

import java.sql.Date;

public class AssignmentVo {
 int assignmentId;
 String assigmentName;
 Date assigmentDate;
 String facultyId;
 int subjectId;
 String[] questions = new String[5];
public int getAssignmentId() {
	return assignmentId;
}
public void setAssignmentId(int assignmentId) {
	this.assignmentId = assignmentId;
}
public String getAssigmentName() {
	return assigmentName;
}
public void setAssigmentName(String assigmentName) {
	this.assigmentName = assigmentName;
}
public Date getAssigmentDate() {
	return assigmentDate;
}
public void setAssigmentDate(Date assigmentDate) {
	this.assigmentDate = assigmentDate;
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
public String[] getQuestions() {
	return questions;
}
public void setQuestions(String[] questions) {
	this.questions = questions;
}

	@Override
	public String toString() {
		return assigmentName;
	}
}
