package day4;

public class QuadraticEquationQ24 {
	private double a;
	private double b;
	private double c;
	
	
	public QuadraticEquationQ24(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double computeValue(int x) {
		return (a*Math.pow(x, 2)+b*x+c);
	}
	
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	
	
}
