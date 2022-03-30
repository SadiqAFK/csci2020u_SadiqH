package com.example.lab8;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    static String fileName = "oogabooga.csv";
    @Override
    public void start(Stage stage) throws IOException {

        //adding and instansiatin menu options
        MenuBar menu = new MenuBar();


        //defining layout
        VBox vBox = new VBox(menu);
        Scene scene = new Scene(vBox, 900, 900);
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


        vBox.getChildren().add(table);


        Menu fileOptions = new Menu("File");

        MenuItem save = new MenuItem("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                save(table);
            }
        });
        MenuItem _new = new MenuItem("New");
        _new.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                table.getItems().clear();
            }
        });
        MenuItem open = new MenuItem("Open");
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showOpenDialog(stage);
                fileName = selectedFile.getName();

                vBox.getChildren().remove(1,2);
                vBox.getChildren().add(load());
            }
        });
        MenuItem saveAs = new MenuItem("Save As");
        saveAs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showSaveDialog(stage);
                fileName = selectedFile.getName();

                save((TableView<StudentRecord>) vBox.getChildren().get(1));
            }
        });
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        fileOptions.getItems().addAll(_new, open, saveAs, save, exit);
        menu.getMenus().add(fileOptions);

        stage.setScene(scene);


        stage.show();
    }

    public static void save(TableView<StudentRecord> table){
        List<String> tableData= new ArrayList<String>();

        String headers = "";

        //Add headers
        for(TableColumn collum : table.getColumns()){
            headers += collum.getText() + ",";
        }
        tableData.add(headers.substring(0, headers.length() - 25));

        //putting all rows into string seperated by commas
        for(StudentRecord record : table.getItems()){

            String row = "";
            row += record.getStudentID() + ",";
            row += record.getAssignments() + ",";
            row += record.getMidterm() + ",";
            row += record.getFinalExam();

            tableData.add(row);
        }

//        for(String row : tableData){
//            System.out.println(row);
//        }

        try{
            FileWriter file = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(file);

            for(String row : tableData){
                writer.write(row);
                writer.newLine();
            }

            writer.close();
        }
        catch(Exception e){
          System.out.println(e);
        }
    }

    public static TableView load(){

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

        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        //Read file
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);

            String line = "";
            reader.readLine();

            //reading through file
            while((line = reader.readLine()) != null){

                String[] seperatedData = line.split(",");

                marks.add(new StudentRecord(seperatedData[0], Float.parseFloat(seperatedData[1]),
                        Float.parseFloat(seperatedData[2]), Float.parseFloat(seperatedData[3])));

            }

            reader.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        table.setItems(marks);

        table.getColumns().addAll(id, assignments, midterm, exam, mark, letterGrade);

        return table;
    }

    public static void main(String[] args) {
        launch();
    }
}