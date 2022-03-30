package com.example.la;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Lab 07 Solution");

        //retreive ddata
            HashMap<String, Integer> data = getData();


        for (String name: data.keySet()) {
            String key = name.toString();
            String value = data.get(name).toString();
            System.out.println(key + " " + value);
        }

        //Creating arcs
        ArrayList<Arc> arcs = new ArrayList<Arc>();

        double startAngle = 0;
        float totalPoints = 0;

        //Getting total data points
        for(String name : data.keySet())
            totalPoints += data.get(name);

        Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON};

        //Put data into arcs
        int i = 0;
        for(String disaster : data.keySet()){
            arcs.add(new Arc(200, 200, 200, 200, startAngle, 360 * (data.get(disaster) / totalPoints)));
            arcs.get(i).setFill(pieColours[i]);
            arcs.get(i).setType(ArcType.ROUND);
            arcs.get(i).setStroke(Color.BLACK);
            startAngle += 360 * (data.get(disaster) /  totalPoints);
            i++;
        }

        //add arcs to scene
        Pane pie = new Pane();
        pie.getChildren().addAll(arcs);
        grid.add(pie, 1,0);

        //Adding legend
        GridPane legend = new GridPane();
        legend.setAlignment(Pos.TOP_CENTER);
        legend.setHgap(10);
        legend.setVgap(10);

        i = 0;
        for(String name : data.keySet()){

            Rectangle rect = new Rectangle(50,50);
            rect.setFill(pieColours[i]);
            rect.setStroke(Color.BLACK);

            legend.add(rect,0,i);
            legend.add(new Text(name), 1, i);

            i++;
        }
        grid.add(legend, 0,0);

        stage.show();
    }

    public static HashMap<String,Integer> getData() throws Exception {
        //Reading in file data
        File fileName = new File("./src/weatherwarnings-2015.csv");

        FileReader file= new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);

        String line = null;

        //Creating map for data storage
        HashMap<String, Integer> methods = new HashMap<>();

        while((line = reader.readLine()) != null){

            String[] data = line.split(",");

            if(methods.containsKey(data[5])){
                methods.put(data[5], methods.get(data[5]) + 1);
            }
            else{
                methods.put(data[5], 0);
            }

        }

        return methods;
    }

    public static void main(String[] args) throws Exception {launch();}
}