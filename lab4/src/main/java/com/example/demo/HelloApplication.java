package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);


        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.setTitle("Lab 04 Solution");


        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);


        Label password = new Label("Password:");
        grid.add(password, 0, 2);
        PasswordField userPass = new PasswordField();
        grid.add(userPass, 1, 2);

        Label fullName = new Label("Full Name:");
        grid.add(fullName, 0, 3);
        TextField userFullName = new TextField();
        grid.add(userFullName, 1, 3);

        Label email = new Label("E-Mail:");
        grid.add(email, 0, 4);
        TextField userMail = new TextField();
        grid.add(userMail, 1, 4);

        Label phone = new Label("Phone #:");
        grid.add(phone, 0, 5);
        TextField userPhone = new TextField("Phone #");
        grid.add(userPhone, 1, 5);


        Label birthDate = new Label("Date of Birth:");
        grid.add(birthDate, 0, 6);
        DatePicker userBirth = new DatePicker();
        grid.add(userBirth, 1, 6);

        Button submit = new Button("Register");
        grid.add(submit, 1, 7);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Username: " + userTextField.getText() +
                                    "\nPassword: " + userPass.getText() + "\nFull Name: " + userFullName.getText()+
                                    "\nEmail: " + userMail.getText() +  "\nPhone #: " + userPhone.getText() +
                                    "\nBirth Date: " + userBirth.getValue() );
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}