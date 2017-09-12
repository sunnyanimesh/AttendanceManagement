package com.Controler;

import com.dao.ParentDao;
import com.dao.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    public TextField username;
    public PasswordField password;
    public Button login;
    static UserVo userVo ;
    Label error;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void validateUser(ActionEvent actionEvent) throws IOException {
         UserDao userDao = new UserDao();
        userVo = userDao.validate(username.getText(),password.getText());
        Stage stage=(Stage) login.getScene().getWindow();

        if(userVo.getUserType() == UserType.FACULTY) {
            Parent root = FXMLLoader.load(getClass().getResource("../View/Faculty.fxml"));
            stage.setScene(new Scene(root, 755 , 511));
            stage.show();

        }

        else if(userVo.getUserType() == UserType.PARENT){

            Parent root = FXMLLoader.load(getClass().getResource("../View/Parent.fxml"));
            stage.setScene(new Scene(root, 755 , 511));
            stage.show();

        }
        else if(userVo.getUserType() == UserType.STUDENT){
            Parent root = FXMLLoader.load(getClass().getResource("../View/Student.fxml"));
            stage.setScene(new Scene(root, 755 , 511));
            stage.show();
        }
        else if((userVo==null)||(userVo.getUserType() == UserType.NOTHING)){
            AlertBox.display("Alert", "Invalid input");
        }


    }
}
