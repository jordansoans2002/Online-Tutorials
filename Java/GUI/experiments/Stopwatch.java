package com.online_tutorials.java_gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stopwatch extends Application {

    int ms=0,tms,points;

    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Stopwatch ob=new Stopwatch();
        stage.setTitle("Stopwatch");

        HBox clock=new HBox(10);
        Label seconds=new Label("00:");
        Label milliseconds=new Label("00");
        clock.setAlignment(Pos.CENTER);
        clock.getChildren().addAll(seconds,milliseconds);

        Button stopStart=new Button("Start");

        tms=(int)((Math.random()*450)+50);
        Label target=new Label("Stop the clock at: "+tms/60+":"+tms%60);

        VBox layout=new VBox(5);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(clock,target,stopStart);

        Timeline time=new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);

        KeyFrame frames=new KeyFrame(Duration.millis(10), new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                milliseconds.setText((++ms)%60 + "");
                seconds.setText(ms/60 + ":");
            }
        });
        time.getKeyFrames().add(frames);

        stopStart.setOnAction(e->{
            if(stopStart.getText().equals("Start")){
                time.playFromStart();
                stopStart.setText("Stop");
            }else if(stopStart.getText().equals("Stop")) {
                time.stop();
                int acc = Math.abs(tms - ms);

                if (acc == 5)
                    points = 10;
                else if (acc > 5 && acc <= 10)
                    points = 7;
                else if (acc > 10 && acc <= 20)
                    points = 5;
                else if (acc > 20 && acc < 50)
                    points = 3;
                else
                    points = 0;

                AlertBox.display("Result", "You got " + points + " points");
                ms = 0;
                seconds.setText("00");
                milliseconds.setText("00");
                stopStart.setText("Start");
            }

        });

        Scene scene=new Scene(layout,200,200);
        stage.setScene(scene);
        stage.show();
    }


}
