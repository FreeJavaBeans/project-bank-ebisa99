package com.revature.service;
import com.revature.dao.*;
import com.revature.pojo.*;
import java.util.*;
public class RequestResponseService {
	private RequestResponsePostgres pos = new RequestResponsePostgres();
	private Scanner sc = new Scanner(System.in);
	public void createUserRequest()
	{
		System.out.println("CHECKING OR SAVING?.");
		String request = sc.nextLine();
		System.out.println("please enter request date.");
		String reqDate = sc.nextLine();
		 Request req = new Request(request, reqDate);
		pos.createUserRequest(req);
	}
	public void createCustomerRequest()
	{
		System.out.println("do you want to open checking or saving account?.");
		String request = sc.nextLine();
		System.out.println("enter request date.");
		String reqDate = sc.nextLine();
		 CustomerRequest req = new CustomerRequest(request, reqDate);
		pos.createCustomerRequest(req);
	}
	public void createUserResponse()
	{
		System.out.println("\nplease enter your response.");
		String response = sc.nextLine();
		System.out.println("please enter employee ID.");
		int emp_id = sc.nextInt();
		 Response res = new Response(response, emp_id);
		pos.createUserResponse(res);
	}
	public void viewEmployeeResponse()
	{
		System.out.println();
		pos.viewUserResponse();
	}
}
