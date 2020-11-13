package com.revature.service;
import com.revature.pojo.*;
import java.util.*;
import com.revature.dao.*;
import java.util.*;
public class BankRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CustomerService cs = new CustomerService();
		CustomerDAOPostgres pg = new CustomerDAOPostgres();
		UserService u = new UserService();
		EmployeeService es = new EmployeeService();
		RequestResponseService rrs = new RequestResponseService();
		BankAccountService as = new BankAccountService();
		AccountDAOPostgres ap = new AccountDAOPostgres();
		RequestResponsePostgres rp = new RequestResponsePostgres();
		System.out.println("Hello! Welcome to JAVABANk!");
		System.out.println("Hire employee");
		es.createEmployee();
		System.out.println("please choose one of the options below.");
		System.out.println("1. i am a javabank employee.");
		System.out.println("2. i am a javabank user.");
		System.out.println("\n3. i am a javabank customer.");
		int i = sc.nextInt();
		do {
			System.out.println();
			System.out.println("please choose one of the options below.");
			System.out.println("1. i am a javabank employee.");
			System.out.println("2. i am a javabank user.");
			System.out.println("\n3. i am a javabank customer.");
			i = sc.nextInt();
			switch(i)
			{
			case 1:
			{
				System.out.println("1. i am a javabank employee.");
				System.out.println("please login.");
				System.out.println("please enter your employee ID.");
				int eId = sc.nextInt();
				es.employeeLogin(eId);
			}
			break;
			case 2:
			{
				System.out.println("2. i am a javabank user.");
				System.out.println("please login");
				System.out.println("enter your user name.");
				String un = sc.next();
				System.out.println("please enter your password.");
				String pw = sc.next();
				u.userLogin(un, pw);
			}
			break;
			case 3:
			{
				System.out.println("3. i am a javabank customer.");
				System.out.println("please login.");
				System.out.println("please enter your username.");
				String un = sc.next();
				System.out.println("please enter your password.");
				String pw = sc.next();
				cs.customerLogin(un, pw);
			}
			break;
			}
		}while(i < 4);
	}
}
