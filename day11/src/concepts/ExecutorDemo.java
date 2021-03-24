package concepts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorDemo {
	public static void main(String[] args) {
		Thread thread;
//		thread = new Thread(new PrintTask()); single thread
//		thread.start();
		
//		for (int i = 0; i < 10; i++) {
//			thread = new Thread(new PrintTask());
//			thread.start();
//		}
		
//		ExecutorService threadPool = Executors.newFixedThreadPool(10);	
//		
//		for (int i = 0; i < 1000; i++) {
//			threadPool.execute(new PrintTask());
//		}

//		ExecutorService service = new ThreadPoolExecutor(10, 100, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
//		
//		for (int i = 0; i < 1000; i++) {
//			service.execute(new PrintTask());
//		}
		
//		ExecutorService service = Executors.newFixedThreadPool(10);
//		ArrayList<Future<Integer>> futures = new ArrayList<Future<Integer>>();
//		for (int i = 0; i < 1000; i++) {
//			Future<Integer> future = service.submit(new Task());
//			futures.add(future);
//		}
//		
//		for (int i = 0; i < 1000; i++) {
//			Future<Integer> future = futures.get(i);
//			try {
//				System.out.println("The future value is : "+future.get(1,TimeUnit.NANOSECONDS));
//			} catch (InterruptedException | ExecutionException | TimeoutException e) {
//				e.printStackTrace();
//			}
//		}
//		
////		service.shutdown();
//		service.shutdownNow();
	}
}

class Task implements Callable<Integer>{
	public static int calledTime=0;
	@Override
	public Integer call() throws Exception {
		calledTime+=1;
		return calledTime;
	}
	
}


class PrintTask implements Runnable {

	@Override
	public void run() {

		System.out.printf("The thread name : %s", Thread.currentThread().getName()).println();

	}

}