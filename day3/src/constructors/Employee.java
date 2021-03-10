package constructors;

public class Employee {
	private String name;
	
	Employee(){
		System.out.println("Constructor is called!");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
