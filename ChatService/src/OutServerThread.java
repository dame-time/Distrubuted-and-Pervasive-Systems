import java.io.*;
import java.net.*;

public class OutServerThread extends Thread {

	private DataOutputStream outFromServer;
	private Socket socket;
	
	private MessageQueue messageQueue;
	
	public OutServerThread(Socket s, MessageQueue q) throws IOException {
		socket = s;
		
		outFromServer = new DataOutputStream(socket.getOutputStream());
		
		messageQueue = q;
	}
	
	@Override
	public void run() {
		while (true)
		{
			try {
				String response = messageQueue.popHead();
				
				System.out.println("Sending message :- " + response);
				
				outFromServer.writeBytes(response + "\n");
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
