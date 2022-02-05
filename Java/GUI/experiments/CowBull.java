package com.online_tutorials.java_gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CowBull{

    static Stage stage;
    String word;int no_of_guesses;

    CowBull(int word_length){
        word="snow";//getWord(word_length);
        no_of_guesses=0;
    }

    public static void main( int no_Of_Players,int word_length){
        stage = new Stage();
        stage.setTitle("Cow Bull");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOnCloseRequest(e-> {
            e.consume();
            if(ConfirmBox.display("Exit", "Are you sure you want to exit?"))
                stage.close();
        });

        HBox multiplayer = new HBox(22);
        multiplayer.setAlignment(Pos.CENTER);


        CowBull ob[]=new CowBull[no_Of_Players];
        for(int i=0;i<no_Of_Players;i++){
            ob[i]=new CowBull(word_length);
            multiplayer.getChildren().add(ob[i].display(word_length));
        }

        Scene scene = new Scene(multiplayer, 215*no_Of_Players, 300);
        stage.setScene(scene);
        stage.show();
    }

    public VBox display(int word_length) {
        TextField guess = new TextField();
        guess.setPromptText("Guess");
        guess.setPrefWidth(60);

        VBox guesses=new VBox(8);
        guesses.setPadding(new Insets(25,0,0,0));
        guesses.setAlignment(Pos.CENTER);
        guesses.setPrefWidth(55);

        VBox bull=new VBox(8);
        bull.setAlignment(Pos.CENTER);
        bull.getChildren().add( new Label("Bull"));
        bull.setPrefWidth(35);

        VBox cow=new VBox(8);
        cow.setAlignment(Pos.CENTER);
        cow.getChildren().add(new Label("Cow"));
        cow.setPrefWidth(35);

        HBox cow_bull=new HBox();
        cow_bull.getChildren().addAll(guesses,bull,cow);
        cow_bull.setPadding(new Insets(0,5,5,0));

        ScrollPane scroller=new ScrollPane();
        scroller.setContent(cow_bull);
        scroller.setPrefViewportHeight(230);
        scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Button submit = new Button("Submit");
        guess.setOnKeyPressed(e->{
            if(e.getCode().equals(KeyCode.ENTER))
                submit.fire();
        });
        submit.setOnAction(e -> {
            if (inputLength(guess,word_length)) {
                Label guessedWord = new Label(++no_of_guesses+". "+guess.getText());
                guesses.getChildren().add(guessedWord);
                String s=cows_bulls(guess,word,word_length);
                cow.getChildren().add(new Label(""+s.charAt(0)));
                bull.getChildren().add(new Label(""+s.charAt(1)));
                guess.clear();
            }
        });

        HBox head=new HBox(15);
        head.setPadding(new Insets(10, 0, 10, 10));
        head.getChildren().addAll(guess,submit);

        VBox layout=new VBox(5);
        layout.getChildren().addAll(head,scroller);
        layout.setAlignment(Pos.TOP_CENTER);

        return layout;
    }

    private boolean inputLength(TextField guess,int word_length){
        if(guess.getText().length()!=word_length) {
            AlertBox.display("Invalid Word", "Not a "+word_length+"-letter word");
            guess.clear();
            return false;
        }
        return true;
    }

    private String cows_bulls(TextField guessTxt,String word,int word_length){
        String guess=guessTxt.getText().toLowerCase();
        int cows=0,bulls=0;

        if(word.equalsIgnoreCase(guess)) {
            AlertBox.display("Winner", "Congratulations you guessed the word in "+no_of_guesses+" guesses");
            guessTxt.setEditable(false);
        }

        for(int i=0;i<word_length;i++){
            if(word.charAt(i)==guess.charAt(i))
                bulls++;
            else{
                for(int j=0;j<word_length;j++){
                    if(guess.charAt(i)==word.charAt(j))
                        cows++;
                }
            }
        }
        return cows+""+bulls;
    }
}
