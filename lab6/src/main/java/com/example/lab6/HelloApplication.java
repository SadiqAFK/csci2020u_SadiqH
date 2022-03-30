package com.example.lab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.setTitle("Lab 06 Solution");

        //Bar Chart Data
        double[] avgHousingPricesByYear = {
                247381.0,264171.4,287715.3,294736.1,
                308431.4,322635.9,340253.0,363153.7
        };
        double[] avgCommercialPricesByYear = {
                1121585.3,1219479.5,1246354.2,1295364.8,
                1335932.6,1472362.0,1583521.9,1613246.3
        };

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Sales Summary");
        xAxis.setLabel("Year");
        yAxis.setLabel("Price");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Commercial");
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Housing");

        int year = 2005;
        for(int i =0; i<avgCommercialPricesByYear.length; i++){
            series1.getData().add(new XYChart.Data(Integer.toString(year), avgCommercialPricesByYear[i] ));
            series2.getData().add(new XYChart.Data(Integer.toString(year), avgHousingPricesByYear[i] ));

            year++;
        }

        bc.getData().addAll(series1, series2);
        grid.add(bc, 0,0);

        //Pie Chart Data
        String[] ageGroups = {
                "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
        };
        int[] purchasesByAgeGroup = {
                648, 1021, 2453, 3173, 1868, 2247
        };
        Color[] pieColours = {
                Color.AQUA, Color.GOLD, Color.DARKORANGE,
                Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
        };

        //Creating arcs
        double startAngle = 0;
        float totalPurchases =0;

        for(float i : purchasesByAgeGroup)
            totalPurchases += i;

        ArrayList<Arc> arcs = new ArrayList<Arc>();
        for(int i =0; i< pieColours.length; i++){
            arcs.add(new Arc(200, 200, 200, 200, startAngle, 360 * (purchasesByAgeGroup[i] / totalPurchases)));
            arcs.get(i).setFill(pieColours[i]);
            arcs.get(i).setType(ArcType.ROUND);
            startAngle += 360 * (purchasesByAgeGroup[i] /  totalPurchases);
        }
        //add arcs to scene
        Pane pie = new Pane();
        pie.getChildren().addAll(arcs);
        grid.add(pie, 1,0);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}