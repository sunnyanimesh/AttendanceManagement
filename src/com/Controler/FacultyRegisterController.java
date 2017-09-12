package com.Controler;

import com.jfoenix.controls.JFXTextField;
import com.dao.AdminDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.model.FacultyVo;
import com.model.StudentVo;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

/**
 * Created by HP on 7/12/2017.
 */
public class FacultyRegisterController implements Initializable {
    @FXML
    private JFXTextField facultyid;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField gender;

    @FXML
    private DatePicker dob;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField mobile;

    @FXML
    private JFXTextField email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    AdminDao adminDao=new AdminDao();
    public void submitFaculty(ActionEvent actionEvent) {
        FacultyVo facultyVo=new FacultyVo();
        facultyVo.setFacultyId(facultyid.getText());
        facultyVo.setUserPassword(password.getText());
        facultyVo.setFacultyAddress(address.getText());
        facultyVo.setFacultyGender(gender.getText().charAt(0));
        facultyVo.setFacultyDob(java.sql.Date.valueOf(dob.getValue()));
        facultyVo.setFacultyName(name.getText());
        facultyVo.setFacultyMobile(Long.parseLong(mobile.getText()));
        facultyVo.setUserEmail(email.getText());
        adminDao.insertFaculty(facultyVo);

        AlertBox.display("Faculty Registration", "Faculty has been registered ");
    }

}
