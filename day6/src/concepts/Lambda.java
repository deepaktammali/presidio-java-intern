package concepts;

public class Lambda {
	public static void main(String[] args) {
		
//		lambda
		NamePrinter namePrinter = (String name)->{System.out.println("The name is "+name);};
//		anonymous
		NamePrinter namePrinter2 = new NamePrinter() {
			@Override
			public void printName(String name) {
				System.out.println("The name is "+name);
			}
		};
		
		namePrinter.printName("Deepak");
		namePrinter2.printName("Deepak");
	}
}

@FunctionalInterface
interface NamePrinter{
	public void printName(String name);
}



