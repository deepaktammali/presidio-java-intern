package concepts;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerProblem {
	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		SharedData sharedData = new SharedData(10);
		threadPool.execute(()->{
			try {
				sharedData.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		threadPool.execute(()->{
			try {
				sharedData.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
}


class SharedData{
	private ArrayList<Integer> data = new ArrayList<Integer>();
	private final int size;
	
	public SharedData(int size) {
		this.size = size;
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(this) {
				if(data.size()==0) {
					wait();
				}
				
				int lastIndex = data.size()-1;
				int consumedValue = data.get(lastIndex);
				data.remove(lastIndex);
				System.out.printf("Consumed value : %d",consumedValue).println();
				
				notify();
			}
			Thread.sleep(2000);
		}
	}
	
	public void produce() throws InterruptedException {
		int value = 0;
		while(true) {
			synchronized(this) {
				if(data.size()==size) {
					wait();
				}
				
				data.add(value);
				System.out.printf("Added Value %d",value).println();
				notify();
				value++;
			}
			Thread.sleep(2000);
		}
	}
	
}