package com.Controler;

import com.dao.UserDao;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.dao.AdminDao;
import com.dao.BranchDao;
import com.dao.SubjectDao;
import com.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.*;

/**
 * Created by HP on 7/12/2017.
 */
public class StudentRegisterController implements Initializable {
    @FXML
    private JFXTextField admsn;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField gender;

    @FXML
    private DatePicker dob;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXComboBox<SubjectVo> subject;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField mobile;

    @FXML
    private JFXComboBox<BranchVo> branch;

    @FXML
    private JFXPasswordField password;


    @FXML
    private ScrollPane scrollPane;


    SubjectDao subjectDao = new SubjectDao();
    BranchDao branchDao=new BranchDao();

    StudentBranchVo studentBranchVo =new StudentBranchVo();

  List<StudentSubjectVo> studentSubjectVo = new ArrayList<StudentSubjectVo>();

    VBox content = new VBox();
   UserDao userDao = new UserDao();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<SubjectVo> subjectList= FXCollections.observableList(subjectDao.getSubjects());
        subject.getItems().setAll(subjectList);
        ObservableList<BranchVo> branchList=FXCollections.observableList(branchDao.getBranch());
        branch.getItems().setAll(branchList);
        scrollPane.setContent(content);



        subject.valueProperty().addListener(new ChangeListener<SubjectVo>() {
            @Override
            public void changed(ObservableValue<? extends SubjectVo> observable, SubjectVo oldValue, SubjectVo newValue) {
                    SubjectVo subjectVo = subject.getValue();
                    StudentSubjectVo st = new StudentSubjectVo();
              st.setAttendance(0);
              st.setTotalattendance(0);
              st.setFacultyId(userDao.returnFacultyList().get((new Random()).nextInt(userDao.returnFacultyList().size())).getFacultyId());
              st.setStudentAdmno(admsn.getText());
              st.setSubjectId(subjectVo.getSubjectId());
        studentSubjectVo.add(st);

                Label label = new Label(subjectVo.getSubjectName());
                content.setPrefHeight(content.getPrefHeight() + label.getPrefHeight());
                content.getChildren().add(label);


            }
        });


    }
    AdminDao adminDao=new AdminDao();
    static StudentVo studentVo;
    public void submitStudent(ActionEvent actionEvent) {
        studentVo=new StudentVo();
        studentVo.setStudentAdmno(admsn.getText());
        studentVo.setUserPassword(password.getText());
        studentVo.setStudentAddress(address.getText());
        studentVo.setStudentGender(gender.getText().charAt(0));
        studentVo.setStudentDob(java.sql.Date.valueOf(dob.getValue()));
        studentVo.setStudentName(name.getText());
        studentVo.setUserEmail(email.getText());
        studentVo.setStudentMobile(Long.parseLong(mobile.getText()));
    studentBranchVo.setBranchId(branch.getValue().getBranchId());
    studentBranchVo.setSemester(1);
    studentBranchVo.setStudentAdmno(admsn.getText());

        adminDao.insertStudent(studentVo);
      adminDao.insertStudentBranch(studentBranchVo);

        Iterator<StudentSubjectVo> iterator = studentSubjectVo.iterator();
        while(iterator.hasNext()){
            adminDao.insertStudentSubject(iterator.next());
        }

        Stage stage = (Stage) admsn.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../View/parentregister.fxml"));
            stage.setScene(new Scene(root, 680, 624));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
