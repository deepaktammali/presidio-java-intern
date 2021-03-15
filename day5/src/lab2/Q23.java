package lab2;

public class Q23{
	private static double pi = 3.141;

	public static double calculateArea(double radius,double height){
		double area = pi*Math.pow(radius,2) + 2*pi*radius*height;
		return area;
	}

	public static double calculateEnergy(double m,double a,double h,double v){
		double energy = m*(a*h+Math.pow(v,2)/2);
		return energy;
	}

	public static void main(String[] args){
		double radius = 2.1;
		double height = 5.4;
		double area = calculateArea(radius,height);


		double m = 10;
		double a = 9.8;
		double h = 100;
		double v = 20;
		double energy = calculateEnergy(m,a,h,v);
	}
}