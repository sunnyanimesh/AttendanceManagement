package com.Controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.dao.UserDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import com.model.UserVo;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Animesh on 12-07-2017.
 */
public class ChatBoxController implements Initializable{
    @FXML
    private Label userList;

    @FXML
    private ChoiceBox<UserVo> allUserChoiceBox;

    @FXML
    private ChoiceBox<String> userChoiceBox;

    @FXML
    private Label sendtolable;

    @FXML
    private Label chooseUser;

    @FXML
    private JFXButton sendingButton;

    @FXML
    private AnchorPane chatBox;

    @FXML
    private JFXTextField chatTextField;
UserVo userVo = LoginController.userVo;
UserDao userDao = new UserDao();
UserVo userchatting = new UserVo();
String str;
VBox content = new VBox();
@FXML
        private ScrollPane scrollPane;
ObservableList<String> userChoiceList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userChoiceList.add("Student");
        userChoiceList.add("Parent");
        userChoiceList.add("Faculty");
        scrollPane.setContent(content);
           userChoiceBox.getItems().addAll(userChoiceList);
        userChoiceBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                str= userChoiceBox.getValue();

                ObservableList<UserVo> allUsers = FXCollections.observableArrayList(userDao.returnUsers(str)) ;
                System.out.println(allUsers);
                allUserChoiceBox.getItems().clear();
                    allUserChoiceBox.getItems().addAll(allUsers);

            }
        });

        allUserChoiceBox.valueProperty().addListener(new ChangeListener<UserVo>() {
            @Override
            public void changed(ObservableValue observable, UserVo oldValue, UserVo newValue) {
                 userchatting = allUserChoiceBox.getValue();
                 sendtolable.setText("chatting to " + userchatting);
                System.out.println(userchatting);

                content.getChildren().clear();
                List<String> list= userDao.showMessages(userVo.getUserId(),userchatting.getUserId());
                Iterator<String> itr=list.iterator();
                while(itr.hasNext())
                { Label label = new Label(itr.next());
                    content.setPrefHeight(content.getPrefHeight() + label.getPrefHeight());
                    content.getChildren().add(label);
                }


        }
        });


    }

    public void send(ActionEvent actionEvent) {

       userDao.sendMessage(userVo.getUserId(),userchatting.getUserId(), userVo+"->"+chatTextField.getText());
       content.getChildren().clear();


     List<String> list= userDao.showMessages(userVo.getUserId(),userchatting.getUserId());
        Iterator<String> itr=list.iterator();
        while(itr.hasNext())
        { Label label = new Label(itr.next());
            content.setPrefHeight(content.getPrefHeight() + label.getPrefHeight());
            content.getChildren().add(label);
        }

        chatTextField.clear();
    }

}
