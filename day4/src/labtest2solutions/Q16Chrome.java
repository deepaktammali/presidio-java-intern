package labtest2solutions;

public class Q16Chrome {
	public static void main(String [] args) {  
		X x1 = new X(); 
		X x2 = new Y(); 
		Y y1 = new Y(); 
		((Y)x2).do2();  
		}
}

class X {
	void do1() {
	}

	public void do2() {

	}
}

class Y extends X {
	public void do2() {
	}
}
