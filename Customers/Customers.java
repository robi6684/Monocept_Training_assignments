package com.monocept.enums;

public class Customers {
	
	private int custid;
	private String name;
	private String email;
	private String password;
	
	Customers()
	{
		custid = 0;
		name = null;
		email = null;
		password = null;
	}
	
	Customers(int custid, String name, String email, String password)
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
	
	public String toString() {
		return "Name : " + name + "\t" + "Customer ID : " + custid + "\t"  + "Email : " + email;
	}

}
