import java.util.*;

public class MessageQueue {
	private List<String> messages;
	private int clients;
	private int numberOfReads;
	
	public MessageQueue()
	{
		messages = new ArrayList<>();
		numberOfReads = 0;
	}
	
	public synchronized void registerClient() {
		++clients;
		System.out.println("Registered client number :-" + clients);
	}
	
	public synchronized void add(String message) {
		if (message == null)
			return;
		
		System.out.println("Adding message :- " + message);
		
		messages.add(message);
		this.notifyAll();
	}
	
	public synchronized String popHead() throws InterruptedException {
		while (messages.isEmpty())
			this.wait();
		
		String message = messages.get(0);
		++numberOfReads;
		
		if (numberOfReads == clients)
		{
			numberOfReads = 0;
			messages.remove(0);
		}
		
		System.out.println("Reading message :- " + message);
		
		return message;
	}
}
