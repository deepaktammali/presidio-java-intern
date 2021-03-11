package Arrays;

public class Arrays {
	public static void main(String[] args) {
//		1D arrays
		int array1[] = new int[5];//declaration and instantiation
		for(int i:array1) {
			System.out.println(i); //array values will have a default value of zero
		}
		
		int array2[] = {1,2,3,4,5}; //declaration and initialization
		for(int i:array2) {
			System.out.println(i);
		}
		
//		2D arrays
		int array3[][] = new int[2][2];
		for(int i[]:array3) {
			for(int j:i) {
				System.out.println(j);
			}
		}
		
		int array4[][] = {{1,2},{3,4}};
		for (int i=0;i<array4.length;i++) {
			for (int j=0;j<array4[0].length;j++) {
				System.out.println(array4[i][j]);
			}
		}
		
//		array copy method
		
		boolean array5[] = new boolean[5];
		boolean array5DeepCopy[] = new boolean[5];
		boolean array5ShallowCopy[] = new boolean[5];
//		System.arraycopy(array5, 0, array5DeepCopy, 0, 5); //deepcopy
		array5DeepCopy = array5.clone();
		array5ShallowCopy = array5;
		
		System.out.println(array5+" original");
		System.out.println(array5DeepCopy+" deepcopy "+(array5DeepCopy==array5));
		System.out.println(array5ShallowCopy+" shallowcopy "+(array5ShallowCopy==array5));
		
//		zero size array
		int array6[]= {};
		System.out.println(array6.length);
		
		
	}
}
