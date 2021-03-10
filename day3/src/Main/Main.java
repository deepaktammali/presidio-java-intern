package Main;
import accessmodifier.*;

// public class can be accessed from anywhere in the project
// default class can be accessed in the same package
// protected members will only be visible to child classes
// private and default members are invisible outside the class
// default methods cannot be accessed outside the package when imported


public class Main {
	public static void main(String[] args) {
		PublicClass publicClass = new PublicClass();
//		DefaultClass defaultClass = new DefaultClass(); 
		System.out.println(publicClass.publicVar);
//		System.out.println(publicClass.protectedVar);
//		System.out.println(publicClass.privateVar);
//		System.out.println(publicClass.defaultVar);
		publicClass.getPublic();
//		publicClass.getDefault();
	}
}

