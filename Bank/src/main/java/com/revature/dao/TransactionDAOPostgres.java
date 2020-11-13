package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.pojo.*;
import com.revature.utilities.ConnectionUtil;

public class TransactionDAOPostgres implements TransactionDAO{
	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	public void createTransaction(Transaction trans) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into Transaction( ttype, transdate, anumber, amount) values(?, ?, ?, ?)");
			 prep.setString(1, trans.getTranType());
			 prep.setString(2, trans.getTransDate());
			 prep.setInt(3, trans.getNumber());
			 prep.setDouble(4, trans.getAmount());
			 prep.executeUpdate();
			 System.out.println("Transaction is added to the list of Transaction.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void deleteTransaction(Transaction trans) {
		// TODO Auto-generated method stub
		
	}
	public void viewAllTransaction() {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from Transaction";
			ResultSet result = stmt.executeQuery(sql);
			System.out.println(" The list of all Transaction Are:-");
			System.out.println("Transaction ID" +"    " + "Transaction Type" + "    " + 
								"Transaction Date" + "     " + "Account Number");
			
			while(result.next())
			{ 
				System.out.print("\n" + result.getInt(1) + "              " +
				result.getString(2) + "                  " +
				result.getString(3) + "                   " +
				result.getInt(4));
				
			}
			System.out.println();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
