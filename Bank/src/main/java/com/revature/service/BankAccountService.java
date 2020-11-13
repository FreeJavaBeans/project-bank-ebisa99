package com.revature.service;

import com.revature.pojo.Account;
import com.revature.pojo.Customer;
import com.revature.dao.*;
import java.util.*;
public class BankAccountService {
	private AccountDAOPostgres ad = new AccountDAOPostgres();
	private Scanner sc = new Scanner(System.in);
	public int randomNumber()
	{
		Random r  = new Random();
		int ran = r.nextInt(10000);
		return ran;
	}
	public void createAccount()
	{
		int number = 1533 + randomNumber();
		System.out.println("\nplease enter starting balance.");
		double balance = sc.nextDouble();
		System.out.println("\nplease enter Account Type.");
		String aType = sc.next();
		System.out.println("\nplease enter the date.");
		String dateCreated = sc.next();
		System.out.println("\nplease enter User/customer ID.");
		int c_id = sc.nextInt();
		System.out.println("\nplease enter employee ID.");
		int e_id = sc.nextInt();
		Account account = new Account(number, balance, aType, dateCreated, c_id, e_id);
		ad.createAccount(account);
	}
	public void viewAccount()
	{
		System.out.println("Enter Account Number for which you want to see balance.");
		int number = sc.nextInt();
		System.out.println("your balance for Account number " + number + "  is: ");
		ad.viewAccount(number);
	}
	public void withdraw()
	{
		System.out.println("please enter the account number from which you want to withdraw.");
		int number = sc.nextInt();
		System.out.println("please enter the amount.");
		double amount = sc.nextDouble();
		if(amount > ad.balance(number))
		{
			System.out.println("Their is no sufficient fund in your account.");
		}
		else
		{
			ad.withdraw(ad.balance(number) - amount);
		}
	}
	public void deposit()
	{
		System.out.println("\nplease enter the account number to which you want to deposit.");
		int number = sc.nextInt();
		System.out.println("please enter the amount.");
		double amount = sc.nextDouble();
		if(amount < 0)
		{
			System.out.println("negative amount cannot be deposited.");
		}
		else
		{
			ad.deposit(ad.balance(number) + amount);
		}
	}
	/*
	public void transfer()
	{
		Account ac = new Account();
		System.out.println("please enter the account number from which you want to transfer.");
		int aNumber1 = sc.nextInt();
		System.out.println("please enter the account number to which you want to transfer.");
		int aNumber2 = sc.nextInt();
		System.out.println("please enter the amount.");
		double amount = sc.nextDouble();
		if(ad.balance(aNumber1) < amount)
		{
			System.out.println("Sorry! you don't have enough funds. please deposit some money first.");
		}
		else
		{
			ac.setAccountNumber(aNumber1);
			aNumber1 = ac.getAccountNumber();
			withdraw(aNumber1, amount);
			System.out.println(amount +" dollars is transfered from Account with account number  " + aNumber1);
			deposit(aNumber2, amount);
			System.out.println(amount +" dollars is deposited to Account with account number  " + aNumber2);
			System.out.println("Money Transfer is completed. Thank you for using JAVABANK.");
		}
		*/
	}

