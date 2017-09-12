package com.Controler;

import com.jfoenix.controls.JFXTextField;
import com.dao.FacultyDao;
import com.dao.SubjectDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import com.model.AssignmentVo;
import com.model.FacultyVo;
import com.model.SubjectVo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 11-07-2017.
 */
public class FacAssiController implements Initializable{

    @FXML
    private JFXTextField AssigmentName;

    @FXML
    private JFXTextField question3;

    @FXML
    private JFXTextField question2;

    @FXML
    private JFXTextField question5;

    @FXML
    private JFXTextField question4;

    @FXML
    private ComboBox<SubjectVo> Subjects;

    @FXML
    private JFXTextField question1;

    FacultyVo facultyVo = (FacultyVo)LoginController.userVo;
    AssignmentVo assignmentVo =new AssignmentVo();
    FacultyDao facultyDao = new FacultyDao();
    SubjectDao subjectDao = new SubjectDao();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<SubjectVo> subjectList= FXCollections.observableArrayList(subjectDao.getSubjects());
        Subjects.getItems().setAll(subjectList);
    }

    public void upload(ActionEvent actionEvent) {

        assignmentVo.setAssigmentName(AssigmentName.getText());
        assignmentVo.setFacultyId(facultyVo.getFacultyId());
        assignmentVo.setSubjectId(Subjects.getValue().getSubjectId());
     String[] questions = new String[5];

        questions[0] = new String();
        questions[0] = question1.getText();

        questions[1] = new String();
        questions[1] = question2.getText();

        questions[2] = new String();
        questions[2] = question3.getText();

        questions[3] = new String();
        questions[3] = question4.getText();

        questions[4] = new String();
        questions[4] = question5.getText();

        assignmentVo.setQuestions(questions);
   facultyDao.uploadAssignment(assignmentVo);
        AlertBox.display("Assigment", "Assigment has been uploaded");

    }
}
