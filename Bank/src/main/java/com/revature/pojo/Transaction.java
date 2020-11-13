package com.revature.pojo;

public class Transaction {
	private String tranType;//is it withdrawal, deposit or transfer
	private String transDate;
	private int number;
	private double amount;
	public Transaction(String tranType, String transDate, int number, double amount) {
		super();
		this.tranType = tranType;
		this.transDate = transDate;
		this.number = number;
		this.amount = amount;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
