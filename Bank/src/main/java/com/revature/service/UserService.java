package com.revature.service;
import com.revature.dao.*;
import com.revature.pojo.*;

import java.util.*;
public class UserService {
	private UserDAOPostgres pg = new UserDAOPostgres();
	private RequestResponseService rrs = new RequestResponseService();
	private BankAccountService bs = new BankAccountService();
	private Scanner sc = new Scanner(System.in);
	public void createUser()
	{
		System.out.println("please enter user's firt name.");
		String firstname = sc.next();
		System.out.println("please enter user's last name.");
		String lastname = sc.next();
		System.out.println("please enter user's user name.");
		String username = sc.next();
		System.out.println("please enter customer's password.");
		String password = sc.next();
		 User user = new User(firstname, lastname, username, password);
		pg.createUser(user);
	}
	public void userLogin(String userName, String password)
	{
		int j = 0;
		int counter = 0;
		int halfL = pg.userLogin().size() / 2;
		for(int i = 0; i < halfL; i++)
		{
			if(pg.userLogin().get(j).equals(userName) && pg.userLogin().get(j + 1).equals(password))
			{
				counter++;
				System.out.println("Hello." + userName);
				System.out.println("what would you like to do? choose 1 or 2 or 3.");
				System.out.println("1.general information about JAVABANK");
				System.out.println("2. Apply for bank account");
				System.out.println("3. view response for request.");
				int u = sc.nextInt();
				switch(u)
				{
				case 1:
				{
					System.out.println("our bank is known by it's great customer service. "
				            + "we gaurantee you, you will love our service."
							+ "open a new Account with us Today.");
				}
				case 2:
				{
					System.out.println();
					System.out.println("want to open account with us?");
					System.out.println("create request for new bank account.");
					rrs.createUserRequest();
				}
				case 3:
				{
					rrs.viewEmployeeResponse();
					bs.createAccount();
					System.out.println("conrats! you're one of our valued customer now.");
				}
				}
				break;
			}
			else
			{
				counter = 0;
			}
			j =  j + 2;
		}
	if(counter == 0)
	{
		System.out.println("please, enter the correct user name and password.");
	}
	}
}
