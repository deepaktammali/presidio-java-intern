package labtestsolutions;

public class InvestmentReturnQ27 {

	public static void main(String[] args) {
		Investment myInvestment = new Investment(14000);
		myInvestment.worthChangeByPercent(40); //1st year
		myInvestment.worthChangeByValue(-1500); //2ndyear
		myInvestment.worthChangeByPercent(12); //3rd year
		System.out.println("Current Investment Worth : "+myInvestment.getInvestedAmount());
		
	}
	
}


class Investment{
	private double investedAmount;
	Investment(){
		this(0);
	}
	
	Investment(int amount){
		this.investedAmount = amount;
	}

	public void worthChangeByPercent(double percent) {
		this.investedAmount += ((this.investedAmount*percent)/100);
	}
	
	public void worthChangeByValue(double value) {
		this.investedAmount += value;
	}
	
	public double getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
	
}
