package lab5;

import java.util.Arrays;

public class Array {
	public static void swapArrays(int[] arr1,int[] arr2) {
		
	}
	
	public static void printArrayInReverse(int[] arr) {
		int N = arr.length;
		for(int i=(N-1);i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void findLargestAndSmallest(int[] arr) {
		int maxElement = Integer.MIN_VALUE;
		int minElement = Integer.MAX_VALUE;
		
		for(int i:arr) {
			if(i>maxElement) {
				maxElement = i;
			}
			if(i<minElement) {
				minElement = i;
			}
		}
		
		System.out.println("The Largest Element is "+maxElement);
		System.out.println("The Smallest Element is "+minElement);
	}
	
	
}
