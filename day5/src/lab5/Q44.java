package lab5;

import java.util.Arrays;

public class Q44 {
	public static void main(String[] args) {
		int[] arr1 = {1,3,4,5};
		int[] arr2 = {2,6,7,8};
		
		for(int i=0;i<arr1.length;i++) {
			arr1[i] = arr1[i] + arr2[i];
			arr2[i] = arr1[i] - arr2[i];
			arr1[i] = arr1[i] - arr2[i];
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}
