package labtestsolutions;

import java.util.Arrays;

public class StudentResultQ13 {

	public static int[] calculateResult(int[][] studentMarks) {
		int[] result = new int[studentMarks.length];
		for(int i=0;i<studentMarks.length;i++) {
			int totalMarks = 0;
			for(int j=0;j<studentMarks[0].length;j++) {
				totalMarks += studentMarks[i][j];
			}
			result[i] = totalMarks;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] studentMarks = { {92,90,94},
								 {100,89,92},
								 {96,93,88}};
		
		int[] cumulativeResult = calculateResult(studentMarks);
		
		System.out.println(Arrays.toString(cumulativeResult));
	}
	
}
