package com.Controler;

import com.dao.StudentDao;
import com.dao.SubjectDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import com.model.AssignmentVo;
import com.model.SubjectVo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 11-07-2017.
 */
public class StudentAssignmentController implements Initializable{
    @FXML
    private ChoiceBox<SubjectVo> subjectChoiceBox;

    @FXML
    private TableView<AssignmentVo> table;

    SubjectDao subjectDao = new SubjectDao();
    StudentDao studentDao = new StudentDao();
   static AssignmentVo assignmentVo = new AssignmentVo();
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<SubjectVo> subjectList= FXCollections.observableArrayList(subjectDao.getSubjects());
        subjectChoiceBox.getItems().setAll(subjectList);
       table.setVisible(false);


        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                try {
                   assignmentVo =  table.getSelectionModel().getSelectedItem();

                    AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/assi.fxml"));
                    anchorPane.getChildren().setAll(anchorP);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

    }


    public void get(ActionEvent actionEvent) {
      table.setVisible(true);
       ArrayList<AssignmentVo> list = (ArrayList<AssignmentVo>) studentDao.viewAssigments(subjectChoiceBox.getValue().getSubjectId());
       ObservableList<AssignmentVo> list2  = FXCollections.observableList(list);

        TableColumn<AssignmentVo, Integer> id = new TableColumn<>("Id");
        id.setMaxWidth(73);
        id.setCellValueFactory(new PropertyValueFactory<>("assignmentId"));

        TableColumn<AssignmentVo, Integer> name = new TableColumn<>("Name");
        name.setMaxWidth(73);
        name.setCellValueFactory(new PropertyValueFactory<>("assigmentName"));

        table.getColumns().setAll(id,name);

        table.getItems().setAll(list2);


    }


}
