package accessmodifier;

public class PublicClass {
	public int publicVar;
	private double privateVar;
	String defaultVar;
	protected boolean protectedVar;
	
	public void getPublic() {
		System.out.println("Public");
	}
	
	void getDefault() {
		System.out.println("default");
	}
	
}
