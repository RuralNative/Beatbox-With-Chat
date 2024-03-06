package org.ruralnative;


import org.ruralnative.network.ChatClient;
import org.ruralnative.network.ChatServer;
import org.ruralnative.ui.beatbox.BeatboxView;

public class Main {
    public static void main(String[] args) {
        new ChatServer();
        ChatClient client = new ChatClient("127.0.0.1", 4000);
        String message = client.readMessage();
        System.out.println(message);
    }
}