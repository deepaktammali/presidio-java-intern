package day4;

import java.util.Arrays;

public class FindRowMaxQ20 {
public static void main(String[] args) {
	int arr[][] = {{1,2,4},{2,43,1},{23,83,66}};
	System.out.println("Input : ");
	RectangularArray.printArray(arr);
	int rowMaxArr[] = RectangularArray.findLargestInEachRow(arr);
	System.out.println("Result : "+Arrays.toString(rowMaxArr));
}
}
