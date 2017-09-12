package com.Controler;

import com.dao.FacultyDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.model.AssignmentVo;
import com.model.FacultyVo;
import com.model.SumbitAssignmentVo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 11-07-2017.
 */
public class SubmitedAssigmentController implements Initializable{


    @FXML
    private Button go;

    @FXML
    private ChoiceBox<AssignmentVo> choiceBox;

    @FXML
    private TableView<SumbitAssignmentVo> table;

    FacultyDao facultyDao = new FacultyDao();
    FacultyVo facultyVo = (FacultyVo)LoginController.userVo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<AssignmentVo> list = facultyDao.viewAssigmentsByFacId(facultyVo.getFacultyId());
        ObservableList<AssignmentVo> subjectList= FXCollections.observableArrayList(list);
       choiceBox.getItems().setAll(subjectList);
    table.setVisible(false);

        TableColumn<SumbitAssignmentVo, String> admissionNumber = new TableColumn<>("Student Admission number");
        admissionNumber.setMaxWidth(73);
        admissionNumber.setCellValueFactory(new PropertyValueFactory<>("studentAdmno"));


        table.getColumns().setAll(admissionNumber);

    }

    public void search(ActionEvent actionEvent) {
      List<SumbitAssignmentVo> list = facultyDao.viewSubmittedAnsweres(choiceBox.getValue().getAssignmentId());
      ObservableList<SumbitAssignmentVo> observableList = FXCollections.observableList(list);
      table.getItems().addAll(observableList);
      table.setVisible(true);
    }
}
