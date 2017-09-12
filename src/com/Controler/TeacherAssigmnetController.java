package com.Controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 11-07-2017.
 */
public class TeacherAssigmnetController implements Initializable {

    public AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void newAs(ActionEvent actionEvent) {
        AnchorPane anchorP= null;
        try {
            anchorP = (AnchorPane) FXMLLoader.load(getClass().getResource("../View/FAC_ASSi.fxml"));
            anchorPane.getChildren().setAll(anchorP);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void viewS(ActionEvent actionEvent) {
        AnchorPane anchorP= null;
        try {
            anchorP = (AnchorPane) FXMLLoader.load(getClass().getResource("../View/SubmitedAssigment.fxml"));
            anchorPane.getChildren().setAll(anchorP);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
