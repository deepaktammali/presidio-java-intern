package lab.exceptionhandling;

public class Q2 {
	public static void main(String[] args) {
		(new SampleV1()).mth1();
	}
}

class SampleV1 {
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}

	public void mth2() {
		try {
			return;
		} catch (Exception e) {

		} finally {
			System.out.println("mth2-finally");
		}
	}
}