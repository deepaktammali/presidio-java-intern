package statickeyword;

class Printer{
	private static int printedPagesCount=0;
	private boolean hasWirelessAccess;
	
	Printer(boolean hasWirelessAccess){
		this.hasWirelessAccess = hasWirelessAccess;
	}
	
	public void printPages(int numPages) {
		if(numPages>0) {
			this.printedPagesCount+=numPages;
			System.out.println("Printing "+numPages+" pages.");
		}
		else {
			System.out.println("Invalid number of pages");
		}
	}
	
	public boolean hasWirelessAccess() {
		return hasWirelessAccess;
	}
	public void setWirelessAccess(boolean hasWirelessAccess) {
		this.hasWirelessAccess = hasWirelessAccess;
	}

	public static int getPrintedPagesCount() {
		return printedPagesCount;
	}
}



public class Main {
	
	public static void main(String[] args) {
		Printer myPrinter = new Printer(true);
		System.out.println("System has wireless access ? "+myPrinter.hasWirelessAccess());
		System.out.println("System has till printed : "+myPrinter.getPrintedPagesCount()+" page/s" );
		myPrinter.printPages(2);
		System.out.println("System has till printed : "+myPrinter.getPrintedPagesCount()+" page/s" );
	}
}
