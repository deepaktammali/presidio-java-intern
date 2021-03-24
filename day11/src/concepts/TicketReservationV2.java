package concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// pessimistic lock wanting the whole object for ourselves

public class TicketReservationV2 {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		RailwayTicketCounter railwayTicketCounter = new RailwayTicketCounter();
		
		threadPool.execute(()->{
			Thread.currentThread().setName("John");
			synchronized(railwayTicketCounter) {
				railwayTicketCounter.bookTicket(1000);
				railwayTicketCounter.giveChange();
			}
		}) ;
		
		
		
		threadPool.execute(()->{
			Thread.currentThread().setName("Doe");
			synchronized(railwayTicketCounter) {
				railwayTicketCounter.bookTicket(500);
				railwayTicketCounter.giveChange();
			}
		});
		
		threadPool.shutdown();
	}
}
