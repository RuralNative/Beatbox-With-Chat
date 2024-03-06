package org.ruralnative.network;

import java.io.InputStreamReader;
import java.net.Socket;

public class Network {
    String ipAddress = "";
    int portNumber = 0;
    Socket chatSocket;
    InputStreamReader inputStreamReader;

    Network(String ipAddress, int portNumber) {
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        try {
            chatSocket = new Socket(ipAddress, portNumber);
            this.inputStreamReader = new InputStreamReader(chatSocket.getInputStream());
        } catch (Exception e) {
            System.out.println("Network Connection Init FAILED");
            System.out.println("SOURCE: Network()");
            System.out.println("IP/Port unidentified or I/O error occured");
        }
    }
}
