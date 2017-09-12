package com.Controler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.model.ParentVo;

import java.net.URL;
import java.util.ResourceBundle;

public class ParentProfileController implements Initializable{


        @FXML
        private Label occupation;

        @FXML
        private Label address;



        @FXML
        private Label mail;

        @FXML
        private Label name;
        @FXML
        private Label salary;
        ParentVo parentVo = (ParentVo)LoginController.userVo;
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        occupation.setText(parentVo.getParentOccupation());
        address.setText(parentVo.getParentAddress());
        mail.setText(parentVo.getUserEmail());
        name.setText(parentVo.getParentName());
        salary.setText(Long.toString(parentVo.getParentSalary()));

    }


}


