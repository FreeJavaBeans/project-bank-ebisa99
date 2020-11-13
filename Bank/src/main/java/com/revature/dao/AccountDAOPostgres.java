package com.revature.dao;
import java.util.*;
import com.revature.pojo.*;
import com.revature.utilities.ConnectionUtil;

import java.sql.*;

public class AccountDAOPostgres implements AccountDAO{
	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private Scanner sc = new Scanner(System.in);
	public void createAccount(Account account) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into BankAccount( aNumber, balance, atype, datecreated, cu_id, emp_id) values(?, ?, ?, ?, ?, ?)");
			 prep.setLong(1, account.getAccountNumber());
			 prep.setDouble(2, account.getBalance());
			 prep.setString(3, account.getAccountType());
			 prep.setString(4, account.getDateCreated());
			 prep.setInt(5, account.getCu_id());
			 prep.setInt(6, account.getEmp_id());
			 prep.executeUpdate();
			 System.out.println("Account is added to the list of Account.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void viewAccount(int number)
	{
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			String sql = "select * from BankAccount "
					+ "where aNumber=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, number);
			ResultSet result = prep.executeQuery();
			System.out.println();
			System.out.println("ACCOUNT NUMBER" +"    " + "BALANCE" + "        " + 
					"ACCOUNT TYPE" + "     " + "DATE CREATED" + "     " + "CUSTOMER ID" + "         "+
					"EMPLOYEE ID");
			while(result.next())
			{
				System.out.print("\n" +result.getInt(1) + "             " +
				result.getDouble(2)+ "            " +
				result.getString(3) + "            " +
				result.getString(4)+ "              " +
				result.getInt(5) + "                 "	+
				result.getInt(6));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deposit(int number) {
		// TODO Auto-generated method stub
		
	}
	//will be used when Transfering money from one account to another account using account number.
	//both Accounts the one Transferring and the one Accepting can use this method
	//to update their respective balances.
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			 String sql = "update BankAccount set balance=?";
			 prep = conn.prepareStatement(sql);
			 prep.setDouble(1, amount);
			 prep.executeUpdate();
			 System.out.println("Account is updated.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			 String sql = "update BankAccount "
			 			+ "set balance=?";
			 			//+ "where aNumber=?";
			 prep = conn.prepareStatement(sql);
			 prep.setDouble(1, amount);
			// prep.setDouble(2, balance);
			 prep.executeUpdate();
			 System.out.println("Account is updated.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void transferMoney(int aNumber1, int aNumber2) {
		// TODO Auto-generated method stub
		
	}
	public double balance(int number)
	{
		double balance = 0;
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			String sql = "select balance from BankAccount where aNumber=?";
			prep = conn.prepareStatement(sql);
			prep.setDouble(1, number);
			ResultSet result = prep.executeQuery();
			while(result.next())
			{
				balance = result.getDouble(1);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return balance;
	}

}
