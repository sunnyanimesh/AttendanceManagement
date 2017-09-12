package com.Controler;

import com.jfoenix.controls.JFXTextField;
import com.dao.AdminDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.model.BranchVo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by HP on 7/12/2017.
 */
public class BranchRegisterController implements Initializable {
    @FXML
    private JFXTextField branchhod;

    @FXML
    private JFXTextField branchname;
    AdminDao adminDao=new AdminDao();

    @FXML
    void submitBranch(ActionEvent event) {
        BranchVo branchVo=new BranchVo();
        branchVo.setBranchName(branchname.getText());
        branchVo.setHOD(branchhod.getText());
        adminDao.insertBranch(branchVo);
        AlertBox.display("Branch Register", "Branch has been registered");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
