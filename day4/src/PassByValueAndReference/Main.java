package PassByValueAndReference;

public class Main {
	public static void main(String[] args) {
		Ball myBall = new Ball();
		System.out.println("The ball radius is : " + myBall.radius);
		RadiusModifier.modifyRadiusByValue(myBall.radius);
		System.out.println("The ball radius is (after modifying by value) : " + myBall.radius);
		RadiusModifier.modifyRadiusByReference(myBall);
		System.out.println("The ball radius is (after modifying by reference) : " + myBall.radius);
	}
}


class Ball{
	public double radius;
	Ball(){
		radius = 1;
	}
}

class RadiusModifier{
	public static void modifyRadiusByValue(double radius){
		radius += 10;
	}
	
	public static void modifyRadiusByReference(Ball ball) {
		ball.radius+=10;
	}
}
