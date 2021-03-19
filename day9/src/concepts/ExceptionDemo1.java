package concepts;

public class ExceptionDemo1 {
	public static void main(String[] args) {
		int i = 1;
		int j = 0;
		
		
		try {
			double k = i/j;	//dividebyzero exception
		}
		catch(Exception e){
			System.out.println("Exception "+e);
		}
		finally {
			
		}
		
		
	}
}
