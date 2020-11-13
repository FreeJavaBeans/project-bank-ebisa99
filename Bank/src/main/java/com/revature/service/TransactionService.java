package com.revature.service;
import com.revature.dao.*;
import com.revature.pojo.*;
import java.util.*;
public class TransactionService {
	private TransactionDAOPostgres tr = new TransactionDAOPostgres();
	private Scanner sc = new Scanner(System.in);
	public void createTrans()
	{
		System.out.println("please enter Transaction type.");
		String ttype = sc.next();
		System.out.println("please enter Transaction Date.");
		String transdate = sc.next();
		System.out.println("please enter transaction Account number.");
		int number = sc.nextInt();
		System.out.println("please enter amount.");
		double amount = sc.nextDouble();
		Transaction trans = new Transaction(ttype, transdate, number, amount);
		tr.createTransaction(trans);
	}
	public void viewAllTransaction()
	{
		tr.viewAllTransaction();
	}
}
