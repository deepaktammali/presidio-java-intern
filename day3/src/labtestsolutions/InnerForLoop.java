package labtestsolutions;

public class InnerForLoop {
		public static void main(String argv[]){ 
		    int i; 
		    int j; 
		    outer: 
		    for (i=1;i <3;i++) 
		        inner: 
		         for(j=1; j<3; j++) { 
		                    if (j==2) 
		                    continue outer; 
		                    System.out.println("Value for i=" + i + " Value for j=" +j); 
		                    } 
		        } 
}
