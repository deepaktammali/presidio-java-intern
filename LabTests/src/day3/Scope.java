package day3;

public class Scope {
	private int i;
	public static void main(String[] args) {
		Scope scope = new Scope();
//		scope.someMethod();
	}
	
	public static void someMethod() {
//		System.out.println(i);
	}
}
