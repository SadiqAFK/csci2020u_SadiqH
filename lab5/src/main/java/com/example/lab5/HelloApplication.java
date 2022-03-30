package com.example.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        Scene scene = new Scene(grid, 320, 240);
        stage.setTitle("Student Records");

        TableView table = new TableView();
        TableColumn id = new TableColumn("SID");
        id.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, String>("studentID"));

        TableColumn assignments = new TableColumn("Assignments");
        assignments.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, String>("assignments"));

        TableColumn midterm = new TableColumn("Midterm");
        midterm.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, String>("midterm"));

        TableColumn exam = new TableColumn("Final Exam");
        exam.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, String>("finalExam"));

        TableColumn mark = new TableColumn("Final Mark");
        mark.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, String>("finalMark"));

        TableColumn letterGrade = new TableColumn("Letter Grade");
        letterGrade.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, String>("letterGrade"));

        DataSource data = new DataSource();
        table.setItems(data.getAllMarks());

        table.getColumns().addAll(id, assignments, midterm, exam, mark, letterGrade);


        grid.add(table, 0,0);



        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void save(){

    }
}