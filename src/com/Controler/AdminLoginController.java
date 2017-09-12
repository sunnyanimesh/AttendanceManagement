package com.Controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.dao.AdminDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.model.AdminVo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by HP on 7/11/2017.
 */
public class AdminLoginController implements Initializable {

        @FXML
        private JFXTextField password;


        public Button log;

        @FXML
        private JFXTextField username;
        AdminVo adminVo;
        Label error;


        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }




        public void validateAdmin(ActionEvent actionEvent) {
                AdminDao adminDao=new AdminDao();
               adminVo  =adminDao.validate(username.getText(),password.getText());
                Stage stage=(Stage) log.getScene().getWindow();

                if(adminVo!=null){
                        Parent root = null;
                        try {
                                root = FXMLLoader.load(getClass().getResource("../View/registerpage.fxml"));
                                stage.setScene(new Scene(root, 600 , 400));
                                stage.show();

                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }
                else if(adminVo==null){
                        error.setText("Ooops!!!!!!!!!");
                }

        }
}




