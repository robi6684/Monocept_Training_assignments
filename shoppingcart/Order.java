package com.monocept.shoppingcart;

import java.util.List;

public class Order {
	private int id;
	private String date;
	private List<LineItem>items;
	public Order(int id, String date, List<LineItem> items) {
		super();
		this.id = id;
		this.date = date;
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<LineItem> getItems() {
		return items;
	}
	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	
	public double calculateOrderPrice() {
		return items.stream().map((item) -> item.calculateLineItemCost()).reduce(0.0,(item1,item2) -> item1 + item2);
	}
	
	@Override
	public String toString() {
		return date + " " + items;
	}
	

}
