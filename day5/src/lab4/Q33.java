package lab4;
import java.util.Arrays;

public class Q33{
	public static void main(String[] args) {
		int maxNumber = 20;
		int[] evenNumArray = Numbers.generateEvenInRange(maxNumber);
		System.out.println(Arrays.toString(evenNumArray));
	}
}
