package labtestsolutions;

public class ClassWithAllAccessModifiersQ22 {
	public static void main(String[] args) {
		Access accessObject = new Access();
//		accessObject.privateVar;cannot access
		accessObject.publicVar=1;
		accessObject.protectedVar=1;
		accessObject.defaultVar=1;
		
		accessObject.getDefaultMethod();
		accessObject.getPublicMethod();
//		accessObject.getPrivateMethod();cannot access
		accessObject.getProtectedMethod();
		
	}
}


class Access{
	private int privateVar;
	public int publicVar;
	protected int protectedVar;
	int defaultVar;
	
	public void getPublicMethod() {
		
	}
	
	private void getPrivateMethod() {
		
	}
	
	void getDefaultMethod() {
		
	}
	
	protected void getProtectedMethod() {
		
	}
	
}