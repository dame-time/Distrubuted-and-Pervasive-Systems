import java.util.Random;

public class AnimalThread extends Thread {

	private Room room;
	public AnimalType animalType;
	
	public AnimalThread(AnimalType at, Room r) {
		animalType = at;
		room = r;
	}
	
	public AnimalThread(int at, Room r) {
		if (at == 0)
			animalType = AnimalType.DOG;
		else
			animalType = AnimalType.CAT;
		
		room = r;
	}
	
	@Override
	public void run() {
		Random rand = new Random();
		
		try {
			room.enterRoom(animalType);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		int randomNum = rand.nextInt(1000) + 1000;
		try {
			Thread.sleep(randomNum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		room.leaveRoom(animalType);
	}

}
