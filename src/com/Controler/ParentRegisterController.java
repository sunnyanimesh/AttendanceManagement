package com.Controler;

import com.dao.AdminDao;
import com.dao.UserDao;
import com.jfoenix.controls.JFXTextField;
import com.model.ParentOfVo;
import com.model.StudentVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.model.ParentVo;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

/**
 * Created by HP on 7/12/2017.
 */
public class ParentRegisterController implements Initializable {
    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField occupation;


    @FXML
    private DatePicker dob;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField salary;

    @FXML
    private JFXTextField parentid;

    @FXML
    private JFXTextField phoneno;

    ParentVo parentVo=new ParentVo();

StudentVo studentVo = StudentRegisterController.studentVo;
AdminDao adminDao = new AdminDao();

    public void sumbitParent(ActionEvent actionEvent) {
        parentVo.setParentAddress(address.getText());
        parentVo.setUserPassword(password.getText());
        parentVo.setParentOccupation(occupation.getText());
        parentVo.setParentDob(java.sql.Date.valueOf(dob.getValue()));
        parentVo.setParentName(name.getText());
        parentVo.setParentSalary(Long.parseLong(salary.getText()));
        parentVo.setParentId(Integer.parseInt(parentid.getText()));
        parentVo.setParentMobile(Long.parseLong(phoneno.getText()));

        adminDao.insertParent(parentVo);
        ParentOfVo parentOf = new ParentOfVo();
        parentOf.setParentId(parentVo.getParentId());
        parentOf.setStudentAdmno(studentVo.getStudentAdmno());
        adminDao.parentOf(parentOf);

        AlertBox.display("Parent Registration", "Parent has been registered");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
