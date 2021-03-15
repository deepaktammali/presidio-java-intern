package lab6;

public class Q49{
	public static void main(String[] args){
		Box box = new Box(1,2,3);
		System.out.printf("The volume of box is %f",box.findVolume()).println();
	}
}

class Box{
	private double l;
	private double b;
	private double h;

	public Box(double l,double b,double h){
		this.l = l;
		this.b = b;
		this.h = h;
	}

	public double findVolume(){
		return l*b*h;
	}

}

