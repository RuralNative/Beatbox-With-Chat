package org.ruralnative.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Network {
    String ipAddress = "";
    int portNumber = 0;
    Socket chatSocket;
    InputStreamReader inputStreamReader;
    BufferedReader networkReader;
    PrintWriter networkWriter;

    Network(String ipAddress, int portNumber) {
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        try {
            chatSocket = new Socket(this.ipAddress, this.portNumber);
            this.inputStreamReader = new InputStreamReader(chatSocket.getInputStream());
            this.networkReader = new BufferedReader(this.inputStreamReader);
            this.networkWriter = new PrintWriter(chatSocket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Network Connection Init FAILED");
            System.out.println("SOURCE: Network()");
            System.out.println("IP/Port unidentified or I/O error occurred");
        }
    }

    public String readMessage() {
        String message = "Empty Network Message";
        try {
            message = networkReader.readLine();
        } catch (Exception e) {
            System.out.println("Read Network Message FAILED");
            System.out.println("SOURCE: readMessage()");
            System.out.println("I/O error occurred");
        }
        return message;
    }

    public void sendMessage(String message) {
        networkWriter.println(message);
    }

    public void closeConnection() {
        try {
            chatSocket.close();
        } catch (IOException e) {
            System.out.println("Socket Connection Closing FAILED");
            System.out.println("SOURCE: closeConnection()");
            System.out.println("I/O error occurred");
        }
    }
}
