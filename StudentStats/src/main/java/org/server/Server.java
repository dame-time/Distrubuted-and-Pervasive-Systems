package org.server;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        ServerSocket welcomeSocket = new ServerSocket(6789);

        Socket serverSocket = welcomeSocket.accept();

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        System.out.println(inFromClient.readLine() + "\n");

        serverSocket.close();
        welcomeSocket.close();
    }
}
