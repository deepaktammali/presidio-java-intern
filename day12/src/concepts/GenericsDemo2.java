package concepts;

public class GenericsDemo2 {
	
//	Generic Methods
	public static <T> void printArray(T[] arr) {
		for(T element:arr) {
			System.out.printf("%s ",element);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		System.out.println("Integer Array");
		printArray(new Integer[] {1,2,3,4});
		System.out.println("Double Array");
		printArray(new Double[] {2.1,3.4,55.1,9.8});
		System.out.println("Char Array");
		printArray(new Character[] {'a','b','d','v','k'});
		
	}
}
