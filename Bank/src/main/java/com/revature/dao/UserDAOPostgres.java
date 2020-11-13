package com.revature.dao;
import com.revature.utilities.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.User;

public class UserDAOPostgres implements UserDAO{
	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	public void createUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into BankUser( firstName, lastName, userName, password) values(?, ?, ?, ?)");
			 prep.setString(1, user.getFirstName());
			 prep.setString(2, user.getLastName());
			 prep.setString(3, user.getUserName());
			 prep.setString(4, user.getPassword());
			 prep.executeUpdate();
			 System.out.println("The user is added to user list.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<String> userLogin() {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		List<String> list = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select userName, password from BankUser";
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

	public void registerForCustomerAccount(User user) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into BankCustomer( firstName, lastName, userName, password) values(?, ?, ?, ?)");
			 prep.setString(1, user.getFirstName());
			 prep.setString(2, user.getLastName());
			 prep.setString(3, user.getUserName());
			 prep.setString(4, user.getPassword());
			 prep.executeUpdate();
			 System.out.println("The user's bank account is created.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
