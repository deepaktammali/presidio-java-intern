package day4;

public class StaticAndConstVarQ17 {
	
	private static double pi = 3.14;
	
	public double getPI() { //static member in non static method
		return pi;
	}
	
	public static void main(String[] args) {
		final int i =1;
//		i=2; const var modification
	}
}

class OneArgConstructor{
	private int value;
	OneArgConstructor(){
		this(6);
	}
	
	OneArgConstructor(int value){
		this.value=value;
	}
}
