import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		String clientSentence;
		String capitalizedSentence;
		
		// Listening on the specified port
		ServerSocket welcomeSocket = new ServerSocket(6789);
		
		boolean running = true;
		
		while (running) {
			// Acepting a blocking call
			Socket connectionSocket = welcomeSocket.accept();
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			clientSentence = inFromClient.readLine();
			
			Thread.sleep(1000);
			
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			
			if ("quit".equalsIgnoreCase(clientSentence)) {
                running = false;
                outToClient.writeBytes("Server shutting down\n");
            }
			else
				outToClient.writeBytes(capitalizedSentence);
		}
	}
}
