package labtestsolutions;

import java.util.Scanner;
import java.util.Arrays;

public class NumberToWordsQ18 {

	private static String digitToWords[] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
	
	
	public static void convertNumberToWords(int number) {
		int[] arr = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		for(int i=1;i<=10;i++) {
			arr[i-1] = (int)(number%10);
			number=number/10;
			if(number==0) {
				break;
			}
		}
		
		String word = "";
		for(int i=9;i>=0;i--) {
			if(arr[i]==-1) {
				continue;
			}
			word+=digitToWords[arr[i]];
		}
		System.out.println(word);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int number = sc.nextInt();
		sc.close();
		convertNumberToWords(number);
	}
}

