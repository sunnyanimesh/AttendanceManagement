package com.Controler;

import com.dao.BranchDao;
import com.model.FacultyVo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FacultyProfileController  implements Initializable{


    @FXML
    private Label address;

    @FXML
    private Label gender;

    @FXML
    private Label dob;

    @FXML
    private Label name;


    @FXML
    private Label mail;



    FacultyVo facultyVo = (FacultyVo)LoginController.userVo;
    BranchDao branchDao = new BranchDao();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        address.setText(facultyVo.getFacultyAddress());
        gender.setText(String.valueOf(facultyVo.getFacultyGender()));
        dob.setText(String.valueOf(facultyVo.getFacultyDob()));
        name.setText(facultyVo.getFacultyName());
        mail.setText(facultyVo.getUserEmail());

    }
}
