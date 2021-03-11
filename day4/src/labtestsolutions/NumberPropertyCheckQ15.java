package labtestsolutions;

public class NumberPropertyCheckQ15 {
	public static boolean isArmstrong(int num) {
		String numString = ""+num;
		int sumOfCubes=0;
		for(char ch:numString.toCharArray()) {
			sumOfCubes+= Math.pow((int)(ch)-48,3);
		}
		
		return sumOfCubes==num;
	}
	
	public static boolean isPalindrome(int num) {
		String numString = ""+num;
		String reversedString="";
		for(int i=0;i<numString.length();i++) {
			reversedString+=numString.toCharArray()[numString.length()-i-1];
		}
		return numString.equals(reversedString);
	}
	
	public static boolean isPerfect(int num) {
		if(num<=2) {
			return false;
		}
		int divisorSum=1;
		for(int i=2;i<num;i++) {
			if(num%i==0) {
				divisorSum+=i;
			}
		}
		return divisorSum==num;
	}
	
	public static void checkAllProperties(int num) {
		System.out.println("Is "+num+" perfect? "+isPerfect(num));
		System.out.println("Is "+num+" palindrome? "+isPalindrome(num));
		System.out.println("Is "+num+" armstrong? "+isArmstrong(num));	
	}
	
	public static void main(String[] args) {
		int num=28;
		checkAllProperties(num);
		num=12321;
		checkAllProperties(num);
		num=153;
		checkAllProperties(num);
		
	}
}
