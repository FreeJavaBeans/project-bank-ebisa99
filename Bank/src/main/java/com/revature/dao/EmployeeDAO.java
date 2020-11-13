package com.revature.dao;

import java.util.List;

import com.revature.pojo.*;

public interface EmployeeDAO {
	public void createEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public List<Integer> employeeLogin();
	public void viewCustomerBA(Account account);
	public void viewTransaction(Transaction tans);
	public void approveOrReject(int id);
	
}
