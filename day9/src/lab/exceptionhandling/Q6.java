package lab.exceptionhandling;

public class Q6 {
	public static void main(String[] args) {
		
	}
}


class Base{
	public Base() throws Exception{
		
	}
	
	public void getName(){
		System.out.println("Base");
	}
}

class Derived extends Base{
	public Derived() throws Exception{
		
	}
	
	@Override
	public void getName() {
		System.out.println("Base");
		super.getName();
	}
}

// base class constructor exceptions cannot be caught in the derived class constructor