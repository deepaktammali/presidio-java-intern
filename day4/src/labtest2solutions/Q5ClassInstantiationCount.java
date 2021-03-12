package labtest2solutions;

public class Q5ClassInstantiationCount {
	public static void main(String[] args) {
		Room room1 = new Room();
		Room.printNumInstantiations();
		Room room2 = new Room();
		Room room3 = new Room();
		Room.printNumInstantiations();
		Room room4 = new Room();
		Room room5 = new Room();
		Room.printNumInstantiations();
	}
}

class Room{
	private static int numInstantiations = 0;
	
	Room(){
		numInstantiations+=1;
	}

	public static void printNumInstantiations() {
		System.out.println(numInstantiations) ;
	}
}
