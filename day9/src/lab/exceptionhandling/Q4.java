package lab.exceptionhandling;

public class Q4 {
	public static void main(String[] args) {
		try {
			Dog dog = new Dog("Puppy");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

class Dog{
	String name;
	public Dog(String name) throws ConstructorException {
		this.name = name;
		throw new ConstructorException();
	}
}


class ConstructorException extends Exception{
	public ConstructorException() {
		super("Exception In Constructor.");
	}
}