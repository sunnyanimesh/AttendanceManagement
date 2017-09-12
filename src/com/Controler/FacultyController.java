package com.Controler;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 09-07-2017.
 */
public class FacultyController implements Initializable {

   public AnchorPane anchorPane;
    public JFXButton assignmentButton;
    public JFXButton messageButton;
    public JFXButton attendanceButton;
public JFXButton profileButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void attendance(ActionEvent actionEvent) {
        assignmentButton.setStyle("-fx-background-color: FFFFFF;-fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        messageButton.setStyle("-fx-background-color: FFFFFF; fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20 ");
        attendanceButton.setStyle("-fx-background-color: FE3F3F;fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20  ");
        profileButton.setStyle("-fx-background-color: FFFFFF;fx-border-color:#FFFFFF; -fx-border-radius:20; -fx-background-radius:20  ");

        try{
            AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/FillAttendance.fxml"));
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
            AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/TeacherAssigment.fxml"));
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
            AnchorPane anchorP=  (AnchorPane) FXMLLoader.load(getClass().getResource("../View/FacultyProfile.fxml"));
            anchorPane.getChildren().setAll(anchorP);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}
