package lab.exceptionhandling;

import java.io.IOException;


public class Q1 {
	public static void main(String[] args) {
		try {
			ReadFromFile.readFile("doesnotexist.txt");
		}
		catch(Exception e) {
			
		}
		
//		ReadFromFile.readFile("doesnotexist.txt"); error : Unhandled Exception
	}
}


//class ReadFromFile{	error: Unhandled Exception
//	public static void readFile(String fileName)  {
//		throw new IOException();
//	}
//}

class ReadFromFile{
	public static void readFile(String fileName) throws Exception {
		throw new IOException();
	}
}