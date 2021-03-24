package concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsDemo {
	public ThreadsDemo() {
		(new Thread(new ChildThread())).start();
	}
	
	public static void main(String[] args) {
		new ThreadsDemo();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}
}

class ChildThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Child Thread Called.");
	}
	
}
