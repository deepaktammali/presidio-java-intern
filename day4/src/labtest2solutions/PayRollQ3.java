package labtest2solutions;

public class PayRollQ3 {

}


class Employee{
	protected int date;
	protected String month;
	protected int year;
	
	public final void printDateOfJoining() {
		System.out.println("Joined on "+date+" "+month+" "+year);
	}
}

class Worker extends Employee{
	
}

class SalesPerson extends Employee{
	
}

class SalesManager extends Employee{
	
}

class SalesTerritoryManager extends Employee{
	
}