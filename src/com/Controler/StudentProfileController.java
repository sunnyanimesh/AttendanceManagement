package com.Controler;

import com.dao.BranchDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Created by HP on 7/11/2017.
 */
import com.model.StudentVo;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentProfileController implements Initializable{


        @FXML
        private Label address;

        @FXML
        private Label gender;

        @FXML
        private Label mail;

        @FXML
        private Label name;

        @FXML
        private Label sem;

        @FXML
        private Label branch;

        StudentVo studentVo = (StudentVo)LoginController.userVo;
        BranchDao branchDao=new BranchDao();


        @Override
        public void initialize(URL location, ResourceBundle resources)  {
            name.setText(studentVo.getStudentName());
            gender.setText(String.valueOf(studentVo.getStudentGender()));
            mail.setText(studentVo.getUserEmail());
            branch.setText(String.valueOf(branchDao.getBranch(studentVo.getStudentAdmno())));
            address.setText(studentVo.getStudentAddress());

        }
    }


