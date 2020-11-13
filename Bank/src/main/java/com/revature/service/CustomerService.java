package com.revature.service;
import java.util.*;
import com.revature.dao.*;
import com.revature.pojo.*;
import com.revature.pojo.Account;

public class CustomerService {
	private Scanner scan = new Scanner(System.in);
	private CustomerDAOPostgres pg = new CustomerDAOPostgres();
	private RequestResponseService rrs = new RequestResponseService();
	private BankAccountService as = new BankAccountService();
	private TransactionService ts = new TransactionService();
	public void createCustomer() {
		System.out.println("please enter customer's firt name.");
		String firstname = scan.next();
		System.out.println("please enter customer's last name.");
		String lastname = scan.next();
		System.out.println("please enter customer's user name.");
		String username = scan.next();
		System.out.println("please enter customer's password.");
		String password = scan.next();
		Customer customer = new Customer(firstname, lastname, username, password);
		pg.createCustomer(customer);
	}
	public void customerLogin(String userName, String password)
	{
		int j = 0;
		int counter = 0;
		int halfL = pg.customerLogin().size() / 2;
		for(int i = 0; i < halfL; i++)
		{
			if(pg.customerLogin().get(j).equals(userName) && pg.customerLogin().get(j + 1).equals(password))
			{
				counter++;
				System.out.println("Hello." + userName);
				System.out.println("what would you like to do? choose from the list below.");
				System.out.println("1.Apply for new bank account");
				System.out.println("2.view balance.");
				System.out.println("3.deposit.");
				System.out.println("4.withdraw.");
				System.out.println("5.Transfer Money.");
				int n = scan.nextInt();
					switch(n)
					{
					case 1:
					{
						rrs.createCustomerRequest();
						System.out.println("you have sent request for opening new bank account.");
						System.out.println("create new bank account.");
						as.createAccount();
						System.out.println("new bank account is created for you.");
						System.out.println();
					}
					case 2:
					{
						System.out.println("view your balance .");
						System.out.println();
						as.viewAccount();
					}
					case 3:
					{
						as.deposit();
						System.out.println("create transaction.");
						ts.createTrans();
						as.viewAccount();
						System.out.println();
						System.out.println("\nSystem validation.");
						System.out.println();
						as.deposit();
						System.out.println();
					}
					case 4:
					{
						System.out.println("withdrawing money.");
						System.out.println();
						as.withdraw();
						System.out.println("create transaction.");
						ts.createTrans();
						as.viewAccount();
						System.out.println();
						System.out.println("\nSystem validation.");
						System.out.println();
						as.withdraw();
						System.out.println("Thank you for your using javabank!");
						System.out.println();
					}
					case 5:
					{
						System.out.println("5.Transfer Money.");
					}
					}
					System.out.println();
					System.out.println("THIS IS THE END OF JAVABANK DEMO. THANK YOU FOR LISTENING!.");
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
	public void viewAllCustomers() {
		// TODO Auto-generated method stub
		pg.viewAllCustomer();
	}
	public void viewCustomers() {
		// TODO Auto-generated method stub
		System.out.println("\nEnter your customer ID.");
		int cu_id = scan.nextInt();
		pg.viewCustomer(cu_id);
	}
	//This method will send a request to bank employee
	//if bank employee approves the customers request, bank account for the requesting customer,
	//will be created.
	public void applyForAccount(Customer cu_id) {
		// TODO Auto-generated method stub
		
	}
	//This is a logic and better to be defined in service class.
	//when transferring money is issued, updateAccount method in AccountDaopostgres will be used
	//to update both Accounts(from and to Accounts)
	public void transferMoney(Account transfer) {
		// TODO Auto-generated method stub
		
	}
	//This is a logic  in better to be defined and service class.
	//when accepting transfer, upon asking customer for the account numbers of from and to accounts
	//and then use update account in BankAccount to update the balances of both accounts.
	public void acceptTransfer(Account accept) {
		// TODO Auto-generated method stub
		
	}
}
