
public class Room {
	private int roomCapacity;
	private int currentRoomCapacity = 0;
	private int catsInside = 0;
	
	public Room(int rc) {
		roomCapacity = rc;
	}
	
	public synchronized void enterRoom(AnimalType at) throws InterruptedException {
		
		while ((at.ordinal() == 1 && currentRoomCapacity > 0) || (at.ordinal() == 0 && catsInside > 0) || currentRoomCapacity >= (roomCapacity - 1))
			this.wait(); // invece che mettere i thread in sleep metto me stesso in sleep
		
		if (at.ordinal() == 1)
			catsInside += 1;
		
		currentRoomCapacity++;
		
		System.out.println("A " + at.toString() + " is entering the ROOM");
	}
	
	public synchronized void leaveRoom(AnimalType at) {
		currentRoomCapacity--;
		
		System.out.println("A " + at.toString() + " is leaving the ROOM");
		
		if (at.ordinal() == 1)
			catsInside -= 1;
		
		this.notify();
	}
}
