package com.online_tutorials.java_gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Setup_CowBull extends Application {

    public static void main(String []args){
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Choose Game settings");

        ChoiceBox<Integer> noOfPlayers=new ChoiceBox<>();
        noOfPlayers.getItems().addAll(1,2,3,4);
        noOfPlayers.setValue(1);
        HBox dropDownPlayers=new HBox(5);
        dropDownPlayers.getChildren().addAll(new Label("Number of players"),noOfPlayers);
        dropDownPlayers.setAlignment(Pos.CENTER);

        ChoiceBox<Integer> wordLength=new ChoiceBox<>();
        wordLength.getItems().addAll(3,4,5);
        wordLength.setValue(4);
        HBox dropDownWordLength=new HBox(5);
        dropDownWordLength.getChildren().addAll(new Label("Guess"),wordLength,new Label("letter words"));
        dropDownWordLength.setAlignment(Pos.CENTER);

        Button play=new Button("Play Now!!!");
        play.setDefaultButton(true);

        play.setOnAction(e->{
            CowBull.main(
                Integer.parseInt(noOfPlayers.getValue().toString()),
                Integer.parseInt(wordLength.getValue().toString())
            );
        });

        VBox layout=new VBox(20);
        layout.getChildren().addAll(dropDownPlayers,dropDownWordLength,play);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10,10,15,10));
        Scene scene=new Scene(layout,350,200);
        stage.setScene(scene);
        stage.show();
    }
}
