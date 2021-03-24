package lab;

import java.util.*;

// B. ArrayList<Integer> input = null; List<Integer> output = null;
// F. List<Integer> input = null; List<Integer> output = null;
// E. List<Number> input = null; List<Number> output = null;

public class Q8 {
	public static <E extends Number> List<E> process(List<E> nums) {
		
		List<E> input = null; 
		 List<E> output = null; 
		output = process(input);
		return output;

	}

	public static void main(String[] args) {
//		output = process(input);
		List<Integer> input = null; 
		 List<Integer> output = null; 
		output = process(input);
	}
}
