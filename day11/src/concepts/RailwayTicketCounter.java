package concepts;

public class RailwayTicketCounter {
	private int amount;
	public void bookTicket(int money) {
		String customerName = Thread.currentThread().getName();
		this.amount = money;
		System.out.printf("%s gave amount : %d",customerName,money).println();
	}
	
	public void giveChange() {
		String customerName = Thread.currentThread().getName();
		System.out.printf("%s would get back amount : %d",customerName,this.amount-100).println();
	}
}
