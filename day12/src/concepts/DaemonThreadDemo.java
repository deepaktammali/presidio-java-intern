package concepts;

public class DaemonThreadDemo {
	
	public static void main(String[] args) {
//		Thread.currentThread().setDaemon(true); cannot be set IllegalStateException
		Thread t = new Thread(()->{
			System.out.println("Thread : "+Thread.currentThread().getName());
			int value=0;
			while(true) {
				System.out.println(value);
				value+=1;
			}
		});
		
		t.setDaemon(true);
		t.start();
	}
}
