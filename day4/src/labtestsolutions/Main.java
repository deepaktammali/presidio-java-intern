package labtestsolutions;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		//q1
		HelloWorld.print(); 
		
		//q2
		PrimitiveTypes.printDefault(); 
		
		//q4
		Prime.isPrime(7); 
		
		//q5
		int arr5[] = {1,4,2,6,9};
		Average.arrayAverage(arr5); 
		
		//q7
		int arr7[] = {2,5,1,6,3,8};	
		System.out.println("Array : "+Arrays.toString(arr7));
		Sort.sortArray(arr7);
		System.out.println("Asc sorted array "+ Arrays.toString(arr7) );
		Sort.sortArray(arr7,"des");
		System.out.println("Des sorted array "+ Arrays.toString(arr7) );
		
		//q8
		int arr8[] = {1,2,3,4,5}; 
		int elementIndex = Find.findElementPostion(arr8, 2);
		System.out.println("The element 2 is at "+elementIndex+" position in "+Arrays.toString(arr8));
		
		//q9
		int arr9[] = {1,2,3,4,5}; 
		System.out.println("Array : "+Arrays.toString(arr9));
		Reverse.reverseArray(arr9);
		System.out.println("Reversed Array"+ Arrays.toString(arr9) );
		
		//q10
		int arr10[][] = {{1,2,5},{3,4,6}};
		RectangularArray.printArray(arr10);
		
		//q11
		int arr11[][] = {{1,2,5},{3,4,6}};  //q11
		RectangularArray.printArray(arr11,"wedge");
		
		//12 the main program itself
//		System.out.println(args[0]);
		
		//q13
		
		//q24
		QuadraticEquationQ24 quadEquation = new QuadraticEquationQ24(2, 1, 3);
		System.out.println("The Computed Value is :" + quadEquation.computeValue(2));
		
	}
}


class HelloWorld{
	public static void print() {
		System.out.println("HelloWorld");
	}
}

class PrimitiveTypes{
	private static int intVar;
	private static boolean booleanVar;
	private static double doubleVar;

	public static void printDefault() {
		System.out.println("Int default is : " + intVar);
		System.out.println("Boolean default is : " + booleanVar);
		System.out.println("Double default is : " + doubleVar);
	}
}

class Prime{
	public static void isPrime(int number) {
		boolean isPrime=true;
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				isPrime=false;
				break;
			}
		}
		System.out.println("Is number "+number+" a prime? "+isPrime);
	}
}

class Average{
	public static void arrayAverage(int[] arr) {
		int runningSum=0;
		for(int i:arr) {
			runningSum+=i;
		}
		System.out.println("The average of array is : "+(runningSum/arr.length));
	}
}

class Reverse{
	public static void reverseArray(int[] arr) {
		for(int i=0;i<Math.floor(arr.length/2);i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-1-i] = temp;
		}
	}
}

class Sort{
	
	public static void sortArray(int[] arr,String order) {
		Arrays.sort(arr);
		if(order=="des") {
			Reverse.reverseArray(arr);
		}
	}
	
	public static void sortArray(int[] arr) {
		sortArray(arr,"asc");
	}
}

class Find{
	public static int findElementPostion(int[] arr,int element) {
		for (int i=0;i<arr.length;i++) {
			if(arr[i]==element) {
				return i;
			}
		}
		return -1;
	}
}

class RectangularArray{
	
	public static int[][] reverseArrayRows(int arr[][]) {
		final int rows = arr.length;
		final int cols = arr[0].length;
		
		int[][] result = new int[rows][cols];
		int currMax;
		for(int i=0;i<rows;i++) {
			currMax = Integer.MIN_VALUE;
			
			for (int j=0;j<cols;j++) {
					result[i][j] = arr[i][cols-1-j];
			}
		}
		
		return result;
	}
	
	
	public static int[] findLargestInEachRow(int arr[][]) {
		int[] result = new int[arr.length];
		int currMax;
		for(int i=0;i<arr.length;i++) {
			currMax = Integer.MIN_VALUE;
			
			for (int j=0;j<arr[0].length;j++) {
					currMax = Math.max(currMax,arr[i][j]);
			}
			result[i]=currMax;
		}
		return result;
	}
	
	private static void printRectagularStyleArray(int arr[][]) {
		for(int i[]:arr) {
			for (int j:i) {
					System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	private static void printWedgeStyleArray(int arr[][]){
		int currRow = 1;
		int printedElements=0;
		
		for(int i[]:arr) {
			for (int j:i) {
					System.out.print(j+" ");
					printedElements+=1;
					if(currRow==printedElements) {
						currRow+=1;
						printedElements=0;
						System.out.println();
					}
			}
		}
	}
	
	
	public static void printArray(int arr[][],String style) {
		if(style=="wedge") {
			printWedgeStyleArray(arr);
		}
		else {
			printRectagularStyleArray(arr);
		}
		
	}
	
	public static void printArray(int arr[][]) {
		printArray(arr,"rectangular");
	}
}





























