package lab2;

import java.util.Scanner;

public class Q26 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		scanner.close();
		
//		swap
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		
	}
}
