package concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketReservationV1 {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		RailwayTicketCounter railwayTicketCounter = new RailwayTicketCounter();
		
		threadPool.execute(()->{
			Thread.currentThread().setName("John");
			railwayTicketCounter.bookTicket(1000);
			railwayTicketCounter.giveChange();
		}) ;
		
		
		
		threadPool.execute(()->{
			Thread.currentThread().setName("Doe");
			railwayTicketCounter.bookTicket(500);
			railwayTicketCounter.giveChange();
		});
		
		threadPool.shutdown();
	}
}
