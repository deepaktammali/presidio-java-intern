package lab6;

import lab6.account.*;
import java.util.Scanner;

public class Q52{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		Account[] accountArray = new Account[5];

		for(int i=0;i<accountArray.length;i++){
			System.out.printf("Enter account name :");
			String name = scanner.next();
			System.out.printf("Enter account number :");
			int number = scanner.nextInt();
			accountArray[i] = new Account(name,number);
		}

		
		for(int i=0;i<accountArray.length;i++){
		System.out.printf("Account Holder %s has account number %d",accountArray[i].getAccountName(),accountArray[i].getAccountNumber()).println();
		}
	}
}