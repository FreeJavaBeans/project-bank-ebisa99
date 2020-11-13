package com.revature.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.*;
import com.revature.pojo.*;
import java.util.*;
public class EmployeeService {
	private EmployeeDAOPostgres pg =  new EmployeeDAOPostgres();
	private RequestResponsePostgres rp = new RequestResponsePostgres();
	private RequestResponseService rs = new RequestResponseService();
	private BankAccountService bs = new BankAccountService();
	private TransactionService ts = new TransactionService();
	private Scanner sc = new Scanner(System.in);
	public void createEmployee() {
		System.out.println("please enter employee's firt name.");
		String firstname = sc.next();
		System.out.println("please enter employee's last name.");
		String lastname = sc.next();
		System.out.println("please enter employee's hire date.");
		String hireDate = sc.next();
		Employee employee = new Employee(firstname, lastname, hireDate);
		pg.createEmployee(employee);
	}
	public void employeeLogin(int eId) {
		// TODO Auto-generated method stub

		//System.out.println("The list of all employee ID is: " + pg.employeeLogin());
		int counter = 0;
		int l = pg.employeeLogin().size();
		for(int i = 0; i < l; i++)
		{
			if(pg.employeeLogin().get(i) == eId)
			{
				counter++;
				System.out.println("login successful.");
				System.out.println("what would you like to do? select from the list below.");
				System.out.println("\n1. view user request.");
				System.out.println("\n2. view customer request.");
				System.out.println("\n3. view customer account.");
				System.out.println("\n4. view customer Transaction.");
				int s = sc.nextInt();
				switch(s)
				{
				case 1:
				{
					System.out.println("\n=============================================.");
					rp.viewUserRequest();
					System.out.println();
					System.out.println("approve or disapprove use request.");
					rs.createUserResponse();
				}
				case 2:
				{
					System.out.println("\n=============================================.");
					System.out.println("customer request.");
					System.out.println();
					rp.viewCustomerRequest();
					System.out.println("\ncustomer can always open new bank account.");
					bs.createAccount();
				}
				case 3:
				{
					System.out.println("\n=========================================================");
					System.out.println("view customer Account.");
					bs.viewAccount();
				}
				case 4:
				{
					System.out.println();
					System.out.println("\n4. view customers Transaction.");
					System.out.println();
					ts.viewAllTransaction();
				}
				}
				break;
			}
			else
			{
				counter = 0;
			}
		}
		if(counter == 0)
		{
			System.out.println("please, enter the correct employee ID.");
		}
		
	}
	public void viewCustomerBA(Account account) {
		// TODO Auto-generated method stub
		
	}

	public void viewTransaction(Transaction tans) {
		// TODO Auto-generated method stub
		
	}
	public void approveOrReject(int id) {
		 
	}

}
