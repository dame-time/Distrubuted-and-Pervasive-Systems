import java.io.*;
import java.net.*;

public class TCPMultiServer {

	public static void main(String[] args) throws IOException {
		ServerSocket welcomeSocket = new ServerSocket(6789);
		
		boolean running = true;
		while (running) {
			Socket connectionSocket = welcomeSocket.accept();
			
			TCPServerThread thread = new TCPServerThread(connectionSocket);
			
			thread.start();
		}
	}

}
