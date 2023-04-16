import java.io.IOException;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws IOException {		
		ServerSocket welcomeSocket = new ServerSocket(6789);
		MessageQueue messagesQueue = new MessageQueue();
		
		while (true)
		{
			Socket s = welcomeSocket.accept();
			
			new InServerThread(s, messagesQueue).start();
			new OutServerThread(s, messagesQueue).start();			
		}
	}

}
