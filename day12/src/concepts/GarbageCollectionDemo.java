package concepts;

import java.lang.ref.WeakReference;

public class GarbageCollectionDemo {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		GrandFather gf = new GrandFather();
		WeakReference<GrandFather> wr = new WeakReference<>(gf);
		System.gc();
	}
}


class GrandFather {
	String gold = "Under the tree....";
	String space;

	public void fun() {
		for (int i = 0; i < 10000; i++) {
			space = new String("........" + i);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Finalize is called");
	}
}