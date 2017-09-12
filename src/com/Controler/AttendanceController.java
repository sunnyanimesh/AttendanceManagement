package com.Controler;

import com.dao.ParentDao;
import com.dao.StudentDao;
import com.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class AttendanceController implements Initializable
{
    StudentVo studentVo ;
    public TableView<Days> table;
    final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    StudentDao studentDao = new StudentDao();
    ObservableList<Days> attend = FXCollections.observableArrayList();



    public AnchorPane anchorPane;

    static Calendar toDate ;
    static Calendar fromDate;

    @FXML
    Label toDatep;
    @FXML
    Label fromDatep;
    @FXML
    Label percentage;
float count,tcount;
ParentDao parentDao = new ParentDao();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    if(LoginController.userVo.getUserType() == UserType.PARENT){
        ParentVo parentVo = (ParentVo)LoginController.userVo;
        System.out.println(parentVo.getParentId());
        studentVo = parentDao.getStudent(parentVo.getParentId());
        System.out.println(studentVo.getStudentAdmno());
    }
    else
        studentVo = (StudentVo)LoginController.userVo;

        count = 0;
       tcount = 0;

        addColoumn();
        toDate = Calendar.getInstance();
        fromDate = getLastMondayDate((Calendar) toDate.clone());
        System.out.print(fromDate.getTime().toString() + "    "+ toDate.getTime().toString());
          toDatep.setText(toDate.getTime().toString());
          fromDatep.setText(fromDate.getTime().toString());
        List<SubjectVo> list = studentDao.getSubjects(studentVo.getStudentAdmno());
        Iterator<SubjectVo> iterator = list.iterator();

        while (iterator.hasNext()) {
            SubjectVo subjectVo = iterator.next();
            String[] attendance = getAttendance(subjectVo.getSubjectId(),(Calendar) fromDate.clone(),(Calendar) toDate.clone());
            StudentSubjectVo studentSubjectVo = studentDao.getSubjectAttendance(studentVo.getStudentAdmno(),subjectVo.getSubjectId());
            attend.add(new Days(subjectVo.getSubjectName(),attendance[0],attendance[1],attendance[2],attendance[3],attendance[4],attendance[5],attendance[6],studentSubjectVo.getAttendance(),studentSubjectVo.getTotalattendance()));
            table.setItems(attend);
            count = count + studentSubjectVo.getAttendance();
            tcount = tcount + studentSubjectVo.getTotalattendance();
        }

        float tpercentage = (float) ((count/tcount) * 100.0);
        percentage.setText("your percentage is : " + tpercentage);

    }

    private void addColoumn() {

        TableColumn<Days, String> subjectColumn = new TableColumn<>("Subject");
        subjectColumn.setMaxWidth(73);
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Days, String> mondayColumn = new TableColumn<>("Monday");
        mondayColumn.setMaxWidth(73);
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>("monday"));

        TableColumn<Days, String> tuesdayColumn = new TableColumn<>("Tuesday");
        tuesdayColumn.setMaxWidth(73);
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>("tuesday"));


        TableColumn<Days, String> wednesdayColumn = new TableColumn<>("Wednesday");
        wednesdayColumn.setMaxWidth(73);
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>("wednesday"));

        TableColumn<Days, String> thursdayColumn = new TableColumn<>("Thursday");
        thursdayColumn.setMaxWidth(73);
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>("thursday"));

        TableColumn<Days, String> fridayColumn = new TableColumn<>("Friday");
        fridayColumn.setMaxWidth(73);
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>("friday"));

        TableColumn<Days, String> saturdayColumn = new TableColumn<>("Saturday");
        saturdayColumn.setMaxWidth(73);
        saturdayColumn.setCellValueFactory(new PropertyValueFactory<>("saturday"));

        TableColumn<Days, String> sundayColumn = new TableColumn<>("Sunday");
        sundayColumn.setMaxWidth(73);
        sundayColumn.setCellValueFactory(new PropertyValueFactory<>("sunday"));


        TableColumn<Days, Integer> currentAttendance = new TableColumn<>("Current Attendance");
        currentAttendance.setMaxWidth(73);
        currentAttendance.setCellValueFactory(new PropertyValueFactory<>("currentAttendance"));


        TableColumn<Days, Integer> totalAttendance = new TableColumn<>("Total Attendance");
        totalAttendance.setMaxWidth(73);
        totalAttendance.setCellValueFactory(new PropertyValueFactory<>("totalAttendance"));


        table.getColumns().setAll(subjectColumn, mondayColumn, tuesdayColumn, wednesdayColumn,thursdayColumn, fridayColumn, saturdayColumn, sundayColumn,currentAttendance,totalAttendance);

    }

    private Calendar getLastMondayDate(Calendar last)
    {
        Calendar cal = last;

        while (cal.get( Calendar.DAY_OF_WEEK ) != Calendar.MONDAY)
            cal.add( Calendar.DAY_OF_WEEK, -1 );
        return cal;

    }
    private Calendar getLastSunday(Calendar last){
        Calendar cal = last;

        while (cal.get( Calendar.DAY_OF_WEEK ) != Calendar.SUNDAY)
            cal.add( Calendar.DAY_OF_WEEK, -1 );
        return cal;

    }


    private Calendar getnextSunday(Calendar last){
        Calendar cal = last;

        while ((cal.get( Calendar.DAY_OF_WEEK ) != Calendar.SUNDAY)&&(cal.compareTo(Calendar.getInstance())<0))
            cal.add( Calendar.DAY_OF_WEEK, 1 );
        return cal;

    }

    private String[] getAttendance(int subjectId,Calendar startDate,Calendar endDate){
        String[] string = new String[7];
          int i = 0;

     for (; startDate.compareTo(endDate) <= 0; startDate.add(Calendar.DATE, 1)) {
             string[i] = new String();
            string[i++] = studentDao.getAttendancestream(studentVo.getStudentAdmno(),subjectId,new java.sql.Date((startDate.getTime().getTime())));

     }
        return string;

    }


    public void previ(ActionEvent actionEvent) {
      table.getItems().clear();
        toDate = getLastSunday((Calendar) fromDate.clone());
        fromDate = getLastMondayDate((Calendar) toDate.clone());
        toDatep.setText(toDate.getTime().toString());
        fromDatep.setText(fromDate.getTime().toString());
        List<SubjectVo> list = studentDao.getSubjects(studentVo.getStudentAdmno());
        Iterator<SubjectVo> iterator = list.iterator();

        while (iterator.hasNext()) {
            SubjectVo subjectVo = iterator.next();
            String[] attendance = getAttendance(subjectVo.getSubjectId(),(Calendar) fromDate.clone(),(Calendar) toDate.clone());
            StudentSubjectVo studentSubjectVo = studentDao.getSubjectAttendance(studentVo.getStudentAdmno(),subjectVo.getSubjectId());
            attend.add(new Days(subjectVo.getSubjectName(),attendance[0],attendance[1],attendance[2],attendance[3],attendance[4],attendance[5],attendance[6],studentSubjectVo.getAttendance(),studentSubjectVo.getTotalattendance()));
            table.setItems(attend);
            count = count + studentSubjectVo.getAttendance();
            tcount = tcount + studentSubjectVo.getTotalattendance();
        }

        float tpercentage = (count/tcount) * 100;
        percentage.setText("your percentage is : " + Float.toString(tpercentage));

        System.out.print(fromDate.getTime().toString() + "    "+ toDate.getTime().toString());
    }

    public void nexti(ActionEvent actionEvent) {

        Calendar temp = (Calendar) toDate.clone();
      if(temp.compareTo(Calendar.getInstance())<=0) {
          temp.add(Calendar.DATE, 1);
          fromDate = temp;

          toDate = getnextSunday((Calendar) fromDate.clone());
          table.getItems().clear();
          toDatep.setText(toDate.getTime().toString());
          fromDatep.setText(fromDate.getTime().toString());
          List<SubjectVo> list = studentDao.getSubjects(studentVo.getStudentAdmno());
          Iterator<SubjectVo> iterator = list.iterator();

          while (iterator.hasNext()) {
              SubjectVo subjectVo = iterator.next();
              String[] attendance = getAttendance(subjectVo.getSubjectId(),(Calendar) fromDate.clone(),(Calendar) toDate.clone());
              StudentSubjectVo studentSubjectVo = studentDao.getSubjectAttendance(studentVo.getStudentAdmno(),subjectVo.getSubjectId());
              attend.add(new Days(subjectVo.getSubjectName(),attendance[0],attendance[1],attendance[2],attendance[3],attendance[4],attendance[5],attendance[6],studentSubjectVo.getAttendance(),studentSubjectVo.getTotalattendance()));
              table.setItems(attend);
              count = count + studentSubjectVo.getAttendance();
              tcount = tcount + studentSubjectVo.getTotalattendance();
          }

          float tpercentage = (count/tcount) * 100;
          percentage.setText("your percentage is : " + Float.toString(tpercentage));

          System.out.print(fromDate.getTime().toString() + "    " + toDate.getTime().toString());
      }

    }


}
