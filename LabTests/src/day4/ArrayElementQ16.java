package day4;

public class ArrayElementQ16 {
	public static void main(String[] args) {
		int arr[] = {1,1,2,4,5,2,3,2,5,6,2,5,8,9,6,4};
		int element = 2;
		int elementCount = findElementCount(element,arr);
		
		if(elementCount>0) {
			System.out.println("Element found and count :"+elementCount);
		}
		else {
			System.out.println("Element not found");
		}
	}
	
	public static int findElementCount(int element,int arr[]) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==element) {
				count+=1;
			}
		}
		return count;
	}
}
