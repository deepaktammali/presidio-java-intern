package concepts;

public class CustomExceptionDemo {
	public static void main(String[] args) {
		CustomExceptionTest customExceptionTest = new CustomExceptionTest();
		try {
			customExceptionTest.throwsException();
		}
		catch(Exception e){
			System.out.println("Exception Thrown "+e);
		}
	}
}


class CustomExceptionTest{
	public void throwsException() throws CustomException{
		throw new CustomException();
	}
}


// try catch blocks are only to stop the abnormal flow of the program that is caused by the Exception
// to actually handle an exception you need to write a seperate handler