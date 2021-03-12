package labtest2solutions;

public class Q10Inheritance {
	public static void main(String[] args) {
		C cClass = new C();
	}
}

class A{
	A(){
		System.out.println("I am class A");
	}
}

class B{
	B(){
		System.out.println("I am class B");
	}
}

class C extends A{
	private B b;
}
