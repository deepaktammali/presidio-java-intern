package lab.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q7b {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			try {
				System.out.print("Enter the numerator : ");
				
				String value = scanner.nextLine();
				if(value.startsWith("Q") || value.startsWith("q")) {
					break;
				}
				
				double numerator = Double.parseDouble(value);
				
				System.out.print("Enter the denominator : ");
				value = scanner.nextLine();
				if(value.startsWith("Q") || value.startsWith("q")) {
					break;
				}
				
				double denominator = Double.parseDouble(value);
				
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
