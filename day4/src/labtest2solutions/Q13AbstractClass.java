package labtest2solutions;

public class Q13AbstractClass {

	public static void main(String[] args) {
//		Animal lion = new Animal(); cannot instantiate
	}
	
}

abstract class Animal{
	private String habitat;
	abstract String getAnimalSound();
	abstract String getAnimalHabitat();
}
