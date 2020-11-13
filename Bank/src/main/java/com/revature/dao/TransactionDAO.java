package com.revature.dao;
import com.revature.pojo.*;
public interface TransactionDAO {
	public void createTransaction(Transaction trans);
	public void deleteTransaction(Transaction trans);
	public void viewAllTransaction();
	
}
