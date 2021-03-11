package day4;

public class ProtectedMemberQ23 {
	public static void main(String[] args) {
		Cycle myCycle = new Cycle();
		myCycle.setNumWheels(2);
	}
}


class Vehicle{
	protected int numWheels;
	
	Vehicle(){
		
	}

	public int getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
}

class Cycle extends Vehicle{
	Cycle(){
		super();
	}
	
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
}
