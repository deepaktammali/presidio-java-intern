package lab2;

public class Q24 {
	public static void main(String[] args) {
//		square
		double size = 2.1;
		double area = Rectangle.findArea(size);
		double perimeter = Rectangle.findPerimeter(size);
		
		System.out.printf("The area of square of size %f is %f",size,area).println();
		System.out.printf("The perimeter of square of size %f is %f",size,perimeter).println();
		
//		Rectangle
		double a = 4.3;
		double b = 2.3;
		area = Rectangle.findArea(a,b);
		perimeter = Rectangle.findPerimeter(a,b);
		
		System.out.printf("The area of rectangle of size %f x %f is %f",a,b,area).println();
		System.out.printf("The perimeter of square of size %f x %f is %f",a,b,perimeter).println();
		
	}
}
