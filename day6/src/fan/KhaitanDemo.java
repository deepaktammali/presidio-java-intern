package fan;

import java.util.Scanner;

public class KhaitanDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Fan myFan = new Fan();
		while(true) {
			System.out.println("Enter to goto next fan state");
			scanner.nextLine();
			myFan.pull();
		}
	}
}

class Fan{
	private FanState state;
	public Fan() {
		this.state = new OffState();
	}
	
	public void setState(FanState fanState) {
		this.state = fanState;
	}
	
	public void pull() {
		this.state.pull(this);
	}
	
}

abstract class FanState{
	public abstract void pull(Fan fan);
}

class OffState extends FanState{
	@Override
	public void pull(Fan fan) {
		System.out.println("Switch on state");
		fan.setState(new OnState());
	}
}

class OnState extends FanState{
	@Override
	public void pull(Fan fan) {
		System.out.println("Medium Speed state");
		fan.setState(new MediumSpeedState());
	}
}

class MediumSpeedState extends FanState{
	@Override
	public void pull(Fan fan) {
		System.out.println("Fast speed state");
		fan.setState(new FastSpeedState());
	}
}

class FastSpeedState extends FanState{
	@Override
	public void pull(Fan fan) {
		System.out.println("Switch off state");
		fan.setState(new OffState());
	}
}



