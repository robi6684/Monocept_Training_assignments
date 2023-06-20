package com.monocept.shoppingcart;

public class Product {
	private int id;
	private String name;
	private double price;
	private double discountPercent;
	public Product(int id, String name, double price, double discountPercent) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountPercent = discountPercent;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public double calculateDiscountedPrice() {
		return (price - (price * (discountPercent)/100));
	}
	@Override
	public String toString() {
		return "price=" + price;
	}
	
}
