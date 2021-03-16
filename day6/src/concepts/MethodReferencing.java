package concepts;

public class MethodReferencing {
	
	private String name = "method";
	
	public static void printHelloWorld() {
		System.out.println("Hello, World!");
	}
	
	public void printName(String name) {
		System.out.println("The name is "+this.name);
	}
	
	public static void add(int a,int b) {
		System.out.printf("The sum of %d and %d is %d",a,b,a+b).println();
	}
	
	public static void main(String[] args) {
		NoParameter noParameterFunctionalObject = MethodReferencing::printHelloWorld;
		noParameterFunctionalObject.printHelloWorld();
		
		SingleParameter singleParamFuncObj = new MethodReferencing()::printName;
		singleParamFuncObj.printName("LOL");
		
		TwoParameter twoParamFuncObj = MethodReferencing::add;
		twoParamFuncObj.add(5, 6);
	}
	
}


@FunctionalInterface
interface SingleParameter{
	public void printName(String name);
}

@FunctionalInterface
interface NoParameter{
	public void printHelloWorld();
}

@FunctionalInterface
interface TwoParameter{
	public void add(int a,int b);
}