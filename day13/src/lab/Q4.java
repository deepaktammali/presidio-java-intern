package lab;

import java.util.*;

public class Q4 {
	public static void main(String[] args) {
		AccountManager accountManager = new AccountManager();
		accountManager.setBalance("John",200120);
		accountManager.setBalance("Doe", 1002212);
		
		System.out.println(accountManager.getBalance("John"));
		System.out.println(accountManager.getBalance("Doe"));
	}
}

class AccountManager {
	private Map<String,Integer> accountTotals = new HashMap<>();
	private int retirementFund;

	public int getBalance(String accountName) {
		Integer total = accountTotals.get(accountName);
		if (total == null)
			total = Integer.valueOf(0);
		return total.intValue();
	}

	public void setBalance(String accountName, int amount) {
		accountTotals.put(accountName, Integer.valueOf(amount));
	}
}