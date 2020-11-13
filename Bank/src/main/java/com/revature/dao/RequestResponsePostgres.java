package com.revature.dao;
import com.revature.pojo.*;
import com.revature.utilities.ConnectionUtil;
import java.sql.*;
public class RequestResponsePostgres {
	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	public void createUserRequest(Request req)
	{
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into request(urtype, requestdate) values(?, ?)");
			 prep.setString(1, req.getRequestType());
			 prep.setString(2, req.getRequestDate());
			 prep.executeUpdate();
			 System.out.println("user request is added to the list of Request.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void createCustomerRequest(CustomerRequest cr)
	{
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into customerrequest(crtype, requestdate) values(?, ?)");
			 prep.setString(1, cr.getRequestType());
			 prep.setString(2, cr.getRequestDate());
			 prep.executeUpdate();
			 System.out.println("customer request is added to the list of Request.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void viewUserRequest()
	{
		Connection conn = cu.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from Request";
			ResultSet result = stmt.executeQuery(sql);
			System.out.println(" The list of all user requests Are:-");
			System.out.println("user request ID" +"       " + "user request" + "       " + 
								"request Date" + "         " + "user ID Number");
			
			while(result.next())
			{ 
				System.out.print("\n" + result.getInt(1) + "                 " +
				result.getString(2) + "                   " +
				result.getString(3) + "                   " +
				result.getInt(4));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void viewCustomerRequest()
	{
		Connection conn = cu.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from customerrequest";
			ResultSet result = stmt.executeQuery(sql);
			System.out.println(" The list of all customer requests Are:-");
			System.out.println("customer request ID" +"      " + "customer request" + "       " + 
								"request Date" + "        " + "customer ID Number");
			
			while(result.next())
			{ 
				System.out.print("\n" + result.getInt(1) + "                   " +
				result.getString(2) + "             " +
				result.getString(3) + "                   " +
				result.getInt(4));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void createUserResponse(Response res)
	{
		//Response res = new Response();
		Connection conn = cu.getConnection();
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("insert into userresponse(response, emp_id) values(?, ?)");
			 prep.setString(1, res.getResponse());
			 prep.setInt(2, res.getEmp_id());
			 prep.executeUpdate();
			 System.out.println("\nuser response is added to the list of Response.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void viewUserResponse()
	{
		Connection conn = cu.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from userresponse";
			ResultSet result = stmt.executeQuery(sql);
			System.out.println(" The list of all user responses Are:-");
			System.out.println("user response ID" +"      " + "user response" + "       " + 
								 "employee ID Number");
			
			while(result.next())
			{ 
				System.out.print("\n" + result.getInt(1) + "                   " +
				result.getString(2) + "             " +
				result.getInt(3));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
