package lab.exceptionhandling;

import java.util.Arrays;
import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] marks = new int[10];
		int i = 0;
		int totalMarks = 0;

		while (i < 10) {
			try {
				System.out.print("Enter marks of student " + (i + 1) + " :");
				int mark = Integer.parseInt(scanner.nextLine());
				if (mark > 100 || mark < 0) {
					throw new MarksOutOfException();
				}
				i += 1;
			} catch (MarksOutOfException me) {
				System.out.println(me);
			} catch (Exception e) {
				System.out.println("Enter a valid input i.e a number");
			}
		}

		for (

		int mark : marks) {
			totalMarks += mark;
		}

		System.out.println("The average mark of 10 students is : " + (totalMarks / 10));
	}
}
