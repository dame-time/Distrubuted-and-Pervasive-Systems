import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Veterinarian {
	
	public static void main(String[] args) {
		List<Thread> animals = new ArrayList<>();
		Room room = new Room(4);
		
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			int randNumber = rand.nextInt(2);
			animals.add(new AnimalThread(randNumber, room));
		}	
		
		for (Thread t : animals)
			t.start();
	}
}
