package day3;

public class LocalVarManip {
	public static void main(String[] args) {
		LocalVarManip lvm = new LocalVarManip();
		lvm.someMethod(lvm);
	}
	public void someMethod(LocalVarManip lvm) {
		int i = 0;
		doubleVar(lvm);
		System.out.println(i);
	}
	
	public void doubleVar(LocalVarManip lvm) {
//		lvm.i = lvm.i * 2;
	}
}
