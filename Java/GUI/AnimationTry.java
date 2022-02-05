package com.online_tutorials.java_gui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AnimationTry extends Application {
    int ms=0,dist=0;

    public static void main(String []args){launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Animations");

        Rectangle box=new Rectangle(100,12,Color.BLUE);
        Rectangle status=new Rectangle(1,10, Color.ORANGE);
        StackPane statusBox=new StackPane(box,status);
        statusBox.setAlignment(Pos.CENTER_LEFT);

        KeyValue statMove=new KeyValue(status.widthProperty(),100);
        KeyFrame statusMove=new KeyFrame(Duration.seconds(3),statMove);
        Timeline statusBar=new Timeline(statusMove);

        KeyFrame timer=new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               ms+=1;
            }
        });
        Timeline time=new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(timer);
        //statusBar.play();

        Circle circle = new Circle(15, Color.ORANGE);
        AnchorPane anchorPane=new AnchorPane(circle);
        circle.setLayoutY(20);
        anchorPane.setPrefHeight(40);
        anchorPane.setStyle("-fx-background-color:lightblue");

        KeyValue moveStart=new KeyValue(circle.centerXProperty(), 10);
        KeyValue moveEnd=new KeyValue(circle.centerXProperty(), 385);
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(10),moveStart,moveEnd);
        Timeline ballMove=new Timeline(keyFrame);

        KeyValue sunrise=new KeyValue(circle.fillProperty(),Color.ORANGE);
        KeyValue rising=new KeyValue(circle.fillProperty(),Color.YELLOW);
        KeyValue afternoon=new KeyValue(circle.fillProperty(),Color.WHITE);
        KeyValue sunset=new KeyValue(circle.fillProperty(),Color.ORANGERED);
        KeyFrame rise=new KeyFrame(Duration.seconds(5),sunrise,rising,afternoon);
        KeyFrame set=new KeyFrame(Duration.seconds(5),afternoon,rising,sunset);
        Timeline dayStart=new Timeline(rise);
        Timeline dayEnd=new Timeline(set);
        //ballMove.playFromStart();
        //dayStart.playFromStart();
        dayStart.setOnFinished(e->dayEnd.playFromStart());
        ballMove.setOnFinished(e->System.out.println("stopped"));

        VBox vBox=new VBox(20,statusBox,anchorPane);

        Scene scene=new Scene(vBox,400,400);
        scene.setOnKeyPressed(e-> {
            if (e.getCode() == KeyCode.SPACE){
                statusBar.play();
                time.playFromStart();
            }
        });
        scene.setOnKeyReleased(e->{
            if(e.getCode()==KeyCode.SPACE) {
                statusBar.stop();
                time.stop();
                System.out.println(ms);
                if(ms<1500)
                    dist=385/2;
                else
                    dist=385;
                ballMove.playFromStart();
                dayStart.playFromStart();
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}
