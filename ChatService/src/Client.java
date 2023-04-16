import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 6789);
		
		new ClientInThread(s).start();
		
		while (true)
		{
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			outToServer.writeBytes(inFromUser.readLine() + "\n");
		}
	}

}
