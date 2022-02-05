package com.online_tutorials.java_gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game_Obstruction extends Application implements EventHandler<ActionEvent> {

    Button b[][]=new Button[8][8];
    int count=0;

    public static void main(String []args){launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Grid");

        GridPane grid=new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        //grid.setVgap(8);
        //grid.setHgap(10);

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                b[i][j] = new Button("");
                b[i][j].setMinSize(40,40);
                b[i][j].setStyle("-fx-border-color: black");
                GridPane.setConstraints(b[i][j],i,j);
                b[i][j].setOnAction(this);
                if(i!=0&&i!=7&&j!=0&&j!=7)
                    grid.getChildren().add(b[i][j]);
            }
        }

        stage.setOnCloseRequest(e -> {
            if(!isOver()) {
                e.consume();
                if (ConfirmBox.display("Exit","Are you sure you want to Exit?"))
                    stage.close();
            }
        });

        Scene scene=new Scene(grid);
        scene.getStylesheets().add("Game_Obstruction.css");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                if(actionEvent.getSource()==b[i][j]){
                    if(!(b[i][j].getText().equals("")))
                        return;
                    else{
                        for(int p=i-1;p<=i+1;p++) {
                            for (int q = j - 1; q <= j + 1; q++) {
                                if(b[p][q].getText().equals("")) {
                                    b[p][q].setStyle("-fx-background-color: #dde3ed");
                                    b[p][q].setText(" ");
                                }
                            }
                        }
                        b[i][j].setText((count++%2==1)? "O":"X");
                    }
                }
            }
        }
        if(isOver()){
            AlertBox.display("Game Over","Player "+((count%2==1)?1:2)+" has won!!");
        }
    }

    boolean isOver(){
        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++) {
                if(b[i][j].getText().equals(""))
                    return false;
            }
        }
        return true;
    }
}