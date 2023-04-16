package org.server;

import java.io.*;
import java.net.*;

public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket clientConnectionSocket = welcomeSocket.accept();

            new ServerInputThread(clientConnectionSocket).start();
        }
    }
}
