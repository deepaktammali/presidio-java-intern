package day4;

public class GeneratePrimeQ15 {
	private final static int primeNumbers[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	
	public static void main(String[] args) {
		int primeIndex = (int) Math.floor(Math.random()*primeNumbers.length)+1;
		System.out.println("The prime is : "+primeNumbers[primeIndex]);
	}
}
