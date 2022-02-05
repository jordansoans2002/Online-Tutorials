package com.online_tutorials.java_gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchingScenes extends Application {
    Stage window;
    Scene sc1,sc2;
    Button b1,b2;

    public static void main(String []args){launch();}

    @Override
    public void start(Stage stage) throws Exception {
        window=stage;

        Label label1=new Label("Welcome to scene 1");

        b1=new Button();
        b1.setText("click here for scene 2");
        b1.setOnAction(e->window.setScene(sc2));

        //L1 children are in vertical column
        VBox l1=new VBox(20);//20 is spacing
        l1.getChildren().addAll(label1,b1);
        sc1=new Scene(l1,200,250);

        b2=new Button("Go back");
        b2.setOnAction(e->
            {
                if(ConfirmBox.display("Exit scene","Exit scene?"))
                    window.setScene(sc1);
                l1.getChildren().add(new Label("Welcome back to scene 2"));
            }
        );

        //L2
        StackPane l2=new StackPane();
        l2.getChildren().add(b2);
        sc2=new Scene(l2,600,600);

        window.setScene(sc1);
        window.setTitle("Changing scenes");
        window.show();
    }
}
