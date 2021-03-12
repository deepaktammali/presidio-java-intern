package lab2;
import java.util.*;
public class Q25 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		scanner.close();
		
		if(num1>num2 && num1>num3) {
			System.out.println(num1+" is largest");
		}
		else if(num2>num3) {
			System.out.println(num2+" is largest");
		}
		else {
			System.out.println(num3+" is largest");
		}
	}
}
