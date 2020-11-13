package com.revature.pojo;

public class Request {
	private String requestType;
	private String requestDate;
	public Request(String requestType, String requestDate) {
		super();
		this.requestType = requestType;
		this.requestDate = requestDate;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
}
