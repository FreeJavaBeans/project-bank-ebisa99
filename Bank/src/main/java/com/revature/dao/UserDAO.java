package com.revature.dao;
import java.util.List;

import com.revature.pojo.*;
public interface UserDAO {
	public void createUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<String> userLogin();
	public void registerForCustomerAccount(User user);
}
