import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientInThread extends Thread {
	private BufferedReader inFromServer;
	
	private Socket socket;
	
	public ClientInThread(Socket s) throws IOException {
		socket = s;
		
		inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	@Override
	public void run() {
		while (true)
		{
			try {
				String messageFromServer = inFromServer.readLine();
				
				if (messageFromServer != null)
					System.out.println("Server Response: " + messageFromServer);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
