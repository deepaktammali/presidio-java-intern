package labtestsolutions;

import java.util.Arrays;

public class ReverseRowsQ19 {
	public static void main(String[] args) {
		
		int arr[][] = {{1,2,4},{2,43,1},{23,83,66}};
		RectangularArray.printArray(arr);
		int[][] rowReversedArr = RectangularArray.reverseArrayRows(arr);
		
		System.out.println("Result : ");
		RectangularArray.printArray(rowReversedArr);
	}
}
