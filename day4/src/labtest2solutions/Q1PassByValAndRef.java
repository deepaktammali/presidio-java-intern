package labtest2solutions;

import java.util.Arrays;

public class Q1PassByValAndRef {

	private static void modifyPages(Book book) {
		book.numPages+=100;
	}
	
	private static void modifyArray(int arr[]) {
		arr[2] = 5;
	}
	
	private static void modify(int intVar) {
		intVar=100;
	}
	
	private static void modify(boolean booleanVar) {
		booleanVar=false;
	}
	
	private static void modify(double doubleVar) {
		doubleVar = 200.1;
	}
	
	private static void modify(String text) {
		text="modified";
	}
	
	public static void main(String args[]) {
		
//		Objects are pass by reference
		Book myBook = new Book(100);
		System.out.println(myBook.numPages);
		modifyPages(myBook);
		System.out.println(myBook.numPages);
		
//		arrays are pass by reference
		int[] arr = {1,1,1,1,1,1};
		System.out.println(Arrays.toString(arr));
		modifyArray(arr);
		System.out.println(Arrays.toString(arr));

//		Strings are pass by value
		String text="unmodified";
		modify(text);
		System.out.println(text);
		
//		primitive types are pass by value
		
		int intVar=10;
		modify(intVar);
		System.out.println(intVar);
		
		double doubleVar=2.5;
		modify(doubleVar);
		System.out.println(doubleVar);
		
		boolean booleanVar=true;
		modify(booleanVar);
		System.out.println(booleanVar);
		
		
	}
}

class Book{
	public int numPages;
	Book(int numPages){
		this.numPages = numPages;
	}
}