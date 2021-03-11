package corejavatest;

public class Base extends Parent {
		static int i = 200;
		public static void main(String[] args) {
			Base base = new Base();
			base.someMethod();
		}
		
		public void someMethod() {
			System.out.println("Base someMethod");
			System.out.println(i);
		}
}

class Parent {
	
	Parent(){
		int i = 100;
		System.out.println(i);
	}
	
	private void someMethod() {
		System.out.println("Parent someMethod");
	}
}
