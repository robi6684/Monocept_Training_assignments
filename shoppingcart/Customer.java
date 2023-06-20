package com.monocept.shoppingcart;

import java.util.List;

public class Customer {
	private int id;
	private String name;
	private List<Order> orders;
	public Customer(int id, String name, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.orders = orders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
		

}
