package lab.exceptionhandling;

public class Q3 {
	public static void main(String[] args) {
		(new SampleV2()).mth1();
	}
}



class SampleV2 {
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}

	public void mth2() {
		try {
			System.exit(1);
		} catch (Exception e) {

		} finally {
			System.out.println("mth2-finally");
		}
	}
}


// System.exit(n) for any non-zero n terminates the program abruptly