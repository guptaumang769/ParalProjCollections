package com.cg.bms.bean;

public class Transaction {

	public String type;
	public double amount;
	public double balance;
	public String date;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String type, double amount, double balance, String date) {
		super();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.date = date;
	}

	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [type=" + type + ", amount=" + amount + ", balance=" + balance + ", date=" + date
				+ "]";
	}
		
}