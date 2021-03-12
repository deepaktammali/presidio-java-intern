package labtest2solutions;

public class Q2ComplexAddition {
	public static void main(String[] args) {
		ComplexNumber cp1 = new ComplexNumber(2,3);
		ComplexNumber cp2 = new ComplexNumber(4,2);
		ComplexNumber result = ComplexNumber.addComplex(cp1, cp2);
		result.print();
	}
}

class ComplexNumber{
	private double realPart;
	private double imaginaryPart;
	
	ComplexNumber(double real,double imaginary){
		this.imaginaryPart = imaginary;
		this.realPart = real;
	}
	
	public void print() {
		System.out.println(realPart+" + "+"j"+imaginaryPart);
	}
	
	public static ComplexNumber addComplex(ComplexNumber op1,ComplexNumber op2) {
		double real = op1.realPart+op2.realPart;
		double imaginary = op1.imaginaryPart + op2.imaginaryPart;
		ComplexNumber result =  new ComplexNumber(real,imaginary);
		return result;
	}
	
}
