package com.online_tutorials.java_gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmbedLayouts extends Application {

    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage window){
        window.setTitle("Embedding layouts");

        HBox topMenu=new HBox();
        Button b1=new Button("Option 1");
        Button b2=new Button("Option 2");
        Button b3=new Button("Option 3");
        topMenu.getChildren().addAll(b1,b2,b3);
        topMenu.setAlignment(Pos.CENTER);

        VBox leftMenu=new VBox();
        Button b4=new Button("Option 4");
        Button b5=new Button("Option 5");
        Button b6=new Button("Option 6");
        leftMenu.getChildren().addAll(b4,b5,b6);

        BorderPane mainLayout=new BorderPane();
        mainLayout.setTop(topMenu);
        mainLayout.setLeft(leftMenu);

        Scene s1=new Scene(mainLayout,300,300);
        window.setScene(s1);
        window.show();
    }
}
