package com.example.midterm;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setResizable(false);
        stage.setWidth(500);
        stage.setHeight(500);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        BorderPane homePage = new BorderPane();
        homePage.setCenter(grid);

        Scene home = new Scene(homePage, 500, 500);
        stage.setScene(home);

        //Menu buttons
        Button btn_animate = new Button("Animate");
        Button btn_graphics = new Button("2D-Graphic");
        Button btn_xml = new Button("XML");

        //back to home button
        Button btn_main = new Button("Back to main");
        btn_main.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(home);
            }
        });

        //add buttons to homepage
        grid.addColumn(0, btn_animate, btn_graphics, btn_xml);


        BorderPane actions = new BorderPane();
        Scene inner = new Scene(actions);

        //Animation
        Rectangle rect_animated = new Rectangle(100,100);
        rect_animated.setFill(Color.GREEN);


        btn_animate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(inner);
                actions.setLeft(rect_animated);
                actions.setTop(btn_main);

                rect_animated.setTranslateY(150);

                TranslateTransition tt = new TranslateTransition(Duration.millis(2000), rect_animated);

                tt.setByX(400f);
                tt.setCycleCount(2);
                tt.setAutoReverse(true);

                tt.play();
            }
        });


        //Graphic
        Rectangle name_h11 = new Rectangle(20, 100);
        Rectangle name_h12 = new Rectangle(20, 100);
        Rectangle name_h2 = new Rectangle(50, 20);
        Arc upper_s = new Arc(100,100,120,150,0,270);
        upper_s.setType(ArcType.ROUND);
        upper_s.setFill(Color.TRANSPARENT);
        upper_s.setStroke(Color.BLACK);
        Arc lower_s = new Arc(100,100,100,100,90,270);
        lower_s.setType(ArcType.CHORD);
        lower_s.setFill(Color.TRANSPARENT);
        lower_s.setStroke(Color.BLACK);

        GridPane drawing = new GridPane();
        drawing.setAlignment(Pos.CENTER);
        drawing.setHgap(10);
        drawing.setVgap(10);

        btn_graphics.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(inner);
                actions.setTop(btn_main);
                actions.setCenter(drawing);

                drawing.addColumn(0, upper_s, lower_s);

                drawing.add(name_h11, 2,0);
                drawing.add(name_h12, 4,0);
                drawing.add(name_h2, 3,0);

            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}