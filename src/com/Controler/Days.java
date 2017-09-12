package com.Controler;

public class Days {
    private String subject;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private int currentAttendance;
    private int totalAttendance;

    public int getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(int totalAttendance) {
        this.totalAttendance = totalAttendance;
    }

    public int getCurrentAttendance() {
        return currentAttendance;
    }

    public void setCurrentAttendance(int currentAttendance) {
        this.currentAttendance = currentAttendance;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public Days(){
        subject ="";
        monday = "";
        tuesday = "";
        wednesday="";
        thursday = "";
        friday = "";
        saturday="";
        sunday = "";
        currentAttendance = 0;
        totalAttendance = 0;
    }


    public Days(String sub,String m,String t,String w,String th,String f,String sat,String sun,int ca,int tot){
        subject = sub;
        monday = m;
        tuesday = t;
        wednesday=w;
        thursday = th;
        friday = f;
        saturday=sat;
        sunday = sun;
       currentAttendance = ca;
       totalAttendance = tot;
        System.out.println(totalAttendance);
    }




}
