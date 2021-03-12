package lab4;

public class Numbers {
	
	public static void isNumberPrime(int number) {
		boolean isPrime = true;
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				isPrime=false;
				break;
			}
		}
		System.out.println("Number "+number+" is prime?"+isPrime);
	}
	
//	inclusive
	public static int[] generateEvenInRange(int number) {
		int[] evenNumbers = new int[(int)Math.floor(number/2)];
		
		if(number<2) {
			return evenNumbers;
		}
		evenNumbers[0] = 2;
		int currEvenNumber = 2;
		int currIndex = 1;
		while(currEvenNumber<number) {
			currEvenNumber = currEvenNumber+2;
			evenNumbers[currIndex] = currEvenNumber;
			currIndex+=1;
		}
		
		return evenNumbers;
	}
	
//	exclusive
	public static double averageOddNumberInRange(int range) {
		if(range<0) {
			return -1;
		}
		if(range<=1) {
			return 0.5;
		}
		
		int oddNumberSum = 0;
		int currNum = 1;
		int oddNumberCount=0;
		while(currNum<range) {
			oddNumberCount+=1;
			oddNumberSum+=currNum;
			currNum+=2;
		}
		
		return ((double)oddNumberSum)/oddNumberCount;
	}
	
	public static double findAverage(int num1,int num2) {
		return (double)(num1+num2)/2;
	}
	
	public static int reverseNumber(int num) {
		int places = 0;
		int resultNum = 0;
		while (num>0) {
			resultNum = resultNum*10+num%10;
			num = num/10;
		}
		return resultNum;
	}
	
	public static int findDigitSum(int num) {
		int sum = 0;
		while (num>0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
	
	public static int[] generateFibonacci(int n) {
		int[] fib = new int[n];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2;i<n;i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib;
	}
	
	public static void generateMultiplicationTable(int n) {
		int i = 1;
		System.out.printf("%d Multiplication Table",n).println();
		do {
			System.out.printf("%d * %d = %d",n,i,n*i).println();
			i+=1;
		}while(i<=10);
	}
	
	public static void printWedge(int[] arr) {
		int currLineMaxPrintable = 1;
		
		int currLinePrinted = 0;
		for(int element:arr) {
			System.out.printf("%d ",element);
			currLinePrinted+=1;
			if(currLinePrinted==currLineMaxPrintable) {
				currLineMaxPrintable+=1;
				currLinePrinted=0;
				System.out.println();
			}
		}
		System.out.println();
	}
	
}























