package com.revature.dao;
import com.revature.pojo.*;
public interface AccountDAO {
	public void createAccount(Account account);
	//public void deposit(double amount);
	public void withdraw(double amount);
	public void viewAccount(int aNumber);
	public void deposit(int number);
	//public double depositor(int number);
	
	
}
