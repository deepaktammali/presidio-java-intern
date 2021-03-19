package lab.interfaceandpackage;

public class Q4 implements CumulativeInterface{
	
	public void interface1Method(Interface1 interface1) {
		
	}
	
	public void interface2Method(Interface2 interface2) {
		
	}

	public void interface3Method(Interface3 interface3) {
	
	}
	
	public void cumulativeInterfaceMethod(CumulativeInterface cumulativeInterface) {
		
	}
	
	public static void main(String[] args) {
		InterfaceImplementer interfaceImplementer = new InterfaceImplementer();
		
		Q4 question4 = new Q4();
		question4.interface1Method(interfaceImplementer);
		question4.interface2Method(interfaceImplementer);
		question4.interface3Method(interfaceImplementer);
		question4.cumulativeInterfaceMethod(interfaceImplementer);
	}

	@Override
	public void method11() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method12() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method21() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method22() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method31() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method32() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method41() {
		// TODO Auto-generated method stub
		
	}

}

class InterfaceImplementer implements CumulativeInterface{

	@Override
	public void method11() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method12() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method21() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method22() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method31() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method32() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method41() {
		// TODO Auto-generated method stub
		
	}
	
}


interface Interface1{
	public void method11();
	public void method12();
}

interface Interface2{
	public void method21();
	public void method22();
}

interface Interface3{
	public void method31();
	public void method32();
}

interface CumulativeInterface extends Interface1,Interface2,Interface3{
	public void method41();
}