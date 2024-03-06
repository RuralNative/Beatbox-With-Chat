package org.ruralnative.network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    ServerSocket server;
    Socket clientSocket;
    PrintWriter networkWriter;

    public ChatServer() {
        try {
            server = new ServerSocket(4000);
            while (true) {
                clientSocket = server.accept();
                networkWriter = new PrintWriter(clientSocket.getOutputStream());
                networkWriter.println("Wow, ang galing");
                networkWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
