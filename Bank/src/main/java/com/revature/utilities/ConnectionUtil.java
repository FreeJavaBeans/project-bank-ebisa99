package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	//leverage a design pattern called the singleton pattern
	//the singleton pattern involves making a private constructor
	//so no other class can instance this object
	//store a static reference to the single copy of the object made
	//we provide a public method to access that single instance
	private static ConnectionUtil singleton = new ConnectionUtil();
	private Connection conn;
	private ConnectionUtil()
	{
		super();
		//getting secret into a java program
		//two ways 
		//read from a file, some sort of config like .xml or .properties
		//or a .yaml
		//store our secrets in the system environment variables
		//retrieve them here and use them
		String password = "Yosef@2018";
				//System.getenv("Yosef@2018");
		String username = "postgres";
				//System.getenv("postgres");
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=bank";
				//System.getenv("DB_URL");
		try
		{
			this.conn = DriverManager.getConnection(url, username, password);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static ConnectionUtil getConnectionUtil()
	{
		return singleton;
	}
	public Connection getConnection()
	{
		return conn;
	}

}
