package com.Controler;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import com.model.StudentVo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 13-07-2017.
 */
public class ParentController implements Initializable{
    @FXML
    private JFXButton attendanceButton;

    @FXML
    private JFXButton messageButton;

    @FXML
    private JFXButton assignmentButton;

    @FXML
    private JFXButton profileButton;

    @FXML
    private AnchorPane anchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void attendance(ActionEvent actionEvent) {
        assignmentButton.setStyle("-fx-background-color: FFFFFF;-fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        messageButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        attendanceButton.setStyle("-fx-background-color: FE3F3F;fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20  ");
        profileButton.setStyle("-fx-background-color: FFFFFF;fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20  ");
        try{
            AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/Attendance.fxml"));
            anchorPane.getChildren().setAll(anchorP);
        }
        catch (Exception e){
            System.out.print(e);
        }

    }

    public void assignment(ActionEvent actionEvent) {
        assignmentButton.setStyle("-fx-background-color: FE3F3F; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        messageButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        attendanceButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        profileButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        try{
            AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/StudentAssigment.fxml"));
            anchorPane.getChildren().setAll(anchorP);
        }
        catch (Exception e){
            System.out.print(e);
        }

    }

    public void message(ActionEvent actionEvent) {
        assignmentButton.setStyle("-fx-background-color: FFFFFF;fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20  ");
        messageButton.setStyle("-fx-background-color: FE3F3F; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        attendanceButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        profileButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        try{
            AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/ChatBox.fxml"));
            anchorPane.getChildren().setAll(anchorP);
        }
        catch (Exception e){
            System.out.print(e);
        }

    }

    public void profile(ActionEvent actionEvent) {
        assignmentButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        messageButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        attendanceButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        profileButton.setStyle("-fx-background-color: FE3F3F; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        try{
            AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/ParentProfile.fxml"));
            anchorPane.getChildren().setAll(anchorP);
        }
        catch (Exception e){
            System.out.print(e);
        }

    }
}
