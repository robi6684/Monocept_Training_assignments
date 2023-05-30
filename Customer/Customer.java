package com.monocept.oops1;

public class Customer {
	
	private int custid;
	private String name;
	private String email;
	private String password;
	
	Customer()
	{
		custid = 0;
		name = null;
		email = null;
		password = null;
	}
	
	Customer(int custid, String name, String email, String password)
	{
		this.custid = custid;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void display()
	{
		System.out.println("Customer ID : " + custid);
		System.out.println("Customer Name : " + name);
		System.out.println("Customer Email : " + email);
	}

}
