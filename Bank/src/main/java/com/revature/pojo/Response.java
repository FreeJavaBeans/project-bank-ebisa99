package com.revature.pojo;

public class Response {
	private String response;
	private int emp_id;
	public Response(String response, int emp_id) {
		super();
		this.response = response;
		this.emp_id = emp_id;
	}
	public Response()
	{}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
}
