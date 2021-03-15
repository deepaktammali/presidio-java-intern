package lab1;

public class Q1 {
	public static void main(String[] args) {
		int a, b;
		a = 15;
		b = 27;
		System.out.println("Before swapping : a, b = " + a + ", " + +b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After swapping : a, b = " + a + ", " + +b);
	}
}