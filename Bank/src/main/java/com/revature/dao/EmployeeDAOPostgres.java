package com.revature.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.*;
import com.revature.utilities.*;
public class EmployeeDAOPostgres implements EmployeeDAO{
	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into BankEmployee( firstName, lastName, hiredate) values(?, ?, ?)");
			 prep.setString(1, employee.getFirstName());
			 prep.setString(2, employee.getLastName());
			 prep.setString(3, employee.getHiredate());
			 prep.executeUpdate();
			 System.out.println("Employee is added to the list of employee.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public List<Integer> employeeLogin() {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		List<Integer> list = new ArrayList<Integer>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select emp_id from BankEmployee";
			ResultSet result = stmt.executeQuery(sql);
			while(result.next())
			{
				 
				list.add(result.getInt("emp_id"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public void viewCustomerBA(Account account) {
		// TODO Auto-generated method stub
		
	}

	public void viewTransaction(Transaction tans) {
		// TODO Auto-generated method stub
		
	}

	public void approveOrReject(int id) {
		// TODO Auto-generated method stub
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			String sql = "select * from BankUser"
					+ "where BankCustomer.cu_id=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
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

}
