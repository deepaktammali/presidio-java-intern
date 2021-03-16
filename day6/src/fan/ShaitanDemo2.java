//package fan;
//
//import java.util.Scanner;
//
//public class ShaitanDemo2 {
//	public static void main(String[] args) {
//		Shaitan shaitan = new Shaitan();
//		while (true) {
//			Scanner scan = new Scanner(System.in);
//			System.out.println("Enter to pull the chain...");
//			scan.nextLine();
//			shaitan.pull();
//		}
//	}
//}
//
//
//class ShaitanState {
//	private int state;
//
//	public ShaitanState(int state) {
//		this.state = state;
//	}
//
//	public int getState() {
//		return state;
//	}
//}
//
//class Shaitan {
//	ShaitanState shaitanState;
//	
//	public Shaitan(ShaitanState shaitanState) {
//		this.shaitanState = shaitanState;
//	}
//
//	public void setShaitanState(ShaitanState shaitanState) {
//		this.shaitanState = shaitanState;
//	}
//
//	public void pull() {
//		System.out.println("Current fan state is " + getShaitanState().getState());
//	}
//
//}