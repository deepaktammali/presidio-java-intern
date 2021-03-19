package lab.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q7a {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			try {
				
				
				
				System.out.print("Enter the numerator : ");
				double numerator = Double.parseDouble(scanner.nextLine());
				
				System.out.print("Enter the denominator : ");
				double denominator = Double.parseDouble(scanner.nextLine());
				
				if (denominator == 0) {
					System.out.println("Cannot divide a number by zero");
					continue;
				}
				System.out.println("The result is " + (numerator / denominator));

			}catch (InputMismatchException ime) {
				System.out.println(ime);
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
