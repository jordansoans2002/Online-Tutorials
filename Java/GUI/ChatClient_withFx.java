package com.online_tutorials.java_gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient_withFx extends Application {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;

    private TextField msgInput;
    Stage window;Scene scene;
    HBox chats;VBox inChats,outChats;
    Scanner sc;

    private String serverIP;

    public static void main(String []args){launch();}

    @Override
    public void start(Stage stage){
        serverIP="127.0.0.1";

        window=stage;
        window.setTitle("Client_Chat Application");
        window.setOnCloseRequest(e-> closeChatbox());
        inChats=new VBox(10);
        inChats.setAlignment(Pos.BASELINE_LEFT);

        outChats=new VBox(10);
        outChats.setAlignment(Pos.BASELINE_RIGHT);

        chats=new HBox(5);
        chats.getChildren().addAll(inChats,outChats);

        /*msgInput =new TextField();
        //msgInput.setEditable(false);
        outChats.getChildren().add(msgInput);
        msgInput.setOnKeyPressed(e->{
            if(e.getCode()== KeyCode.ENTER) {
                sendMsg(msgInput.getText());
                msgInput.setText("");
            }
        });*/

        scene=new Scene(chats,300,200);
        window.setScene(scene);
        window.show();

        AlertBox.display("status","ready");
        //startRunning();

        try{
            connectToServer();
            setupStreams();
            //whileChatting();
            chat();
        }catch(EOFException eofException){
            System.out.println("server ended connection");
            AlertBox.display("Connection Closed","Server ended connection");
        }catch (IOException ioException){
            ioException.printStackTrace();
        }finally {
            closeChatbox();
        }
    }

    public void startRunning(){
        try{
            connectToServer();
            setupStreams();
            //whileChatting();
            chat();
        }catch(EOFException eofException){
            System.out.println("server ended connection");
            AlertBox.display("Connection Closed","Server ended connection");
        }catch (IOException ioException){
            ioException.printStackTrace();
        }finally {
            closeChatbox();
        }
    }

    private void connectToServer()throws IOException{
        AlertBox.display("Status","Making connection...");
        System.out.println("Making connection");
        connection = new Socket(InetAddress.getByName(serverIP), 5555);
        System.out.println("Connection made with "+connection.getInetAddress().getHostName());
        AlertBox.display("Status","Connected to "+connection.getInetAddress().getHostName());
    }

    private void setupStreams()throws IOException{
        output=new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input=new ObjectInputStream(connection.getInputStream());
        System.out.println("Stream setup");
        AlertBox.display("Status","Stream is set up");
    }

    void chat()throws IOException{
        sc=new Scanner(System.in);
        String msg="";
        do {
            msg = sc.nextLine();
            output.writeObject(msg);
            outChats.getChildren().add(new Label(msg));
        } while (!msg.equals("END"));
    }

    /*private void whileChatting()throws IOException{
        msgInput.setEditable(true);
        String msg="you can now send messages";
        sendMsg(msg);
        do{
            try{
                msg=input.readObject().toString();
                System.out.println(msg);
                inChats.getChildren().add(new Label(msg));
            }catch(ClassNotFoundException classNotFoundException){
                System.out.println("invalid msg");
                AlertBox.display("Status","Invalid message");
                break;
            }catch(IOException e){
                System.out.println("error");
                break;
            }
        }while(!msg.equals("END"));
    }*/

    private void sendMsg(String msg){
        try{
            output.writeObject(msg);
            outChats.getChildren().add(new Label(msg));
            output.flush();
        }catch(IOException ioException){
            System.out.println("message cant be sent");
            AlertBox.display("Error","message cant be sent");
        }
    }

    private void closeChatbox(){
        System.out.println("closing connection");
        AlertBox.display("Status","Closing connection");
        msgInput.setEditable(false);
        try{
            input.close();
            output.close();
            connection.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }finally {
            window.close();
        }
    }
}