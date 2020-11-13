package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.*;
import com.revature.utilities.ConnectionUtil;

public class CustomerDAOPostgres implements CustomerDAO{
	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into BankCustomer( firstName, lastName, userName, password) values(?, ?, ?, ?)");
			 prep.setString(1, customer.getFirstName());
			 prep.setString(2, customer.getLastName());
			 prep.setString(3, customer.getUserName());
			 prep.setString(4, customer.getPassword());
			 prep.executeUpdate();
			 System.out.println("Customer is added to the list of customer.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void viewAllCustomer() {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from BankCustomer";
			ResultSet result = stmt.executeQuery(sql);
			System.out.println(" The list of all customers Are:-");
			System.out.println("Customer ID" +"    " + "Customer First name" + "    " + 
								"Customer Last Name" + "     " + "User Name" + "     " + "password");
			
			while(result.next())
			{ 
				System.out.print("\n" + result.getInt(1) + "              " +
				result.getString(2) + "                  " +
				result.getString(3) + "                   " +
				result.getString(4)  +"       " +
				result.getString(5));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void viewCustomer(int c_id) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			String sql = "select * from BankCustomer "
					+ "where BankCustomer.cu_id=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, c_id);
			ResultSet result = prep.executeQuery();
			while(result.next())
			{
				System.out.print("\n" +result.getInt(1) + "    " +
				result.getString(2) + "       " +
				result.getString(3)+ "       " +
				result.getString(4)+ "       " +
				result.getString(5));				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
	}

	public List<String> customerLogin() {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		List<String> list = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select userName, password from BankCustomer";
			ResultSet result = stmt.executeQuery(sql);
			while(result.next())
			{
				 
				list.add(result.getString("username"));
				list.add(result.getString("password"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public void deleteCustomer(int cu_id) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete * from BankCustomer where cu_id=cu_id";
			ResultSet result = stmt.executeQuery(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
