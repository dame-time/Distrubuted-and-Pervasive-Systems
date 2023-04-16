import java.io.*;
import java.net.*;

public class InServerThread extends Thread {

	private BufferedReader inFromSocket;
	private Socket connectionSocket;
	
	private MessageQueue messagesQueue;
	
	public InServerThread(Socket s, MessageQueue q) throws IOException
	{
		connectionSocket = s;
		
		inFromSocket = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		
		messagesQueue = q;
		
		messagesQueue.registerClient();
	}
	
	@Override
	public void run() {
		while (true)
		{
			try {
				String message = inFromSocket.readLine();
				
				if (message != null)
					messagesQueue.add(message);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
}
