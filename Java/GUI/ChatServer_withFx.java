package com.online_tutorials.java_networking;

import java.io.*;
import java.net.*;

import com.online_tutorials.java_gui.AlertBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatServer_withFx extends Application {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;

    //private TextField msgInput;
    Stage window;
    Scene scene;
    HBox chats;
    VBox inChats, outChats;
    int k = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("Server_Chat application");
        window.setOnCloseRequest(e -> closeChatbox());

        inChats = new VBox(10);

        outChats = new VBox(10);

        chats = new HBox(5);
        chats.getChildren().addAll(inChats, outChats);

        scene = new Scene(chats, 300, 200);
        window.setScene(scene);
        window.show();

/*        msgInput =new TextField();
        msgInput.setEditable(false);
        outChats.getChildren().add(msgInput);
        msgInput.setOnKeyPressed(e->{
            if(e.getCode()== KeyCode.ENTER) {
                sendMsg(msgInput.getText());
                msgInput.setText("");
            }
        });*/
        AlertBox.display("status", "ready");

        startRunning();
    }


    public void startRunning(){
        try{
            server=new ServerSocket(5555,10);
            while(true){
                try {
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                }catch(EOFException eofException){
                    AlertBox.display("Connection Closed","Server ended connection");
                }finally {
                    closeChatbox();
                }
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    private void waitForConnection()throws IOException{
        System.out.println("wating to connect");
        AlertBox.display("Status","Waiting for connection...");
        connection = server.accept();
        System.out.println("connected to "+connection.getInetAddress().getHostName());
        AlertBox.display("Status","connected to "+connection.getInetAddress().getHostName());
    }

    private void setupStreams()throws IOException{
        output =new ObjectOutputStream(connection.getOutputStream());
        output.flush();

        input=new ObjectInputStream(connection.getInputStream());

        System.out.println("stream setup");
        AlertBox.display("Status","Stream is set up");
    }

    private void whileChatting() throws IOException{
        String msg="you can now send messages";
        //sendMsg(msg);
        //msgInput.setEditable(true);
        do{
            try{
                msg=(String)input.readObject();
                System.out.println(msg);
            }catch (IOException e){
                System.out.println("invalid msg");
                AlertBox.display("Status","Invalid message");
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }while(!msg.equals("END"));
    }

    /*private void sendMsg(String msg){
        try{
            output.writeObject(msg);
            outChats.getChildren().add(new Label(msg));
            output.flush();
        }catch (IOException ioException){
            System.out.println("msg cant be sent");
            AlertBox.display("Error","message cant be sent");
        }
    }*/

    public void closeChatbox(){
        System.out.println("Closing connection");
        AlertBox.display("Status","Closing connection");
        //msgInput.setEditable(false);
        try{
            output.close();
            input.close();
            connection.close();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }finally {
            window.close();
        }
    }
}