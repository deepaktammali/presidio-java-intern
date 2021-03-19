package lab.exceptionhandling;

public class Q9 {

}

class MarksOutOfException extends Exception{
	public MarksOutOfException() {
		super("Marks should be in range 0-100");
	}
}
