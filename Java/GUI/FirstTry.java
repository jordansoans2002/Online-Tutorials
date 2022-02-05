package com.online_tutorials.java_gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

class Main{
    public static void main(String[] args) {
        FirstTry.main();
    }

}
class FirstTry extends Application {

    Button button;
    Label clicks;
    int count=0;
    Stage window;

    public static void main(){launch();}

    @Override
    public void start(Stage stage) throws IOException {
        window=stage;
        stage.setTitle("FirstTry");
        StackPane layout=new StackPane();
        Scene scene = new Scene(layout, 320, 240);

        button=new Button();
        button.setText("Click here");
        button.setOnAction(e->closeSequence());
        stage.setOnCloseRequest(e->{
            e.consume();
            closeSequence();
        });
        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                clicks.setText("Number of clicks are "+ ++count);

            }
        });*/
        layout.getChildren().add(button);
        stage.setScene(scene);
        stage.show();


    }

    public void closeSequence(){
    if(ConfirmBox.display("Confirm exit","Do you want to close"))
        window.close();
    }
}
