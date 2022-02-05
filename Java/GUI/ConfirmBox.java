package com.online_tutorials.java_gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean answer;

    public static boolean display(String title,String message){
        Stage window=new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        Label label=new Label(message);

        Button yes=new Button("yes");
        yes.setOnAction(e-> {
            answer=true;
            window.close();
        });

        Button no=new Button("no");
        no.setOnAction(e->{
            answer=false;
            window.close();
        });

        HBox sideBySide=new HBox(10);
        sideBySide.getChildren().addAll(yes,no);
        sideBySide.setAlignment(Pos.BASELINE_CENTER);

        VBox layout=new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,sideBySide);

        Scene scene=new Scene(layout,200,100);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
