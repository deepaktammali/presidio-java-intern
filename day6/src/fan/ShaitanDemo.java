package fan;

import java.util.Scanner;

public class ShaitanDemo {
	public static void main(String[] args) {
		Shaitan shaitan = new Shaitan();
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter to pull the chain...");
			scan.nextLine();
			shaitan.pull();
		}
	}
}

class ShaitanState {
	private int currState;
	private final String[] states = { "On", "Medium Speed", "High Speed", "Off" };

	ShaitanState() {
		this.currState = 3;
	}

	public String getState() {
		return this.states[this.currState];
	}

	public void nextState() {
		this.currState = (this.currState + 1) % states.length;
	}
}



class Shaitan {
	ShaitanState shaitanState = new ShaitanState();

	public void pull() {
		shaitanState.nextState();
		System.out.println("Current fan state is " + shaitanState.getState());
	}

}