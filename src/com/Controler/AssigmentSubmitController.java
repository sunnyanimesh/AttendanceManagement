package com.Controler;

import com.dao.ParentDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.dao.FacultyDao;
import com.dao.StudentDao;
import com.dao.SubjectDao;
import com.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 11-07-2017.
 */
public class AssigmentSubmitController implements Initializable{
    @FXML
    private JFXTextArea ans3;

    @FXML
    private Label AssigmentName;

    @FXML
    private JFXTextArea ans2;

    @FXML
    private JFXTextArea ans5;

    @FXML
    private JFXTextArea ans4;

    @FXML
    private JFXButton submit;

    @FXML
    private JFXTextArea ans1;

    @FXML
    private Label ques5;

    @FXML
    private Label ques4;

    @FXML
    private Label Subject;

    @FXML
    private Label Date;

    @FXML
    private Label Ques2;

    @FXML
    private Label FacultyName;

    @FXML
    private Label Ques1;

    @FXML
    private Label ques3;

   AssignmentVo assignmentVo = StudentAssignmentController.assignmentVo;
   SubjectDao subjectDao = new SubjectDao();
   FacultyDao facultyDao = new FacultyDao();
   SumbitAssignmentVo submitAssignmentVo = new SumbitAssignmentVo();
   StudentVo studentVo ;
   StudentDao studentDao = new StudentDao();
   ParentDao parentDao = new ParentDao();
   @Override
    public void initialize(URL location, ResourceBundle resources) {
       if(LoginController.userVo.getUserType() == UserType.PARENT){
           ParentVo parentVo = (ParentVo)LoginController.userVo;
           studentVo = parentDao.getStudent(parentVo.getParentId());
       }
       else
           studentVo = (StudentVo)LoginController.userVo;

     AssigmentName.setText(assignmentVo.getAssigmentName());
     Subject.setText(subjectDao.getSubjectName(assignmentVo.getSubjectId()));
     FacultyName.setText(facultyDao.getFacultyName(assignmentVo.getFacultyId()));
     Date.setText(assignmentVo.getAssigmentDate().toString());
       Ques1.setText(assignmentVo.getQuestions()[0]);
       Ques2.setText(assignmentVo.getQuestions()[1]);
       ques3.setText(assignmentVo.getQuestions()[2]);
       ques4.setText(assignmentVo.getQuestions()[3]);
       ques5.setText(assignmentVo.getQuestions()[4]);
   }


   public void submitAssigment(ActionEvent event) {
       submitAssignmentVo.setAssigmentid(assignmentVo.getAssignmentId());
       submitAssignmentVo.setStudentAdmno(studentVo.getStudentAdmno());
       submitAssignmentVo.setAnsweres(new String[]{ans1.getText(),ans2.getText(),ans3.getText(),ans4.getText(),ans5.getText()});

       studentDao.submitAssigment(submitAssignmentVo);


   }


}
