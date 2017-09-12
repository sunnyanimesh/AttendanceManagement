package com.Controler;

import com.jfoenix.controls.JFXTextField;
import com.dao.AdminDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.model.BranchVo;
import com.model.SubjectVo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by HP on 7/12/2017.
 */
public class SubjectRegisterController implements Initializable{

    @FXML
    private JFXTextField subjectname;
    AdminDao adminDao=new AdminDao();

    @FXML
    void submitSubject(ActionEvent event) {
        SubjectVo subjectVo= new SubjectVo();
        subjectVo.setSubjectName(subjectname.getText());
        adminDao.insertSubject(subjectVo );
        AlertBox.display("Subject Registration", "Subject has been registered");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
