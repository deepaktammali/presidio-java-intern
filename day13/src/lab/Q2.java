package lab;

import java.util.*;

public class Q2 {
	//If the hashCode() comparison == returns true, the equals() method must return true
	public static void main(String[] args) {
		ArrayList<Integer> intArray1 = new ArrayList<>();
		intArray1.add(1);
		intArray1.add(3);
		intArray1.add(2);
		ArrayList<Integer> intArray2 = new ArrayList<>();
		intArray2.add(1);
		intArray2.add(3);
		intArray2.add(2);
		
		System.out.println(intArray1.hashCode());
		System.out.println(intArray2.hashCode());
		System.out.println(intArray1.equals(intArray2));
	}
}
