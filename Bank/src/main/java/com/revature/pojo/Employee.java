package com.revature.pojo;

public class Employee {
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	private String firstName;
	private String lastName;
	private String hiredate;
	public Employee(String firstName, String lastName, String hiredate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.hiredate = hiredate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
