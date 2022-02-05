package com.online_tutorials.java_gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static  void display(String title,String message){
        Stage window=new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);//prevents user interaction with the previous scene
        window.setMinWidth(300);

        Label label=new Label(message);
        Button closeButton=new Button("OK");
        closeButton.setOnAction(e->window.close());

        VBox layout=new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene=new Scene(layout,200,100);
        window.setScene(scene);
        window.showAndWait();//box needs to be closed before it can return back
    }

}
