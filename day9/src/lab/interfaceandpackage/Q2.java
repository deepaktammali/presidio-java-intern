package lab.interfaceandpackage;

import java.awt.Shape;

public class Q2 {
	public static void main(String[] args) {
		Square square = new Square(4.2);
		
		ShapeProperties shapeProperties = new ShapeProperties();
		System.out.printf("Square with side %f has area %f",square.side,shapeProperties.calculateArea(square));
	}
}

class Circle{
	public double PI = Math.PI;
	public double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
}

class Square{
	public double side;

	public Square(double side) {
		super();
		this.side = side;
	}
	
}

class Triangle{
	public int a;
	public int b;
	public int c;
	public Triangle(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}

class Sphere{
	public double PI = Math.PI;
	public double radius;
	public Sphere(double radius) {
		this.radius = radius;
	}
}

class Cuboid{
	public double side;

	public Cuboid(double side) {
		super();
		this.side = side;
	}
	
}


interface CalcArea{
	double calculateArea(Circle circle);
	double calculateArea(Sphere sphere);
	double calculateArea(Triangle triangle);
	double calculateArea(Cuboid cuboid);
	double calculateArea(Square square);
}


interface CalcVolume{
	double calculateVolume(Sphere sphere);
	double calculateVolume(Cuboid cuboid);
}

class ShapeProperties implements CalcArea,CalcVolume{

	@Override
	public double calculateVolume(Sphere sphere) {
		// TODO Auto-generated method stub
		return ((double)4/3)*Math.pow(sphere.radius, 3)*sphere.PI;
	}

	@Override
	public double calculateVolume(Cuboid cuboid) {
		return Math.pow(cuboid.side, 3);
	}

	@Override
	public double calculateArea(Circle circle) {
		return (circle.PI*Math.pow(circle.radius, 3));
	}

	@Override
	public double calculateArea(Sphere sphere) {
		return (sphere.PI*Math.pow(sphere.radius, 3));
	}

	@Override
	public double calculateArea(Triangle triangle) {
		double s = (triangle.a+triangle.b+triangle.c)/2;
		return Math.sqrt(s*(s-triangle.a)*(s-triangle.b)*(s-triangle.c));
	}

	@Override
	public double calculateArea(Cuboid cuboid) {
		return 6*(Math.pow(cuboid.side, 2));
	}

	@Override
	public double calculateArea(Square square) {
		return Math.pow(square.side, 2);
	}
	
}
