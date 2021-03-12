package lab2;

public class Rectangle {

	public static double findArea(double size) {
		return findArea(size,size);
	}
	
	public static double findArea(double a,double b) {
		return a*b;
	}
	
	public static double findPerimeter(double size) {
		return findArea(size,size);
	}
	
	public static double findPerimeter(double a,double b) {
		return 2*(a+b);
	}
	
}
