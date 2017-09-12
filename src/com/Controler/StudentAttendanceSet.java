package com.Controler;

import javafx.scene.control.ChoiceBox;

/**
 * Created by Animesh on 10-07-2017.
 */
public class StudentAttendanceSet {
    private String studentAdmno;
    private String studentName;
    private ChoiceBox<Character> attendance = new ChoiceBox<>();

    public ChoiceBox<Character> getAttendance() {
        return attendance;
    }

    public void setAttendance(ChoiceBox<Character> attendance) {
        this.attendance = attendance;
    }

    public StudentAttendanceSet(){
        this.studentAdmno = "";
        this.studentName = "";
         attendance.getItems().setAll('A','P','E');
        attendance.getSelectionModel().select(2);

    }
    public StudentAttendanceSet(String studentAdmno, String studentName) {
        this.studentAdmno = studentAdmno;
        this.studentName = studentName;
        attendance.getItems().setAll('A','P','E');
        attendance.getSelectionModel().select(2);
    }

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
}
