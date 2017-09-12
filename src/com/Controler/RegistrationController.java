package com.Controler;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by HP on 7/11/2017.
 */

public class RegistrationController implements Initializable{


    @FXML
    private JFXButton registerstudent;

    @FXML
    private JFXButton branchregister;

    @FXML
    private JFXButton registersubject;

    @FXML
    private JFXButton registerfaculty;







    public void branchRegistration(ActionEvent event) {
        Stage stage = (Stage) branchregister.getScene().getWindow();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../View/branchregister.fxml"));
            stage.setScene(new Scene(root, 518, 466));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void subjectRegistration(ActionEvent event) {
        Stage stage = (Stage) registersubject.getScene().getWindow();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../View/subjectregister.fxml"));
            stage.setScene(new Scene(root,518 ,466 ));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void studentRegistration(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) registerstudent.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../View/studentregister.fxml"));
        stage.setScene(new Scene(root, 680, 624));
        stage.show();

    }

    public void facRegistration(ActionEvent actionEvent) {
        Stage stage = (Stage) registerfaculty.getScene().getWindow();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../View/facultyregister.fxml"));
            stage.setScene(new Scene(root, 680, 624));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

