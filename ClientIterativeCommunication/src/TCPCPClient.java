import java.io.*;
import java.net.*;

public class TCPCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String sentence;
		String modifiedSentence;
		
		// Input stream init
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		// Client socket init
		Socket clientSocket = new Socket("localhost", 6789);
		
		// Setting the output stream to the socket
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		// Setting the input stream coming from the server
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		sentence = inFromUser.readLine();
		
		// Send line to the server
		outToServer.writeBytes(sentence + "\n");
		
		modifiedSentence = inFromServer.readLine();
		
		System.out.println("FROM SERVER -> " + modifiedSentence);
		clientSocket.close();
	}

}
