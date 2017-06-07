package com.ebergstein.bankaccount;

public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount();
		System.out.println(account.getAccountNumber());
		account.depositChecking(10000);
		account.depositSavings(1000);
		BankAccount other = new BankAccount();
		System.out.println(other.getAccountNumber());
		other.depositChecking(10000);
		other.depositSavings(1000);
		System.out.println(other.getAllTotal());
		int temp = account.withdrawChecking(5000);
		int temp2 = other.withdrawSavings(500);
		System.out.println(other.getAllTotal());
		int temp3 = account.withdrawChecking(50000);
	}

}
