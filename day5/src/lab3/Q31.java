package lab3;

public class Q31 {
	public static void main(String[] args) {
		double num1  = 12323;
		double num2  = 243;
		System.out.printf("The addition of %.1f and %.1f is %.1f",num1,num2,Calculator.add(num1, num2)).println();
		System.out.printf("The sub of %2.1f and %.1f is %f",num1,num2,Calculator.sub(num1, num2)).println();
		System.out.printf("The multiplication of %.1f and %.1f is %.1f",num1,num2,Calculator.mul(num1, num2)).println();
		System.out.printf("The division of %.1f and %.1f is %.3f",num1,num2,Calculator.div(num1, num2)).println();
	}
}


class Calculator{
	
	public static double add(double op1,double op2) {
		return op1+op2;
	}
	
	public static double sub(double op1,double op2) {
		return op1-op2;
	}
	
	public static double mul(double op1,double op2) {
		return op1*op2;
	}
	
	public static double div(double op1,double op2) {
		return op1/op2;
	}
	
}
