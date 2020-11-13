package com.revature.dao;
import java.util.List;

import com.revature.pojo.*;
public interface CustomerDAO {
	public void createCustomer(Customer customer);
	public void viewAllCustomer();
	public void viewCustomer(int cu_id);
	public void deleteCustomer(int cu_id);
	public void updateCustomer(Customer customer);
	public List<String> customerLogin();
}
