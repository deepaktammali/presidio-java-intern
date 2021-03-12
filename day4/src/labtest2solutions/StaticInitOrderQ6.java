package labtest2solutions;

public class StaticInitOrderQ6 {
	public static void main(String[] args) {
		StaticInitOrder staticInitOrder1 = new StaticInitOrder(2);
		StaticInitOrder staticInitOrder2 = new StaticInitOrder(4);
		
	}
}


class StaticInitOrder{
	private int staticVar;
	
	StaticInitOrder(int var){
		this.staticVar = var;
		System.out.println("One Arg Constructor Called");
	}
	
	
	static {
		System.out.println("Static init 1 called");
	}
	static {
		System.out.println("Static init 2 called");
	}
	static {
		System.out.println("Static init 3 called");
	}
}