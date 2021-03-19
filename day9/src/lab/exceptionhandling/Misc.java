package lab.exceptionhandling;

import lab.interfaceandpackage.Q5Interface;

public class Misc {
	public static void main(String[] args) {
		//continuation of Question 6 in interfaceandpackageslab
		
		lab.interfaceandpackage.Q6 secretClass = new lab.interfaceandpackage.Q6();
//		secretClass.getCodeName();cannot access not visible
		
	}
}


class SecretClass extends lab.interfaceandpackage.Q6{
	public SecretClass() {
		super.getCodeName();
	}
}

// continuation of Question 5 in interfaceandpackageslab
class Methods implements Q5Interface{

	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}

	@Override
	public void method3() {
		
	}
	
}




