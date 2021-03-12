package labtest2solutions;

public class AccessModifiersQ9 {
	public static void Main(String[] args) {
		
	}
}

class A1{
	private int privateVar;
	public int publicVar;
	protected int protectedVar;
	
}

class B1 extends A1{
	private int privateBVar;
	
	public void accessVars() {
//		System.out.println(this.privateVar);not visible
		System.out.println(this.publicVar);
		System.out.println(this.protectedVar);
	}
}