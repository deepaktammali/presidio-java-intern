package lab6;

public class Q47{
	
	public static int add(int a){
		return add(a,0);
	}

	public static int add(int a,int b){
		return a+b;
	}

	public static int add(int a,int b,int c){
		return (c+add(a,b));
	}

	public static void main(String[] args){
		int a = 1;
		int b = add(a);
		int c = add(a,b);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}