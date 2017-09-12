package com.Controler;

import com.jfoenix.controls.*;
import com.dao.BranchDao;
import com.dao.FacultyDao;
import com.dao.SubjectDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.model.BranchVo;
import com.model.FacultyVo;
import com.model.StudentVo;
import com.model.SubjectVo;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 10-07-2017.
 */
public class FillAttendance implements Initializable {
    @FXML
    private JFXButton submit;

    @FXML
    private JFXButton go;

    @FXML
    private ChoiceBox<Integer> semester;

    @FXML
    private ChoiceBox<BranchVo> branch;

    @FXML
    private ChoiceBox<SubjectVo> subject;

    @FXML
    private TableView<StudentAttendanceSet> table;

    BranchDao branchDao = new BranchDao();
    SubjectDao subjectDao = new SubjectDao();
    FacultyDao facultyDao = new FacultyDao();

    ObservableList<BranchVo> branchList= FXCollections.observableArrayList(branchDao.getBranch());
    ObservableList<SubjectVo> subjectList= FXCollections.observableArrayList(subjectDao.getSubjects());
    ObservableList<StudentAttendanceSet> studentList = FXCollections.observableArrayList();

    FacultyVo facultyVo = (FacultyVo)LoginController.userVo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        semester.getItems().addAll(1,2,3,4,5,6,7,8);
        branch.getItems().addAll(branchList);
        subject.getItems().addAll(subjectList);
        table.setVisible(false);
        submit.setVisible(false);
        table.setEditable(true);


    }

    public void search(ActionEvent actionEvent) {
        List<StudentVo> list = facultyDao.getStudentList(branch.getValue().getBranchId(),semester.getValue(),subject.getValue().getSubjectId(),facultyVo.getFacultyId());

        Iterator<StudentVo> iterator = list.iterator();

        while(iterator.hasNext()){
            StudentVo sv = iterator.next();
            StudentAttendanceSet sas = new StudentAttendanceSet(sv.getStudentAdmno(),sv.getStudentName());
            studentList.add(sas);
        }

        TableColumn<StudentAttendanceSet, String> admno = new TableColumn<>("Admission number");
        admno.setMaxWidth(90);
        admno.setCellValueFactory(new PropertyValueFactory<>("studentAdmno"));

        TableColumn<StudentAttendanceSet, String> name = new TableColumn<>("Name");
        name.setMaxWidth(90);
        name.setCellValueFactory(new PropertyValueFactory<>("studentName"));

       TableColumn<StudentAttendanceSet,ChoiceBox<Character>> attedance = new TableColumn<>("Attendance");
       attedance.setMaxWidth(90);
       attedance.setCellValueFactory(new PropertyValueFactory<>("attendance"));

        System.out.println(studentList.size());
        table.getColumns().setAll(admno,name,attedance);
        table.setItems(studentList);

        table.setVisible(true);
        submit.setVisible(true);
        semester.setVisible(false);
        branch.setVisible(false);
        go.setVisible(false);
        subject.setVisible(false);
    }

    public void submit(ActionEvent actionEvent) {
    ObservableList<StudentAttendanceSet> observableList = table.getItems();
       Iterator<StudentAttendanceSet> iterator= observableList.iterator();
      while(iterator.hasNext()){
          StudentAttendanceSet sas = iterator.next();
        facultyDao.setAttendance(facultyVo.getFacultyId(),sas.getStudentAdmno(),subject.getValue().getSubjectId(),sas.getAttendance().getValue());

      }
        AlertBox.display("Attendance updated", "Attendance has been updated");
    }

    }
