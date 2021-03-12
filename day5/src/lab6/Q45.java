package lab6;

public class Q45 {

}


class BankAccountType1{
	private String depositorName;
	private long accountNumber;
	private String typeOfAccount;
	private double balanceAmount;

	
	public void initializeAccount(String depositorName,long accountNumber,String typeOfAccount,double balanceAmount){
		this.depositorName = depositorName;
		this.accountNumber = accountNumber;
		this.typeOfAccount = typeOfAccount;
		this.balanceAmount = balanceAmount;
	}
	
	private void setAmount(double amount) {
		if(amount>0) {
			this.balanceAmount+=amount;
		}
	}
	
	public void depositAmount(double amount) {
		this.setAmount(amount);
	}
	
	public void displayName() {
		System.out.println("The account name is : "+this.depositorName);
	}
	
	public void displayBalance(){
		System.out.println("The account balance is : "+this.balanceAmount);
	}
}









