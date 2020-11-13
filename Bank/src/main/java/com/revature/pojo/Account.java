package com.revature.pojo;

public class Account {
	public Account(int accountNumber, double balance, String accountType, String dateCreated, int cu_id, int emp_id) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.dateCreated = dateCreated;
		this.cu_id = cu_id;
		this.emp_id = emp_id;
	}
	public Account() {}
	private String accountType;
	private int accountNumber;
	private double balance;
	private String dateCreated;
	int cu_id;
	int emp_id;
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getCu_id() {
		return cu_id;
	}
	public void setCu_id(int cu_id) {
		this.cu_id = cu_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
