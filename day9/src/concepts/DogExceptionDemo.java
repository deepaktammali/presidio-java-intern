package concepts;

import java.util.Scanner;

public class DogExceptionDemo {
	public static void main(String[] args) throws Exception {
		Dog dog = new Dog();
		Child child = new Child();
		boolean isPlaying = true;
		Scanner scanner = new Scanner(System.in);
		while (isPlaying) {
			System.out.println("Enter the item name or /exit tot exit");
			String itemName = scanner.next();
			if (itemName.equals("/exit")) {
				isPlaying = false;
				continue;
			}

			Item item = (Item) Class.forName(itemName).getConstructor().newInstance();
			child.playWithDog(dog, item);
		}

		scanner.close();
		System.out.println("Program Exit");
	}
}

// The dog exception

abstract class DogException extends Exception {
	public DogException(String message) {
		super(message);
	}
	
	abstract public void handle(DogExceptionHandler dogExceptionHandler);
}

class DogBiteException extends DogException {
	public DogBiteException() {
		super("The dog bit.");
	}

	@Override
	public void handle(DogExceptionHandler dogExceptionHandler) {
		dogExceptionHandler.handle(this);
	}
}

class DogBarkException extends DogException {

	public DogBarkException() {
		super("The dog is barking.");
	}

	@Override
	public void handle(DogExceptionHandler dogExceptionHandler) {
		dogExceptionHandler.handle(this);
	}

}


//Dog Exception Handler

class DogExceptionHandler{
	public void handle(DogBarkException dogBarkException) {
		System.out.println("Barking handled");
	}
	
	public void handle(DogBiteException dogBiteException) {
		System.out.println("Dog bite handled");
	}
}

// Item classes

abstract class Item {

}

class Stone extends Item {
	public Stone() {
		// TODO Auto-generated constructor stub
	}
}

class Stick extends Item {
	public Stick() {
		// TODO Auto-generated constructor stub
	}
}

// Dog

class Dog {
	public void play(Item item) throws DogException {
		switch (item.getClass().getSimpleName()) {
		case "Stone": {
			throw new DogBarkException();
		}
		case "Stick": {
			throw new DogBiteException();
		}
		default: {
			System.out.println("The dog is happy.");
		}
		}
	}
}

// Child

class Child {
	public void playWithDog(Dog dog, Item item) {
		try {
			dog.play(item);
		} catch (DogException dogException) {
			dogException.handle(new DogExceptionHandler());
		}
	}
}

