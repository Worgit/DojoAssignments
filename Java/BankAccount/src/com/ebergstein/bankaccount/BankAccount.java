package com.ebergstein.bankaccount;

public class BankAccount {
	
	private static int accounts = 0;
	private static int total = 0;
	
	private int accountNumber;
	private int checkingBalance = 0;
	private int savingsBalance = 0;
	
	public BankAccount(){
		accounts++;
		this.accountNumber = 100000 + accounts;
	}
	
	public int getAllTotal() {
		return (total);
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getCheckingBalance() {
		return checkingBalance;
	}
	public void setCheckingBalance(int checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public int getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(int savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void depositSavings(int money){
		this.savingsBalance += money;
		total += money;
	}
	
	public void depositChecking(int money){
		this.checkingBalance += money;
		total += money;
	}
	
	public int withdrawSavings(int amount){
		if(amount > this.savingsBalance){
			System.out.println("Insufficient funds.");
			return (0);
		}
		this.savingsBalance -= amount;
		total -= amount;
		return (amount);
	}
	
	public int withdrawChecking(int amount){
		if(amount > this.checkingBalance){
			System.out.println("Insufficient funds.");
			return (0);
		}
		this.checkingBalance -= amount;
		total -= amount;
		return (amount);
	}
	
	public int getTotal(){
		return (this.getCheckingBalance() + this.getSavingsBalance());
	}

}
