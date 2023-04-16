package org.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ServerInputThread extends Thread {
    private Socket connectionSocket;

    public ServerInputThread(Socket s) {
        this.connectionSocket = s;
    }

    @Override
    public void run() {
        String green = "\033[32m";
        String reset = "\033[0m";

        try {
            BufferedReader inFromSocket = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            System.out.println(green + "Server received the Student: " + inFromSocket.readLine() + "\n" + reset);

            connectionSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
